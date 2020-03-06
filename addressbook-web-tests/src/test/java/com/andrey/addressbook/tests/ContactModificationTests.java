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
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withGroup("[none]"), true);
    }
  }

  @Test
  public void contactModification(){
    List<ContactsData> before = app.contact().list();
    int index = before.size() - 1;
    ContactsData contact = new ContactsData()
            .withId(before.get(index).getId()).withFirstname("Andrey").withLastname("Begishev")
            .withAddress("272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA").withPhonenumber("3214192300")
            .withEmailaddress("andreybegishev@gmail.com").withGroup(null);
    app.contact().modify(index, contact);
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactsData> byId = Comparator.comparingInt(ContactsData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
