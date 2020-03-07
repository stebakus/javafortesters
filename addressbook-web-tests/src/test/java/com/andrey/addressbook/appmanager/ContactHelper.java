package com.andrey.addressbook.appmanager;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactsData contactsData, boolean creation) {
    type(By.name("firstname"), contactsData.getFirstname());
    type(By.name("lastname"), contactsData.getLastname());
    type(By.name("address"), contactsData.getAddress());
    type(By.name("mobile"), contactsData.getMobilePhone());
    type(By.name("email"), contactsData.getEmailAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroup());

    } else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void clickDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox")); // выставление небольшой задержки перед тем как выполнить следующий шаг
  }

  public void clickModifyContactById(int id) {
      wd.findElement((By.cssSelector("a[href*='edit.php?id=" + id + "']"))).click();

    }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactsData contactsData, boolean creation) {
    fillContactForm(contactsData, creation);
    submitContactCreation();
    homePage();
  }

  public void modify(ContactsData contact) {
    clickModifyContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    homePage();
  }

  public void delete(ContactsData contact) {
    selectContactById(contact.getId());
    clickDeleteContact();
    confirmDeletion();
    homePage();
  }

  public void homePage() {
    click(By.linkText("home"));
  }

  public boolean isThereContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all(){
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement element : rows) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactsData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }

}


