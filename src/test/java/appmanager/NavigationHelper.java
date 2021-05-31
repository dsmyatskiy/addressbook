package appmanager;

import org.openqa.selenium.*;

public class NavigationHelper {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver =driver;
    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }
}
