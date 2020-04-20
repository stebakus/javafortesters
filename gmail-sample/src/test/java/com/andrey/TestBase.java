package com.andrey;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;


public class TestBase {

  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.stop();
  }

}
















