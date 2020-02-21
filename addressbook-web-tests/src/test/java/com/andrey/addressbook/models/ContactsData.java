package com.andrey.addressbook.models;

public class ContactsData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String phonenumber;
  private final String emailaddress;
  private String group;

  public ContactsData(String firstname, String lastname, String address, String phonenumber, String emailaddress, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.phonenumber = phonenumber;
    this.emailaddress = emailaddress;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public String getEmailaddress() {
    return emailaddress;
  }

  public String getGroup() {
    return group;
  }
}
