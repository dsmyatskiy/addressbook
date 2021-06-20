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

    public void confirmModification() {
        click(By.name("update"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void acceptDeletion() {
        driver.switchTo().alert().accept();
    }


    private void selectContactById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    private void deleteSelectedGroup() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public boolean isThereContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        initCreateNewContact();
        fillContactForm(contact, true);
        submitContactCreation();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedGroup();
        acceptDeletion();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        editContactById(contact.getId());
        fillContactForm(contact, false);
        confirmModification();
        returnToHomePage();
    }

    private void editContactById(int id) {
        click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
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
