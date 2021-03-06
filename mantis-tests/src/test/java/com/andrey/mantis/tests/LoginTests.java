package com.andrey.mantis.tests;

import com.andrey.mantis.appmanager.HttpSession;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase  {


  @Test

  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
