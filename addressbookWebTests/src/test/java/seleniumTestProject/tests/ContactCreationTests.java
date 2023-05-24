package seleniumTestProject.tests;


import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().allHamcrestAllPhones();
        ContactData contact = new ContactData().withName("Создаем новый").withLastName("Контакт");
        app.goTo().addNewContact();
        File photo = new File("src/test/resources/kitty.jpg");
        app.contact().fillContacts((contact.withName("test_name").withLastName("test_surname").withPhoto(photo)),
                true);
        app.contact().submitContactCreation();
        app.goTo().homePage();
        Contacts after = app.contact().allHamcrestAllPhones();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testCurrentDirectory(){
        File currentDir = new File(".");
        File photo = new File("src/test/resources/kitty.jpg");
        System.out.println(currentDir.getAbsolutePath());
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());

    }
}
