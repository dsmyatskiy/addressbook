package tests;

import appmanager.*;
import dto.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("ron", "makkeyn", "ho", "1232412", "sovetskaya St", "my"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();

        app.contact().delete();

        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }
}
