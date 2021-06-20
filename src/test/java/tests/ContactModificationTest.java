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
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("ron")
                    .withSecondName("makkeyn")
                    .withLastName("ho")
                    .withMobilePhone("1232412")
                    .withSecondAddress("sovetskaya St")
                    .withGroup("my"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withFirstName("ron")
                .withLastName("modified")
                .withId(modifiedContact.getId());

        app.contact().modify(contact);

        Set<ContactData> after = app.contact().all();

        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);

        Assert.assertEquals(before, after);
    }
}
