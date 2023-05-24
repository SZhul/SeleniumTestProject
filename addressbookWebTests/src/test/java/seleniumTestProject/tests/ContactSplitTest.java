package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactSplitTest extends TestBase {

    @Test(enabled = false)
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().allHamcrestSplitPhones().iterator().next();
        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleanedPhones(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleanedPhones(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleanedPhones(contactInfoFromEditForm.getWorkPhone())));
    }

    @Test(enabled = false)
    public void testSplitContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().allHamcrestSplitEmails().iterator().next();
        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(cleanedPhones(contactInfoFromEditForm.getEmail())));
        assertThat(contact.getEmail2(), equalTo(cleanedPhones(contactInfoFromEditForm.getEmail2())));
        assertThat(contact.getEmail3(), equalTo(cleanedPhones(contactInfoFromEditForm.getEmail3())));
    }

    public static String cleanedPhones(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public static String cleanedEmails(String email) {
        return email.replaceAll("[-()]", "");
    }

}

