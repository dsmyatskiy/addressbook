package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

import java.util.*;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData("my", null, "2"));
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
