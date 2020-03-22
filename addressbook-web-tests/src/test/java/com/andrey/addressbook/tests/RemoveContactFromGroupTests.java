package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;

public class RemoveContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
      ContactsData contactsData = app.db().contacts().iterator().next();
      app.contact().addContactToGroup(contactsData);
    }
    ContactsData contactsData = app.db().contacts().iterator().next();
    if (contactsData.getGroups().size() == 0)
    app.contact().addContactToGroup(contactsData);

  }

  @Test
  public void removeContactFromGroup() {
    app.goTo().homePage();
    ContactsData contactsData = null;

    Iterator<ContactsData> allContacts = app.db().contacts().iterator();

    while (allContacts.hasNext()) {
      contactsData = allContacts.next();
      if (contactsData.getGroups().size() > 0) {
        break;
      }
    }
    if (contactsData != null && contactsData.getGroups().size() > 0) {
      app.contact().selectGroupFromFilterByGroupId(contactsData.getGroups().iterator().next().getId());
      app.contact().removeFromGroup(contactsData);

      ContactsData after = null;

      Iterator<ContactsData> updatedContacts = app.db().contacts().iterator();

      while (updatedContacts.hasNext()) {
        after = updatedContacts.next();
        if (after.getId() == contactsData.getId()) {
          break;
        }
      }

      Assert.assertEquals(contactsData.getGroups().size() - 1, after.getGroups().size());
    }

  }

}
