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
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("ron")
                .withSecondName("makkeyn")
                .withLastName("ho")
                .withMobilePhone("1232412")
                .withSecondAddress("sovetskaya St")
                .withGroup("my");
        app.contact().create(contact);
        app.goTo().homePage();

        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
