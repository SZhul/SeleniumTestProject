package seleniumTestProject.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!app.goTo().isThereAEditContactIcon()) {
            app.goTo().addNewContact();
            app.contact().create(
                    new ContactData().withName("Создаем").withLastName("Контакт для модификации"));
            app.goTo().homePage();
        }
    }

    @Test()
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId())
                .withName("Изменяем")
                .withLastName("Еще один контакт");
        app.goTo().EditContactsFromMainPage(index);
        app.contact().modify(contact);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
