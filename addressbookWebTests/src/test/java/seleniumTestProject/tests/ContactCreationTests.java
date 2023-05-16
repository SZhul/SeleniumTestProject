package seleniumTestProject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Comparator;
import java.util.List;



public class ContactCreationTests extends TestBase {

    @Test()
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withName("Создаем новый").withLastName("Контакт");

        app.goTo().addNewContact();

        app.contact().fillContacts((contact),
                true);
        app.contact().submitContactCreation();
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
