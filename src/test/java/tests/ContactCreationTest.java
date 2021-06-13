package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getGroupHelper().getGroupCount();

        app.getContactHelper().createContact(new ContactData("ron",
                "makkeyn",
                "ho",
                "1232412",
                "sovetskaya St",
                "my"));
        app.getNavigationHelper().goToHomePage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }
}
