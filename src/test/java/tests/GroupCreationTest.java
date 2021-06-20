package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        app.goTo().groupPage();

        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("my");
        app.group().create(group);
        app.goTo().groupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
