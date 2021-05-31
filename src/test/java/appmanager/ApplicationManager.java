package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class ApplicationManager {
    WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;



    public void init() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);

        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
