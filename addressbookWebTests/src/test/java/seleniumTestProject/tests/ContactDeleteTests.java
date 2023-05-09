package seleniumTestProject.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;

import java.time.Duration;
import java.util.List;


public class ContactDeleteTests extends TestBase {

    @Test
    public void testContactDelete() {
        if (!app.getNavigationHelper().isThereAContact()) {
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createNewContact(new ContactData(
                    "Создаем",
                    "Тестовый контакт для удаления")
            );
            app.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().mainPageContactCheckboxClick(before.size() - 1);
        app.getNavigationHelper().mainPageDeleteButton();
        app.getNavigationHelper().mainPageAfterDeleteAllertClick();
        app.getNavigationHelper().waitForElementPresent(
                By.cssSelector("div.msgbox"),
                "Не найден элемент на странице",
                Duration.ofSeconds(5)
        );
        app.getNavigationHelper().clickHomePageTopMenu();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);


        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }


}
