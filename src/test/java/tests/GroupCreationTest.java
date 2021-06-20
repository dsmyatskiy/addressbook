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

        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("my");
        app.group().create(group);
        app.goTo().groupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.withId(max);
        before.add(group);
        Comparator<? super GroupData> byId = (Comparator.comparingInt(GroupData::getId));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
