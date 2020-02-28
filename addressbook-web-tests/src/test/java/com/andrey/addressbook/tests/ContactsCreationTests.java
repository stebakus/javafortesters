package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase{

  @Test
  public void testContactsCreation() throws Exception {
    app.getNavigationHelper().returnToHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactsData("Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA",
            "3214192300", "andreybegishev@gmail.com", "[none]"), true);
<<<<<<< HEAD
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);

=======
>>>>>>> 9b14024b929cf5ee3d80236d3280f5787ffcb199
  }

}
