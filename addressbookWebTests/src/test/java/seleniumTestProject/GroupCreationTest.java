package seleniumTestProject;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class GroupCreationTest {
  private WebDriver wd;
  private JavascriptExecutor js;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "D:\\Git\\SeleniumTestProject\\addressbookWebTests\\src\\test\\resources\\geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) wd;
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }


  @Test
  public void testGroupCreation() throws Exception {

    goToGroups();
    initNewGroup();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
    logout();
  }

  @Test
  public void testContactCreation() throws Exception{
    initNewContact();
    fillContacts(new ContactData("Вася", "Петя", "Сережа", "Sergey", "13", "123", "Tomsk", "Home", "Mobile", "Work", "Fax", "email1", "homepage", "8", "April", "1992", "Notes"));
    goToMainPage();
  }

  private void fillContacts(ContactData contactData) {
    fillFirstName(contactData.getName());
    fillMiddleName(contactData.getSecondName());
    fillLastName(contactData.getLastName());
    fillNickName(contactData.getNickname());
    fillTitle(contactData.getTitle());
    fillCompany(contactData.getCompany());
    fillAddress(contactData.getAddress());
    fillHome(contactData.getHome());
    fillMobile(contactData.getMobile());
    fillWork(contactData.getWork());
    fillFax(contactData.getFax());
    fillEmail(contactData.getEmail());
    fillHomepage(contactData.getHomepage());
    selectBday(contactData.getBday());
    selectBmonth(contactData.getBmont());
    fillByear(contactData.getByear());
    fillNotes(contactData.getNotes());
    submitContactCreation();
  }

  private void goToMainPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillNotes(String notes) {
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(notes);
  }

  private void fillByear(String year) {
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(year);
  }

  private void selectBmonth(String mont) {
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(mont);
  }

  private void selectBday(String day) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(day);
  }

  private void fillHomepage(String homepage) {
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(homepage);
  }

  private void fillEmail(String email) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(email);
  }

  private void fillFax(String fax) {
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(fax);
  }

  private void fillWork(String work) {
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(work);
  }

  private void fillMobile(String mobile) {
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobile);
  }

  private void fillHome(String home) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(home);
  }

  private void fillAddress(String address) {
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(address);
  }

  private void fillCompany(String company) {
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
  }

  private void fillTitle(String title) {
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(title);
  }

  private void fillNickName(String nickname) {
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  private void fillLastName(String lastName) {
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(lastName);
  }

  private void fillMiddleName(String secondName) {
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(secondName);
  }

  private void fillFirstName(String name) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(name);
  }

  private void initNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  private void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
    wd.findElement(By.xpath("//div[@id='content']/form")).click();
  }

  private void initNewGroup() {
    wd.findElement(By.name("new")).click();
  }

  private void goToGroups() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
