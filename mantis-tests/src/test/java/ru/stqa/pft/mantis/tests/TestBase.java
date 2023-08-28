package ru.stqa.pft.mantis.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.Browser.*;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", FIREFOX.browserName()));


    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}
