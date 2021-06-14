package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

import java.util.*;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        if (!app.getContactHelper().isThereContactPresent()) {
            app.getContactHelper().createContact(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().editContact();
        ContactData contact = new ContactData("ron",
                "modified",
                0);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().confirmModification();
        app.getNavigationHelper().goToHomePage();
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
