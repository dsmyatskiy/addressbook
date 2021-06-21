package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        app.goTo().groupPage();

        Groups before = app.group().all();
        GroupData group = new GroupData().withName("my");
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
