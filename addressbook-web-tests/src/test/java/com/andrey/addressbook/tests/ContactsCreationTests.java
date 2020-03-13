package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.Contacts;
import com.andrey.addressbook.models.ContactsData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/my_photo.jpg");
    list.add(new Object[]{new ContactsData()
            .withFirstname("firstname 1").withLastname("lastname 1")
            .withAddress("address 1").withMobilePhone("1 214192300")
            .withEmailaddress("andreybegishev1@gmail.com").withGroup("[none]").withPhoto(photo)});
    list.add(new Object[]{new ContactsData()
            .withFirstname("firstname 2").withLastname("lastname 2")
            .withAddress("address 2").withMobilePhone("2 214192300")
            .withEmailaddress("andreybegishev2@gmail.com").withGroup("[none]").withPhoto(photo)});
    list.add(new Object[]{new ContactsData()
            .withFirstname("firstname 3").withLastname("lastname 3")
            .withAddress("address 3").withMobilePhone("3 214192300")
            .withEmailaddress("andreybegishev3@gmail.com").withGroup("[none]").withPhoto(photo)});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactsCreation(ContactsData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().addContactPage();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
