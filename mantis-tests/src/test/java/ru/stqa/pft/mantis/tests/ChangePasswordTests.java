package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static ru.stqa.pft.mantis.tools.Sleep.sleep;

public class ChangePasswordTests extends TestBase {

    @BeforeMethod
    public void starMailServer() {
        app.mail().start();
    }

    @Test
    public void changePassword() throws IOException, MessagingException {
        app.registration().authorize("administrator", "root");
        sleep(5);
        app.registration().goToAllUsers();
        app.registration().seeAllUsers();
        app.registration().clickToUserFromTable(5);
        String email = app.registration().getEmailToSend();
        String user = app.registration().getUserToSend();
        app.registration().resetPassword();
        List<MailMessage> letter = app.mail().waitForMail(1, 10000);
        app.registration().getLetterText();
        String resetLink = findResetPasswordLink(letter, email);
        System.out.println(resetLink);
        String password = app.registration().enterNewPassword(resetLink, "password");
        assertTrue(app.newSession().login(user, password));
    }

    private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}

