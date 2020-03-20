package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0){
      Groups groups = app.db().groups();
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev").inGroup(groups.iterator().next()), true);
    }
  }

  @Test
  public void contactModification(){
    Contacts before = app.db().contacts();
    ContactsData modifiedContact = before.iterator().next();
    File photo = new File ("src/test/resources/my_photo.jpg");
    ContactsData contact = new ContactsData()
            .withId(modifiedContact.getId()).withFirstname("Andrey").withLastname("Begishev")
            .withAddress("272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA").withMobilePhone("3214192300")
            .withEmailaddress("andreybegishev@gmail.com").withPhoto(photo);
    app.goTo().homePage();
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListUI();
  }


}
