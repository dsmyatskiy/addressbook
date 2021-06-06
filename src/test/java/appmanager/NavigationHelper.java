package appmanager;

import org.openqa.selenium.*;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        click((By.linkText("groups")));
    }

    public void goToContactsPage() {
        click(By.linkText("home"));
    }
}
