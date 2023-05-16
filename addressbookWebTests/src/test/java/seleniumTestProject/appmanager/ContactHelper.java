package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import seleniumTestProject.model.ContactData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContacts(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("middlename"), contactData.getSecondName());
        type(By.name("lastname"), contactData.getLastName());

        if (creation) {
            if((isElementPresent(By.xpath("//select[@name='new_group']//option[@value!='[none]']")))){
                new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
            }
            else{
                new Select(wd.findElement(By.name("new_group"))).selectByValue("[none]");
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")), "Нет групп для добавления контакта");
        }
    }



    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void updateContactAfterEditing() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void create(ContactData contact) {
            fillContacts(contact, true);
            submitContactCreation();
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//*[@name='selected[]']")).size();
    }

    public void modify(ContactData contact) {
        fillContacts(contact, false);
        updateContactAfterEditing();
    }


    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements){
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
