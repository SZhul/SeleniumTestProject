package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;

public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDeletionTests() throws Exception {
        app.getNavigationHelper().goToGroups();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("testRecreate1", "testRecreate2", "testRecreate3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
