package seleniumTestProject.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase{

    @Test
    public void testContactDelete(){
        app.getNavigationHelper().mainPageContactCheckbox();
        app.getNavigationHelper().mainPageDeleteButton();
        app.getNavigationHelper().mainPageAfterDeleteAllertClick();
    }
}
