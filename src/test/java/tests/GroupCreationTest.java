package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[]{new GroupData().withName("test2").withHeader("header2").withFooter("footer3")});
        list.add(new Object[]{new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
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
