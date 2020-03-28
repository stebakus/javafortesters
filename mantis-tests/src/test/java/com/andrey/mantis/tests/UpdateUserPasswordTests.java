package com.andrey.mantis.tests;

import com.andrey.mantis.appmanager.HttpSession;
import com.andrey.mantis.models.MailMessage;
import com.andrey.mantis.models.UsersData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class UpdateUserPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testUpdateUserPassword() throws IOException, MessagingException {
    app.loginAndVerification().start("administrator", "test");
    List<UsersData> contacts = app.loginAndVerification().getUsersList();
    String user = contacts.get(2).getUsername();
    String email = contacts.get(2).getEmail();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.loginAndVerification().finish(confirmationLink, "test");
    HttpSession session = app.newSession();
    assertTrue(session.login(user));
    assertTrue(session.isLoggedInAs(user));

    System.out.println(contacts.get(2).getUsername());
    System.out.println(contacts.get(2).getEmail());
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }


}
