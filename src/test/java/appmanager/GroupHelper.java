package appmanager;

import dto.*;
import org.openqa.selenium.*;

import java.util.*;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillTheGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillTheGroupForm(group);
        submitGroupCreation();
    }

    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillTheGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteGroup();
        returnToGroupPage();
    }

    public boolean isThereGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(name, null, null, id);
            groups.add(group);
        }
        return groups;
    }
}
