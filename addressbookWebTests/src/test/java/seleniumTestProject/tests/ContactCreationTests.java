package seleniumTestProject.tests;


import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;




import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test()
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().allHamcrestPhones();
        ContactData contact = new ContactData().withName("Создаем новый").withLastName("Контакт");
        app.goTo().addNewContact();

        app.contact().fillContacts((contact),
                true);
        app.contact().submitContactCreation();
        app.goTo().homePage();
        Contacts after = app.contact().allHamcrestPhones();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
    }
}
