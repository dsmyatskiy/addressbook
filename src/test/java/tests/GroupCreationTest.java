package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

import java.util.*;

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
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
    }
}
