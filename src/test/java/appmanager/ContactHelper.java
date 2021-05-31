package appmanager;

import dto.*;
import org.openqa.selenium.*;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void submitContactCreation() {
        driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

    public void fillTheContactCreationForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys(contactData.getSecondName());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
        driver.findElement(By.name("address2")).click();
        driver.findElement(By.name("address2")).sendKeys(contactData.getSecondAddress());
    }

    public void createNewContact() {
        driver.findElement(By.linkText("add new")).click();
    }
}
