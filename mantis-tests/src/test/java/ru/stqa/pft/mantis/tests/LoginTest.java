package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static ru.stqa.pft.mantis.tools.Sleep.sleep;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedAs("administrator"));
    }

}
