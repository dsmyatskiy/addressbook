package appmanager;

import org.openqa.selenium.*;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }
    public void login(String user, String password) {
        type(By.name("user"), user);
        type(By.name("pass"), password);
        click(By.cssSelector("input:nth-child(7)"));
    }
}
