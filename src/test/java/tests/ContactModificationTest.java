package tests;

import dto.*;
import org.junit.*;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactsPage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillTheContactCreationForm(new ContactData("Modified ron", "makkeyn", "ho", "1232412", "sovetskaya St"));
        app.getContactHelper().confirmModification();
        app.getNavigationHelper().goToContactsPage();
    }
}
