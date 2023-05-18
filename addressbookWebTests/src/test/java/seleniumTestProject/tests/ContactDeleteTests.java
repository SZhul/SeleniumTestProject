package seleniumTestProject.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


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

        Contacts before = app.contact().allHamcrest();
        ContactData deletedContact = before.iterator().next();
        app.goTo().delete(deletedContact);
        Contacts after = app.contact().allHamcrest();
        Assert.assertEquals(after.size(), before.size() - 1);



        assertThat(after, equalTo(before.withOut(deletedContact)));

    }
}
