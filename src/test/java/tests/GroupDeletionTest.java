package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("my", null, "2"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;

        app.group().delete(index);

        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
