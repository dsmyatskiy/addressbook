package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;

import java.io.*;
import java.util.*;

public class ApplicationManager {
    WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private final String browser;

    FileInputStream fis;
    Properties property = new Properties();

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String host = property.getProperty("host");
        String login = property.getProperty("login");
        String password = property.getProperty("password");


        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.get(host);
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login(login, password);
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
