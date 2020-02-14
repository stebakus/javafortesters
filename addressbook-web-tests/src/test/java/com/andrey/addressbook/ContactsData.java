package com.andrey.addressbook;

public class ContactsData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String phonenumber;
  private final String emailaddress;

  public ContactsData(String firstname, String lastname, String address, String phonenumber, String emailaddress) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.phonenumber = phonenumber;
    this.emailaddress = emailaddress;
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
}
