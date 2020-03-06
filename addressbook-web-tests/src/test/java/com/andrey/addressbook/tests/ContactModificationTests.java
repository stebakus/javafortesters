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
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withGroup("[none]"), true);
    }
  }

  @Test
  public void contactModification(){
    Contacts before = app.contact().all();
    ContactsData modifiedCotact = before.iterator().next();
    ContactsData contact = new ContactsData()
            .withId(modifiedCotact.getId()).withFirstname("Andrey").withLastname("Begishev")
            .withAddress("272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA").withPhonenumber("3214192300")
            .withEmailaddress("andreybegishev@gmail.com").withGroup(null);
    app.contact().modify(modifiedCotact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedCotact).withAdded(contact)));
  }
}
