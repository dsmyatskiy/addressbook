package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData("my", null, "2"));
        }

        int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();

        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
