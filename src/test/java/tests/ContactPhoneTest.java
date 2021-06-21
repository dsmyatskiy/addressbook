package tests;

import appmanager.*;
import dto.*;
import org.testng.annotations.*;

public class ContactPhoneTest extends TestBase {

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
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
