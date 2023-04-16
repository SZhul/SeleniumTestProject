package seleniumTestProject;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception{
        initNewContact();
        fillContacts(new ContactData("Вася", "Петя", "Сережа", "Sergey", "13",
                "123", "Tomsk", "Home", "Mobile", "Work", "Fax", "email1",
                "homepage", "8", "April", "1992", "Notes"));
        goToMainPage();
    }
}
