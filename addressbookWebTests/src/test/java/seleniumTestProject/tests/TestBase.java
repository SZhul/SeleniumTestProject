package seleniumTestProject.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import seleniumTestProject.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
