package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    void ensurePreconditions() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereContactPresent()) {
            app.getContactHelper().createContact(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
            app.getNavigationHelper().goToHomePage();
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("ron", "modified", 0);

        app.getContactHelper().modifyContact(contact);

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId = (Comparator.comparingInt(ContactData::getId));
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
