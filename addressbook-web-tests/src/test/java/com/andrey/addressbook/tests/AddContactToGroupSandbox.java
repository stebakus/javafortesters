package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.GroupData;
import com.andrey.addressbook.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactToGroupSandbox extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
    }
    if (app.db().groups().size() == 0) {
      Random random = new Random();
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test" + random.nextInt(100)));
    }
  }

  @Test
  public void addContactToGroup(){
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactsData contact = app.contact().all().iterator().next();
    app.contact().addContactToGroup(contact);
    Contacts after = app.db().contacts();



  }

}