package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;

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

        Contacts before = app.contact().allHamcrestSplitPhones();
        ContactData deletedContact = before.iterator().next();
        app.goTo().delete(deletedContact);
        Contacts after = app.contact().allHamcrestSplitPhones();
        Assert.assertEquals(after.size(), before.size() - 1);



        assertThat(after, equalTo(before.withOut(deletedContact)));

    }
}
