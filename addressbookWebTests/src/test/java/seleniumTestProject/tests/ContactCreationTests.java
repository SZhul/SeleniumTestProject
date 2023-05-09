package seleniumTestProject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;



public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().addNewContact();
        ContactData contact = new ContactData(
                "Создаем новый",
                "Контакт");
        app.getContactHelper().fillContacts((contact),
                true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
