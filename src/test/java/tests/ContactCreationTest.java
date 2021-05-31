package tests;

import dto.*;
import org.junit.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillTheContactCreationForm(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St"));
        app.getContactHelper().submitContactCreation();
    }
}
