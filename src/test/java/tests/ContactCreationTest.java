package tests;

import appmanager.*;
import dto.*;
import org.junit.*;

import java.util.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("ron",
                "makkeyn",
                "ho",
                "1232412",
                "sovetskaya St",
                "my");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToHomePage();

        app.getContactHelper().getContactList();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (ContactData cd : after) {
            if (cd.getId() > max) {
                max = cd.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        Comparator<? super ContactData> byId = (Comparator.comparingInt(ContactData::getId));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
