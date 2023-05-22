package seleniumTestProject.tests;

import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;
import seleniumTestProject.model.Groups;


import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupName("test2");
    app.group().create(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().all();


    assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupName("test2'");
    app.group().create(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.group().all();


    assertThat(after, equalTo(before));
  }
}
