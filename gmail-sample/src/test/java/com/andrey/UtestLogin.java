package com.andrey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class UtestLogin extends TestBase{


  private static Object URL = "https://platform.utest.com/dashboard";

  @Test
  public void homepage(){
    app.getDriver().findElement(By.id("username")).click();
    app.getDriver().findElement(By.id("username")).sendKeys("andreybegishev@gmail.com");
    app.getDriver().findElement(By.id("password")).click();
    app.getDriver().findElement(By.id("password")).sendKeys("Kesha13kesha!#");
    app.getDriver().findElement(By.name("login")).click();
    String element = app.getDriver().findElement(By.cssSelector("div.nav-sidebar-user-card-info__name")).getText();
    String name = "Andrey Begishev";

    Assert.assertEquals(element, name);


    //System.out.println(currentUrl);
  }

}
