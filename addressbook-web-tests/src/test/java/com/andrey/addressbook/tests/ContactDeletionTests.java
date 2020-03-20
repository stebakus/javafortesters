package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.db().contacts();
    ContactsData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
