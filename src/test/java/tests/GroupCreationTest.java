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
        GroupData group = new GroupData("my", null, "2");
        app.getGroupHelper().createGroup(group);
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Comparator<? super GroupData> byId = (Comparator.comparingInt(GroupData::getId));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
