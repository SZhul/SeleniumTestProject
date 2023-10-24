package ru.stqa.pft.mantis.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTestsJames extends TestBase {



    @Test
    public void testRegistration() throws MessagingException, IOException {
        long now = System.currentTimeMillis();
        String user = String.format("user%s", now);
        String email = String.format("user%s@localhost.localdomain", now);
        String password = "password";

        app.james().createUser(user, password);


        app.registration().start(user, email);
        List<ru.stqa.pft.mantis.model.MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink((mailMessages), email);
        app.registration().finish(confirmationLink, password);
        app.newSession().login(user, password);
        assertTrue(app.newSession().login(user, password));
    }


    private String findConfirmationLink(List<ru.stqa.pft.mantis.model.MailMessage> mailMessages, String email) {
        ru.stqa.pft.mantis.model.MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


}
