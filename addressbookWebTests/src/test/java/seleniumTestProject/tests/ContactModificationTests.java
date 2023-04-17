package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToEditContactsFromMainPage();
        app.getContactHelper().editContacts(new ContactData("AfterEdit Name", "AfterEdin SecondName", "AfterEdit LastName"));
        app.getNavigationHelper().goToHomePage();
    }
}
