package seleniumTestProject.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import seleniumTestProject.appmanager.ApplicationManager;


import static org.openqa.selenium.remote.Browser.*;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(FIREFOX.browserName());

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}
