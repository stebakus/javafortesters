package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().returnToHomePageFromNavigationHelper();
    if (! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactsData("Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA",
              "3214192300", "andreybegishev@gmail.com", "[none]"), true);
    }
    List<ContactsData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().clickDeleteContact();
    app.getContactHelper().confirmDeletion();
    app.getNavigationHelper().returnToHomePageFromNavigationHelper(); // app.getContactHelper().returnToHomePage(); как вариант, чтобы избегать проверки и моментального возврашения на home.
    List<ContactsData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }

}
