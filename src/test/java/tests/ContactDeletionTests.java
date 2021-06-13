package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereContactPresent()) {
            app.getContactHelper().createContact(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptDeletion();
        app.getNavigationHelper().goToHomePage();

        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
