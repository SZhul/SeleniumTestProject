package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContacts(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            if ((isElementPresent(By.xpath("//select[@name='new_group']//option[@value!='[none]']")))) {
                new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
            } else {
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
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName);
            contacts.add(contact);
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String[] phones = e.findElement(By.xpath(".//td[6]")).getText().split("\n");
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts allHamcrestSplitPhones() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String[] phones = e.findElement(By.xpath(".//td[6]")).getText().split("\n");
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts allHamcrestAllPhones() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String allPhones = e.findElement(By.xpath(".//td[6]")).getText();
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withAllPhones(allPhones);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts allHamcrest(){
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String allPhones = e.findElement(By.xpath(".//td[6]")).getText();
            String allEmails = e.findElement(By.xpath(".//td[5]")).getText();
            String allAddresses = e.findElement(By.xpath(".//td[4]")).getText();
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(allAddresses);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts allHamcrestSplitEmails() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String[] emails = e.findElement(By.xpath(".//td[5]")).getText().split("\n");
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withEmail(emails[0]).withEmail2(emails[1]).withEmail3(emails[2]);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts allHamcrestAllEmails() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String allEmails = e.findElement(By.xpath(".//td[5]")).getText();
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withAllEmails(allEmails);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts allHamcrestAddress() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//*[@name='entry']"));
        for (WebElement e : elements) {
            String name = e.findElement(By.xpath(".//td[3]")).getText();
            String lastName = e.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            String allAddresses = e.findElement(By.xpath(".//td[4]")).getText();
            ContactData contact = new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withAddress(allAddresses);
            contacts.add(contact);
        }
        return contacts;
    }


}
