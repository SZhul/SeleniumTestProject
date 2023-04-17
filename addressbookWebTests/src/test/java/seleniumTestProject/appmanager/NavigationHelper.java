package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroups() {
        click(By.linkText("groups"));
    }

    public void logout() {
        click(By.linkText("Logout"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void goToHomePage() {
        click(By.linkText("home page"));
    }
}
