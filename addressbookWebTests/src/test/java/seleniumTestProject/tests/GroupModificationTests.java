package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroups();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("testRecreate1", "testRecreate2", "testRecreate3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("testModify1", "testModify2", "testModify3"));
        app.getGroupHelper().submitToGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
