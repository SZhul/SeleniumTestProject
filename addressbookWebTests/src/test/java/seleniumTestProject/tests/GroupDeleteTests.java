package seleniumTestProject.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;

import java.util.List;

public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDeletionTests() throws Exception {
        app.getNavigationHelper().goToGroups();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("testRecreate1", "testRecreate2", "testRecreate3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);

//        цикл для сравнения списков. По факту он не нужен, т.к. Assert сам сравнивает списки
//
//        for (int i = 0; i < after.size(); i++){
//            Assert.assertEquals(before.get(i), after.get(i));
//        }
        Assert.assertEquals(before, after);

    }
}
