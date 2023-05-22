package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {

    @Test
    public void testAddressesWithCollect() {
        app.goTo().homePage();
        ContactData contact = app.contact().allHamcrestAddress().iterator().next();
        ContactData contactInfoFromEditForm = app.goTo().infoFromEditForm(contact);


        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

}

