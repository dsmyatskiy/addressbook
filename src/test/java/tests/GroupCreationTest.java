package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

import java.util.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        app.getNavigationHelper().goToGroupPage();

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().createGroup(new GroupData("my", null, "2"));
        app.getNavigationHelper().goToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
