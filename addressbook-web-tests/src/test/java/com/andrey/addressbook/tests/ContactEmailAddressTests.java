package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.goTo().addContactPage();
      app.contact().create(new ContactsData().withFirstname("Andrey").withLastname("Begishev"), true);
    }
  }

  @Test
  public void testContactEmailAddresses() {
    app.goTo().homePage();
    ContactsData contact = app.contact().all().iterator().next();
    ContactsData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmailAddresses(), equalTo(mergeEmailAddresses(contactInfoFromEditForm)));
  }

  private String mergeEmailAddresses(ContactsData contact) {
    return Arrays.asList(contact.getEmailAddress(), contact.getEmailAddress2(), contact.getEmailAddress3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactEmailAddressTests::cleaned)
            .collect(Collectors.joining("\n" ));
  }

  public static String cleaned(String emailAddress) {
    return emailAddress.replaceAll("\\s", "").replaceAll("[-()]","");
  }

}
