package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();

        app.getGroupHelper().createGroup(new GroupData("my", null, "2"));
        app.getNavigationHelper().goToGroupPage();

        int after = app.getGroupHelper().getGroupCount();

        Assert.assertEquals(after, before + 1);
    }
}
