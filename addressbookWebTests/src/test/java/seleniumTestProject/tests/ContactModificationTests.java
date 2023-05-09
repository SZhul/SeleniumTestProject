package seleniumTestProject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getNavigationHelper().isThereAEditContactIcon()) {
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createNewContact(
                    new ContactData(
                            "Создаем контакт",
                            "Для модификации"));
            app.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToEditContactsFromMainPage(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Изменяем",  "Еще один контакт");
        app.getContactHelper().fillContacts(contact, false);
        app.getContactHelper().updateContactAfterEditing();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
