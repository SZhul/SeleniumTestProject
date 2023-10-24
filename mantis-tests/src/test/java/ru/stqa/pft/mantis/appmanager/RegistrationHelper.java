package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


public class RegistrationHelper extends HelperBase {


    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseURL") + "signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Зарегистрироваться']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Изменить учетную запись']"));
    }

    public void authorize(String username, String password) {
        wd.get(app.getProperty("web.baseURL") + "login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.xpath("//*[@value='Войти']"));
    }


    public void goToAllUsers() {
        click(By.xpath("//*[@href='/mantisbt-1.3.20/manage_overview_page.php']"));
        click(By.xpath("//*[text()='Управление пользователями']"));
    }

    public void clickToUserFromTable(int count) {
        click(By.xpath("//div[@id='manage-user-div']//*[@href='manage_user_edit_page.php?user_id=" + count + "']"));
    }

    public List<WebElement> getAllUser() {
        List<WebElement> userList = wd.findElements(By.xpath("//div[@id='manage-user-div']//*[td]//td[1]"));
        return userList;
    }

    public void seeAllUsers() {
        List<WebElement> userList = wd.findElements(By.xpath("//div[@id='manage-user-div']//*[td]//td[1]"));
        for (WebElement e : userList) {
            System.out.println(e.getText());
        }
    }

    public void goToUserFromTable(int count) {
        List<WebElement> userList = wd.findElements(By.xpath("//div[@id='manage-user-div']//*[@href='manage_user_edit_page.php?user_id=" + count + "']"));
        int a = userList.size();
        if (a - 1 > 1) {
            clickToUserFromTable(a);
        } else {
            System.out.println("Нельзя менять данные для администратора");
        }
    }

    public String getEmailToSend() {
        return wd.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
    }

    public String getUserToSend(){
        return wd.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
    }

    public void resetPassword() {
        click(By.xpath("//*[@value='Сбросить пароль']"));
    }

    public void getLetterText() throws MessagingException, IOException {
        List<MailMessage> letter = app.mail().waitForMail(1, 10000);
        for (MailMessage l : letter
        ) {
            System.out.println(l.text);
        }
    }

    public String enterNewPassword(String resetLink, String password) {
        wd.get(resetLink);
        type(By.xpath("//*[@name='password']"), password);
        type(By.xpath("//*[@name='password_confirm']"), password);
        click(By.xpath("//*[@value='Изменить учетную запись']"));
        return password;
    }
}
