package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getNavigationHelper().isThereAEditContactIcon()) {
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createNewContact(
                    new ContactData(
                            "Создаем",
                            "Тестовый контакт",
                            "Для модификации"));
            app.getNavigationHelper().goToHomePage();
        }
        app.getNavigationHelper().goToEditContactsFromMainPage();
        app.getContactHelper().fillContacts(new ContactData("Имя после модификации", "Отчество после модификации", "Фамлиия после модификации", null), false);
        app.getContactHelper().updateContactAfterEditing();
        app.getNavigationHelper().goToHomePage();
    }
}
