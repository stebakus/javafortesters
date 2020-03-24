package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.GroupData;
import com.google.common.collect.Sets;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
    }
    // # 1
    if (app.db().groups().size() == 0) {
      Random random = new Random();
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test" + random.nextInt(100)));
    }
  }

  @Test
  public void addContactToGroup() {
    app.goTo().homePage();
    List<ContactsData> beforeContactList = app.contact().getContactsList();
    ContactsData contactsData = null;

    int counter = 0;

    int totalDBGroupSize = app.db().groups().size();
    for (ContactsData contact : beforeContactList) {
      if (contact.getGroups().size() != totalDBGroupSize) {
        contactsData = contact;
        counter++;
       // app.contact().addContactToGroup(contact);
        break;
      }
    }

    if (counter == 0) {
      // создаешь нового пользователя
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey1").withLastname("Begishev1"), true);
      beforeContactList = app.contact().getContactsList();
      for (ContactsData contact : beforeContactList) {
        if (contact.getGroups().size() != totalDBGroupSize) {
          contactsData = contact;
         // app.contact().addContactToGroup(contact);
          break;
        }
      }
    }


    app.contact().addContactToGroup(contactsData);

    List<ContactsData> afterContact = app.contact().getContactsList();
    ContactsData after = null;
    Iterator<ContactsData> allContacts = app.db().contacts().iterator();

    while (allContacts.hasNext()) {
      after = allContacts.next();
      if (after.getId() == contactsData.getId()) {
        break;
      }
    }
//    app.goTo().homePage();

    ContactsData bContact = null;
    ContactsData aContact = null;

    if (afterContact.size() > beforeContactList.size()) {
      afterContact.removeAll(beforeContactList);
       contactsData = afterContact.get(0);
    }

    for (ContactsData  contactbefore : beforeContactList) {
      if (contactbefore.getId() == contactsData.getId()) {
        bContact = contactbefore;
      }
    }

    for (ContactsData contactafter : afterContact) {
      if (contactafter.getId() == contactsData.getId()) {
        aContact = contactafter;
      }
    }


    Set<GroupData> beforeContactGroups = Sets.difference(aContact.getGroups(), bContact.getGroups());

    Assert.assertEquals(contactsData.getGroups().size() + 1, after.getGroups().size());
    assertThat(aContact.getGroups(),
            equalTo(bContact.getGroups().withAdded(beforeContactGroups.iterator().next())));

    System.out.println("****************************************************************************");
    System.out.println("BEFORE: " + bContact);
    System.out.println(bContact.getGroups());
    System.out.println("AFTER: " + aContact);
    System.out.println(aContact.getGroups());
    System.out.println("****************************************************************************");









  }

}
