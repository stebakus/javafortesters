package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.ContactsData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void contactModification(){
    app.getContactHelper().selectContact();
    // ^ Возможно ненужное действие, так как можно кликнуть на "Редактирование" напрямую, но решил оставить, чтобы было визуально видно какой контакт редактируется.
    app.getContactHelper().clickModifyContact();
    app.getContactHelper().fillContactForm(new ContactsData("Andrey", "Begishev", "272 Canaveral Beach Blvd, Cape Canaveral, FL, 32920, USA", "3214192300", "andreybegishev@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();





  }
}
