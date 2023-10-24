package tests.WithDbCheck;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;
import tests.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTestWithDbCheck extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!app.goTo().isThereAContact()) {
            app.goTo().addNewContact();
            app.contact().create(new ContactData().withName("Создаем").withLastName("Контакт для добавления в группу"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactAdd(ContactData contact) throws Exception {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.goTo().delete(deletedContact);
        app.goTo().mainPageContactCheckboxClickById(195);
        app.goTo().addNewContact();
        File photo = new File("src/test/resources/kitty.jpg");
        app.contact().fillContacts((contact),
                true);
        app.contact().submitContactCreation();
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }


}
