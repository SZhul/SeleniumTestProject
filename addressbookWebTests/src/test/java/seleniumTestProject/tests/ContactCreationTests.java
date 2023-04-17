package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception{
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().fillContacts(new ContactData("Вася", "Петя", "Сережа", "Sergey", "13",
                "123", "Tomsk", "Home", "Mobile", "Work", "Fax", "email1",
                "homepage", "8", "April", "1992", "Notes"));
        app.getNavigationHelper().goToHomePage();
    }
}
