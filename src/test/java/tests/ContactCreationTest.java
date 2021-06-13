package tests;

import dto.*;
import org.junit.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreateTest() {
        app.getContactHelper().createContact(new ContactData("ron",
                "makkeyn",
                "ho",
                "1232412",
                "sovetskaya St",
                "my"));
    }
}
