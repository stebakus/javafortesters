package com.andrey.addressbook.appmanager;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.Groups;
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
    type(By.name("home"), contactsData.getHomePhone());
    type(By.name("mobile"), contactsData.getMobilePhone());
    type(By.name("work"), contactsData.getWorkPhone());
    type(By.name("email"), contactsData.getEmailAddress());
    attach(By.name("photo"), contactsData.getPhoto());

    if (creation) {
      if (contactsData.getGroups().size() > 0) {
        Assert.assertTrue(contactsData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroups().iterator().next().getName());
      }
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

  public void clickOnGroup() {
    wd.findElement(By.name("group")).click();
  }

  public void selectGroup(ContactsData contactData, boolean selection) {
    if (selection) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    }


  }

  public void addToGroup() {
    wd.findElement(By.name("add")).click();
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


  public void addContactToGroup(ContactsData contact) {
    selectContactById(contact.getId());
    clickOnGroup();
    selectGroup(contact, true);
    addToGroup();
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
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allAddresses = cells.get(3).getText();
      String allEmailAddresses = cells.get(4).getText();
      contacts.add(new ContactsData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAllAddresses(allAddresses).withAllEmailAddresses(allEmailAddresses));
    }
    return contacts;
  }

  public ContactsData infoFromEditForm(ContactsData contact) {
    clickModifyContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.cssSelector("textarea[name=\"address\"]")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactsData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).withEmailaddress(email).withEmailAddress2(email2).withEmailAddress3(email3);
  }

}


