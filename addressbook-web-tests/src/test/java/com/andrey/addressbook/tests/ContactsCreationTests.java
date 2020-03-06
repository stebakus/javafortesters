package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class ContactsCreationTests extends TestBase{

  @Test
  public void testContactsCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactsData> before = app.contact().all();
    app.goTo().addContactPage();
    ContactsData contact = new ContactsData()
            .withFirstname("Andrey").withLastname("Begishev")
            .withAddress("272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA").withPhonenumber("3214192300")
            .withEmailaddress("andreybegishev@gmail.com").withGroup("[none]");
    app.contact().create(contact, true);
    Set<ContactsData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
