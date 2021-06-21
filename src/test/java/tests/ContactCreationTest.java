package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("ron")
                .withSecondName("makkeyn")
                .withLastName("ho")
                .withMobilePhone("1232412")
                .withSecondAddress("sovetskaya St")
                .withGroup("my");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
    }
}
