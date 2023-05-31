package seleniumTestProject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTestProject.model.GroupData;
import seleniumTestProject.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[]{new GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGroupFooter(split[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }


  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().all();


    assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testBadGroupCreation() throws Exception {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    GroupData group = new GroupData().withGroupName("test2'");
//    app.group().create(group);
//    assertThat(app.group().getGroupCount(), equalTo(before.size()));
//    Groups after = app.group().all();
//
//
//    assertThat(after, equalTo(before));
//  }
}
