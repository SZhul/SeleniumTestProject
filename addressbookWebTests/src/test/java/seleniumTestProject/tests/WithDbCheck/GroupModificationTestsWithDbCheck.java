package seleniumTestProject.tests.WithDbCheck;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;
import seleniumTestProject.model.Groups;
import seleniumTestProject.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTestsWithDbCheck extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withGroupName("test1"));
        }
    }

    @Test
    public void testGroupModificationWithDbCheck(){
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withGroupName("testModify1")
                .withGroupHeader("testModify2")
                .withGroupFooter("testModify3");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().getGroupCount(), equalTo(before.size()));
        Groups after = app.db().groups();

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
