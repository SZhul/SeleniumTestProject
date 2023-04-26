package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.GroupData;

public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete(){
        if(! app.getNavigationHelper().isThereAContact()){
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createNewContact(new ContactData("Вася", "Петя", "Сережа", "testModify1"), true);
            app.getNavigationHelper().goToHomePage();
        }
        app.getNavigationHelper().mainPageContactCheckbox();
        app.getNavigationHelper().mainPageDeleteButton();
        app.getNavigationHelper().mainPageAfterDeleteAllertClick();
    }
}
