package appmanager;

import dto.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;

import java.util.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactCreation() {
        click(By.cssSelector("input:nth-child(87)"));
    }

    public void fillContactForm(ContactData contactData, Boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getSecondName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("address2"), contactData.getSecondAddress());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initCreateNewContact() {
        click(By.linkText("add new"));
    }

    public void editContact() {

        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void confirmModification() {
        click(By.name("update"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void acceptDeletion() {
        driver.switchTo().alert().accept();
    }

    public boolean isThereContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        initCreateNewContact();
        fillContactForm(contact, true);
        submitContactCreation();
    }

    public void delete() {
        selectContact();
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        acceptDeletion();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        editContact();
        fillContactForm(contact, false);
        confirmModification();
        returnToHomePage();
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String[] listOfText = element.getText().split("\\s");
            String firstName = listOfText[1];
            String lastName = listOfText[0];
            Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            System.out.println(firstName + " /// " + lastName + " /// " + id);
            contacts.add( new ContactData().withFirstName(firstName).withLastName(lastName).withId(id));
        }
        return contacts;
    }
}
