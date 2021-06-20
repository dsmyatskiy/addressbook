package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData("ron", "modified", 0);

        app.contact().modify(contact);

        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId = (Comparator.comparingInt(ContactData::getId));
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
