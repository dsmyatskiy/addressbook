package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstName("ron")
                .withSecondName("makkeyn")
                .withLastName("ho")
                .withMobilePhone("1232412")
                .withSecondAddress("sovetskaya St")
                .withGroup("my");
        app.contact().create(contact);
        app.goTo().homePage();

        app.contact().list();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (ContactData cd : after) {
            if (cd.getId() > max) {
                max = cd.getId();
            }
        }
        contact.withId(max);
        before.add(contact);
        Comparator<? super ContactData> byId = (Comparator.comparingInt(ContactData::getId));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
