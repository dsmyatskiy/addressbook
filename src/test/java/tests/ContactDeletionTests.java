package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    void ensurePreconditions() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereContactPresent()) {
            app.getContactHelper().createContact(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
            app.getNavigationHelper().goToHomePage();
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().deleteContact();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }
}
