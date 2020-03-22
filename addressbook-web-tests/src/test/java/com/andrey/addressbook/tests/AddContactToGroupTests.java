package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.GroupData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
    }
  }

  @Test
  public void addContactToGroup() {
    app.goTo().homePage();
    List<ContactsData> beforeContact = app.contact().getContactsList();
    List<ContactsData> beforeGroup = app.contact().getGroupsList();
    ContactsData contactsData = app.db().contacts().iterator().next();
    app.contact().addContactToGroup(contactsData);
    List<ContactsData> afterContact = app.contact().getContactsList();
    List<ContactsData> afterGroup = app.contact().getGroupsList();
    ContactsData after = null;
    Iterator<ContactsData> allContacts = app.db().contacts().iterator();

    while (allContacts.hasNext()) {
      after = allContacts.next();
      if (after.getId() == contactsData.getId()) {
        break;
      }
    }
    app.goTo().homePage();

    Assert.assertEquals(contactsData.getGroups().size() + 1, after.getGroups().size());


    /*for (ContactsData contact : before1) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }
    for (ContactsData contact : after1) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }

     */

  }

}
