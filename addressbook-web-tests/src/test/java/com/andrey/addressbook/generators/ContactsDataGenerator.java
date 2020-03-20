package com.andrey.addressbook.generators;

import com.andrey.addressbook.models.ContactsData;
import com.andrey.addressbook.models.Groups;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static com.andrey.addressbook.tests.TestBase.app;

public class ContactsDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

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
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsXml(List<ContactsData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactsData.class);
    String xml = xstream.toXML(contacts);
     try (Writer writer = new FileWriter(file)){
       writer.write(xml);
     }
  }

  private void saveAsJson(List<ContactsData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create(); сворачивает путь файла
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsCsv(List<ContactsData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file)) {
      for (ContactsData contact : contacts ) {
        Groups groups = app.db().groups();
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname()
                , contact.getAddress(), contact.getMobilePhone(), contact.getEmailAddress(), contact.getPhoto()));
      }
    }
  }

  private List<ContactsData> generateContacts(int count) {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    for (int i = 0; i < count; i++ ) {
      contacts.add(new ContactsData().withFirstname(String.format("firstname %s", i))
              .withLastname(String.format("lastname %s", i)).withAddress(String.format("address %s", i))
              .withMobilePhone(String.format("mobilephone %s", i)).withEmailaddress(String.format("emailaddress %s", i))
              .withPhoto(new File("src/test/resources/my_photo.jpg")));
    }
    return contacts;
  }
}
