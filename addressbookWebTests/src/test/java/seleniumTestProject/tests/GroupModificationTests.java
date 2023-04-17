package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroups();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitToGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
