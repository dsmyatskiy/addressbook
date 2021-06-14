package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

import java.util.*;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData("my", null, "2"));
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("my", "myGroup", "2", before.get(before.size() - 1).getId());
        app.getGroupHelper().fillTheGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
