package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class ContactsCreationTests extends TestBase{

  @Test
  public void testContactsCreation() throws Exception {
    app.goTo().homePage();
    List<ContactsData> before = app.contact().list();
    app.goTo().addContactPage();
    ContactsData contact = new ContactsData()
            .withFirstname("Andrey").withLastname("Begishev")
            .withAddress("272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA").withPhonenumber("3214192300")
            .withEmailaddress("andreybegishev@gmail.com").withGroup("[none]");
    app.contact().create(contact, true);
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactsData> byId = Comparator.comparingInt(ContactsData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
