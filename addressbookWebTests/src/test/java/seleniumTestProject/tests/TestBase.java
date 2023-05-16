package seleniumTestProject.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import seleniumTestProject.appmanager.ApplicationManager;


import static org.openqa.selenium.remote.Browser.*;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(FIREFOX.browserName());

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}
