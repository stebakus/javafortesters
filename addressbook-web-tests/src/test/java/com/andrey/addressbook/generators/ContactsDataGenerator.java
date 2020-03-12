package com.andrey.addressbook.generators;

import com.andrey.addressbook.models.ContactsData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactsDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactsData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactsData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactsData contact : contacts ) {
      writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getAddress()));
    }
    writer.close();
  }

  private static List<ContactsData> generateContacts(int count) {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    for (int i = 0; i < count; i++ ) {
      contacts.add(new ContactsData().withFirstname(String.format("firstname %s", i))
              .withLastname(String.format("lastname %s", i)).withAddress(String.format("address %s", i)));
    }
    return contacts;
  }
}
