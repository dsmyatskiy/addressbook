package tests;

import dto.*;
import org.junit.*;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereContactPresent()) {
            app.getContactHelper().createContact(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Modified ron",
                "makkeyn",
                "ho",
                "1232412",
                "sovetskaya St",
                null), false);
        app.getContactHelper().confirmModification();
        app.getNavigationHelper().goToHomePage();
    }
}
