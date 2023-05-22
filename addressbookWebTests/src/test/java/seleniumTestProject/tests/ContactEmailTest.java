package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase{


    @Test
    public void testSplitContactEmails(){
        app.goTo().homePage();
        ContactData contact = app.contact().allHamcrestSplitEmails().iterator().next();
        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(cleaned(contactInfoFromEditForm.getEmail())));
        assertThat(contact.getEmail2(), equalTo(cleaned(contactInfoFromEditForm.getEmail2())));
        assertThat(contact.getEmail3(), equalTo(cleaned(contactInfoFromEditForm.getEmail3())));
    }

    @Test
    public void testContactEmailsWithCollect(){
        app.goTo().homePage();
        ContactData contact = app.contact().allHamcrestAllEmails().iterator().next();
        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);


        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }


    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email){
        return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
