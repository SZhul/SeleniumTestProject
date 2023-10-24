package tests;


import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactMergeTest extends TestBase {

    @Test
    public void testAllCollect(){
        app.goTo().homePage();
        ContactData contact = app.contact().allHamcrest().iterator().next();
        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);



        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

//    @Test
//    public void testContactPhonesWithCollect() {
//        app.goTo().homePage();
//        ContactData contact = app.contact().allHamcrestAllPhones().iterator().next();
//        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);
//
//
//        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//    }
//
//    @Test
//    public void testContactEmailsWithCollect() {
//        app.goTo().homePage();
//        ContactData contact = app.contact().allHamcrestAllEmails().iterator().next();
//        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);
//
//
//        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
//    }
//
//    @Test
//    public void testAddressesWithCollect() {
//        app.goTo().homePage();
//        ContactData contact = app.contact().allHamcrestAddress().iterator().next();
//        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);
//
//
//        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
//    }


    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactMergeTest::cleanedPhones)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedPhones(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
