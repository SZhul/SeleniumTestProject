package seleniumTestProject.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;
import seleniumTestProject.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0){
            app.group().create(new GroupData().withGroupName("test1"));
        }
    }

    @Test
    public void testGroupDeletionTests() throws Exception {

        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().deleteAndReturnToGroupPage(deletedGroup);
        assertThat(app.group().getGroupCount(), equalTo(before.size() - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));

    }


}
