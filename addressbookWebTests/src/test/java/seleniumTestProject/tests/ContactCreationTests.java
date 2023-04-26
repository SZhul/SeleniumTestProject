package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception{
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().fillContacts(new ContactData("Вася", "Петя", "Сережа", "testModify1"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}
