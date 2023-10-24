package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;
import seleniumTestProject.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0){
            app.group().create(new GroupData().withGroupName("test1"));
        }
    }

    @Test
    public void testGroupModification(){

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withGroupName("testModify1")
                .withGroupHeader("testModify2")
                .withGroupFooter("testModify3");
        app.group().modify(group);
        assertThat(app.group().getGroupCount(), equalTo(before.size()));
        Groups after = app.group().all();

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
