package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.GroupData;
import com.google.common.collect.Sets;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      Random random = new Random();
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test" + random.nextInt(100)));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
    }

    List<ContactsData> contactList = app.contact().getContactsList();
    int counter = 0;
    for (ContactsData contact : contactList) {
      if (contact.getGroups().size() > 0) {
        counter++;
        break;
      }
    }

    if (counter == 0) {
      ContactsData contactsData = app.db().contacts().iterator().next();
      app.contact().addContactToGroup(contactsData);
    }

  }

  @Test
  public void removeContactFromGroup() {
    app.goTo().homePage();
    List<ContactsData> beforeContactList = app.contact().getContactsList();
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
      List<ContactsData> afterContactList = app.contact().getContactsList();

      Set<GroupData> beforeContactGroups = Sets.difference(contactsData.getGroups(), after.getGroups());

      Assert.assertEquals(contactsData.getGroups().size() - 1, after.getGroups().size());
      assertThat(after.getGroups(),
              equalTo(contactsData.getGroups().without(beforeContactGroups.iterator().next())));

      System.out.println("****************************************************************************");
      System.out.println("BEFORE: " + contactsData);
      System.out.println(contactsData.getGroups());
      System.out.println("AFTER: " + after);
      System.out.println(after.getGroups());
      System.out.println("****************************************************************************");

      //Assert.assertEquals(new HashSet<Object>(beforeContactList), new HashSet<Object>(afterContactList));

    }

  }

}
