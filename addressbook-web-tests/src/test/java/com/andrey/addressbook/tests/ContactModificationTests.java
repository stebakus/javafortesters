package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev").withGroup("[none]"), true);
    }
  }

  @Test
  public void contactModification(){
    Contacts before = app.db().contacts();
    ContactsData modifiedContact = before.iterator().next();
    ContactsData contact = new ContactsData()
            .withId(modifiedContact.getId()).withFirstname("Andrey").withLastname("Begishev")
            .withAddress("272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA").withMobilePhone("3214192300")
            .withEmailaddress("andreybegishev@gmail.com").withGroup("[none]");
    app.goTo().homePage();
    app.contact().modify(modifiedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
