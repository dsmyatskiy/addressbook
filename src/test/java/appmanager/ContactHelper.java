package appmanager;

import dto.*;
import org.openqa.selenium.*;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactCreation() {
       click(By.cssSelector("input:nth-child(87)"));
    }

    public void fillTheContactCreationForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getSecondName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("address2"), contactData.getSecondAddress());
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }
}
