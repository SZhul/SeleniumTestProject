package seleniumTestProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void homePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home page"));
    }



    public void clickHomePageTopMenu(){
        click(By.xpath("//a[text()='home']"));
    }

    public void logout() {
        click(By.linkText("Logout"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }



    public void EditContactsFromMainPage(int index){
        wd.findElements(By.xpath("//*[@title='Edit']")).get(index).click();
    }
    public void mainPageContactCheckboxClick(int index){
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public WebElement waitForElementPresent(By by, String errorMessage, Duration timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(wd, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public void delete(int index) {
        mainPageContactCheckboxClick(index);
        mainPageDeleteButton();
        mainPageAfterDeleteAllertClick();
        waitForElementPresent(
                By.cssSelector("div.msgbox"),
                "Не найден элемент на странице",
                Duration.ofSeconds(5)
        );
        clickHomePageTopMenu();
    }
}
