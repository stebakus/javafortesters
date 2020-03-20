package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Iterator;

public class AddContactToGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
    }
  }

  @Test
  public void addContactToGroup(){
    app.goTo().homePage();
    ContactsData contactsData = app.db().contacts().iterator().next();
    app.contact().addContactToGroup(contactsData);
    ContactsData after = null;

    Iterator<ContactsData> allContacts = app.db().contacts().iterator();

    while (allContacts.hasNext()) {
      after = allContacts.next();
      if (after.getId() == contactsData.getId()) {
           break;
      }
    }

    Assert.assertEquals(contactsData.getGroups().size()+1, after.getGroups().size());

    //assertThat(groupSize, equalTo(contact.getGroups()));
    //assertThat(after, equalTo(contact.getGroups()));




  }

}
