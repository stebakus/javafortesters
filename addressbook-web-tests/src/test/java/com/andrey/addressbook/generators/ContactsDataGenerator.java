package com.andrey.addressbook.generators;

import com.andrey.addressbook.models.ContactsData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactsDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    ContactsDataGenerator generator = new ContactsDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactsData> contacts = generateContacts(count);
    save(contacts, new File(file));
  }

  private void save(List<ContactsData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactsData contact : contacts ) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname()
              , contact.getAddress(), contact.getMobilePhone(), contact.getEmailAddress(), contact.getGroup(), contact.getPhoto()));
    }
    writer.close();
  }

  private List<ContactsData> generateContacts(int count) {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    for (int i = 0; i < count; i++ ) {
      contacts.add(new ContactsData().withFirstname(String.format("firstname %s", i))
              .withLastname(String.format("lastname %s", i)).withAddress(String.format("address %s", i))
              .withMobilePhone(String.format("mobilephone %s", i)).withEmailaddress(String.format("emailaddress %s", i))
              .withGroup("[none]").withPhoto(new File("src/test/resources/my_photo.jpg")));
    }
    return contacts;
  }
}
