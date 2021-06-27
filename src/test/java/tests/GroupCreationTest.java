package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

import java.io.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void groupCreationTest(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
    }

    @Test
    public void badGroupCreationTest() {
        app.goTo().groupPage();

        Groups before = app.group().all();
        GroupData group = new GroupData().withName("my'");
        app.group().create(group);
        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();

        assertThat(after, equalTo(before));
    }
}
