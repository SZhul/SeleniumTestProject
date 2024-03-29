package seleniumTestProject.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import static org.openqa.selenium.remote.Browser.*;

public class ApplicationManager {

    private final Properties properties;
    WebDriver wd;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private JavascriptExecutor js;
    private String browser;
    private DbHelper dbHelper;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DbHelper();
        if (browser.equals(FIREFOX.browserName())) {
            wd = new FirefoxDriver();
        } else if (browser.equals(CHROME.browserName())) {
            wd = new ChromeDriver();
        } else if (browser.equals(IE.browserName())) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wd.get(properties.getProperty("web.baseURL"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        js = (JavascriptExecutor) wd;
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
    public DbHelper db(){
        return dbHelper;
    }
}
