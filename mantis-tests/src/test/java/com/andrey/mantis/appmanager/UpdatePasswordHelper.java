package com.andrey.mantis.appmanager;

import com.andrey.mantis.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdatePasswordHelper extends HelperBase {

  public UpdatePasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Login']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
    click(By.linkText("Manage Users"));
    click(By.linkText("user1"));
    click(By.xpath("//input[@value='Reset Password']"));
    click(By.linkText("Proceed"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("span.bigger-110"));
  }
}
