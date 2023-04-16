package seleniumTestProject;


import org.testng.annotations.*;


public class GroupDeletionTests extends TestBase{


  @Test
  public void testGroupDeletionTests() throws Exception {
    goToGroups();
    selectGroup();
    deleteGroup();
    returnToGroupPage();
  }

}
