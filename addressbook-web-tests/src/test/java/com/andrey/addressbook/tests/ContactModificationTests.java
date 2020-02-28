package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void contactModification(){
    app.getNavigationHelper().returnToHomePageFromNavigationHelper();
    if (! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactsData("Andrey", null, null,
              null, null, "[none]"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().clickModifyContact();
    app.getContactHelper().fillContactForm(new ContactsData("Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA",
            "3214192300", "andreybegishev@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePageFromNavigationHelper();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);





  }
}
