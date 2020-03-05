package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().returnToHomePageFromNavigationHelper();
    if (! app.getContactHelper().isThereContact()){
      app.goTo().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactsData("Andrey", null, null,
              null, null, "[none]"), true);
    }
  }

  @Test
  public void contactModification(){
    List<ContactsData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactsData contact = new ContactsData(before.get(index).getId(), "Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA",
            "3214192300", "andreybegishev@gmail.com", null);
    app.getContactHelper().modifyContact(index, contact);
    List<ContactsData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactsData> byId = Comparator.comparingInt(ContactsData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
