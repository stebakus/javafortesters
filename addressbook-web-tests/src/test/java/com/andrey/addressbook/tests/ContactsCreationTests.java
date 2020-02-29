package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactsCreationTests extends TestBase{

  @Test
  public void testContactsCreation() throws Exception {
    app.getNavigationHelper().returnToHomePageFromNavigationHelper();
    List<ContactsData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactsData("Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA",
            "3214192300", "andreybegishev@gmail.com", "[none]"), true);
    List<ContactsData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

}
