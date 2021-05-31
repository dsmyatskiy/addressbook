package appmanager;

import dto.*;
import org.openqa.selenium.*;

public class GroupHelper {
    private WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillTheGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void createNewGroup() {
        driver.findElement(By.name("new")).click();
    }
}
