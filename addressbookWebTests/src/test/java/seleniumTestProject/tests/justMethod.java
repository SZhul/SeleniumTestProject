package seleniumTestProject.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class justMethod {
    IE.browserName()
    public ApplicationManager(String browser) {
        this.browser = browser;
    }
            if (browser.equals(FIREFOX.browserName())){
        wd = new FirefoxDriver();
    }
        else if (browser.equals(CHROME.browserName())) {
        wd = new ChromeDriver();
    }
        else if (browser.equals(IE.browserName())){
        wd = new InternetExplorerDriver();
    }
}
