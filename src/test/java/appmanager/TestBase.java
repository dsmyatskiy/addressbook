package appmanager;

import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

public class TestBase {

    protected final static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
