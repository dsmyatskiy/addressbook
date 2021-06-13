package tests;

import dto.*;
import org.junit.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createNewGroup();
        app.getGroupHelper().fillTheGroupForm(new GroupData("my", null, "2"));
        app.getGroupHelper().submitGroupCreation();
    }

}
