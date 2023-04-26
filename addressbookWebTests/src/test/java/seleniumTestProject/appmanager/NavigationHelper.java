package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroups() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home page"));
    }

    public void logout() {
        click(By.linkText("Logout"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }



    public void goToEditContactsFromMainPage(){
        click(By.xpath("//img[@alt='Edit']"));
    }
    public void mainPageContactCheckbox(){
        click(By.name("selected[]"));
    }
    public void mainPageDeleteButton(){
        click(By.xpath("//input[@value='Delete']"));
    }

    public void mainPageAfterDeleteAllertClick(){
        wd.switchTo().alert().accept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isThereAEditContactIcon() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    }
}
