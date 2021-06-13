package tests;

import org.junit.*;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
