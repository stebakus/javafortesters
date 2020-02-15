package com.andrey.addressbook.appmanager;

import com.andrey.addressbook.models.ContactsData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactsData contactsData) {
    type(By.name("firstname"), contactsData.getFirstname());
    type(By.name("lastname"), contactsData.getLastname());
    type(By.name("address"), contactsData.getAddress());
    type(By.name("mobile"), contactsData.getPhonenumber());
    type(By.name("email"), contactsData.getEmailaddress());
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void clickDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void clickModifyContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
}


