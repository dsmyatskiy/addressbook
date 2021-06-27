package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/picture.png");
        ContactData contact = new ContactData().withFirstName("ron")
                .withFirstName("ron")
                .withSecondName("makkeyn")
                .withLastName("ho")
                .withMobilePhone("1232412")
                .withWorkPhone("1111")
                .withHomePhone("2214")
                .withEmail("email1")
                .withEmail2("email2")
                .withEmail3("email3")
                .withSecondAddress("sovetskaya St")
                .withGroup("my")
                .withPhoto(photo);
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
    }
}
