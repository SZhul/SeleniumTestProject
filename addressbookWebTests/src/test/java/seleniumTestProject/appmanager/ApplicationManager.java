package seleniumTestProject.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

import static org.openqa.selenium.remote.Browser.*;

public class ApplicationManager {

    WebDriver wd;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private JavascriptExecutor js;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(FIREFOX.browserName())) {
            wd = new FirefoxDriver();
        } else if (browser.equals(CHROME.browserName())) {
            wd = new ChromeDriver();
        } else if (browser.equals(IE.browserName())) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        js = (JavascriptExecutor) wd;
        sessionHelper.login("admin", "secret");
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
}
