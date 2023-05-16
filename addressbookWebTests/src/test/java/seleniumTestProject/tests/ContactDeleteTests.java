package seleniumTestProject.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.time.Duration;
import java.util.List;


public class ContactDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!app.goTo().isThereAContact()) {
            app.goTo().addNewContact();
            app.contact().create(new ContactData().withName("Создаем").withLastName("Контакт для удаления"));
            app.goTo().homePage();
        }
    }

    @Test()
    public void testContactDelete() {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.goTo().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);
    }




}
