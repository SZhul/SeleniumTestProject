package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.GroupData;
import seleniumTestProject.model.Groups;

import java.util.*;
import java.util.stream.Collectors;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupHeader());
        type(By.name("group_footer"), groupData.getGroupFooter());
        click(By.xpath("//div[@id='content']/form"));
    }

    public void initNewGroup() {
        click(By.name("new"));
    }

    public void deleteGroup() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    public void selectGroupById(int id) {
        wd.findElement(By.xpath("//input[@value='" + id + "']")).click();
    }

    public void initGroupModification(){
        click(By.name("edit"));
    }

    public void submitToGroupModification(){
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initNewGroup();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitToGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitToGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void deleteAndReturnToGroupPage(int index) {
        selectGroup(index);
        deleteGroup();
        groupCache = null;
        returnToGroupPage();
    }

    public void deleteAndReturnToGroupPage(GroupData deletedGroup) {
        selectGroupById(deletedGroup.getId());
        deleteGroup();
        groupCache = null;
        returnToGroupPage();
    }



    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withGroupName(name));
        }
        return groups;
    }


    private Groups groupCache = null;
    public Groups all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withGroupName(name));
        }
        return new Groups(groupCache);
    }
}
