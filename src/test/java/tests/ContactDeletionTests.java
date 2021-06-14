package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

import java.util.*;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereContactPresent()) {
            app.getContactHelper().createContact(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptDeletion();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }
}
