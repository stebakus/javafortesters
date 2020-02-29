package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().returnToHomePageFromNavigationHelper();
    if (! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactsData("Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA",
              "3214192300", "andreybegishev@gmail.com", "[none]"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().clickDeleteContact();
    app.getContactHelper().confirmDeletion();
    app.getNavigationHelper().returnToHomePageFromNavigationHelper(); // app.getContactHelper().returnToHomePage(); как вариант, чтобы избегать проверки и моментального возврашения на home.
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}
