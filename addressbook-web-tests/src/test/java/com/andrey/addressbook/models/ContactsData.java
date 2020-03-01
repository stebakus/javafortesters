package com.andrey.addressbook.models;

import java.util.Objects;

public class ContactsData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String phonenumber;
  private final String emailaddress;
  private String group;

  public ContactsData(String firstname, String lastname, String address, String phonenumber, String emailaddress, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.phonenumber = phonenumber;
    this.emailaddress = emailaddress;
    this.group = group;
  }

  public ContactsData(int id, String firstname, String lastname, String address, String phonenumber, String emailaddress, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.phonenumber = phonenumber;
    this.emailaddress = emailaddress;
    this.group = group;
  }

  public int getId() {
    return id;
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

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactsData that = (ContactsData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

}
