package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Set<ContactsData> before = app.contact().all();
    ContactsData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactsData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);

  }

}
