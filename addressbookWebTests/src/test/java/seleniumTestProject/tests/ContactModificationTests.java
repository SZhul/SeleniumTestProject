package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        if(! app.getNavigationHelper().isThereAEditContactIcon()){
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createNewContact(new ContactData("Имя", "Отчество", "Фамилия", "testModify1"));
            app.getNavigationHelper().goToHomePage();
        }
        app.getNavigationHelper().goToEditContactsFromMainPage();
        app.getContactHelper().fillContacts(new ContactData("AfterEdit Name", "AfterEdin SecondName", "AfterEdit LastName", null), false);
        app.getContactHelper().updateContactAfterEditing();
        app.getNavigationHelper().goToHomePage();
    }
}
