package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import seleniumTestProject.model.ContactData;

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

    public void createNewContact(ContactData contact) {
            fillContacts(contact, true);
            submitContactCreation();
    }
}
