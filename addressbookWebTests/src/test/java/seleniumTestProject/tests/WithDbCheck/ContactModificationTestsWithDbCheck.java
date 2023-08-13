package seleniumTestProject.tests.WithDbCheck;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;
import seleniumTestProject.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTestsWithDbCheck extends TestBase {

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
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId((modifiedContact).getId())
                .withName("Change")
                .withLastName("Next Contact");
        app.goTo().EditContactsFromMainPageById(modifiedContact.getId());
        app.contact().modify(contact);
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }


}
