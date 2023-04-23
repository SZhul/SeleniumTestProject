package seleniumTestProject.appmanager;

import com.sun.corba.se.spi.ior.ObjectKey;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import sun.plugin2.util.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
        if (browser.equals(FIREFOX.browserName())){
            wd = new FirefoxDriver();
        }
        else if (browser.equals(CHROME.browserName())) {
            wd = new ChromeDriver();
        }
        else if (browser.equals(IE.browserName())){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper(){return contactHelper;}

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() { return  sessionHelper;}
}
