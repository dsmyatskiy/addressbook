package appmanager;

import org.openqa.selenium.*;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String user, String password) {
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.id("LoginForm")).click();
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }
}
