package com.andrey.addressbook.models;

import java.util.Objects;

public class ContactsData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String phonenumber;
  private String emailaddress;
  private String group;

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

  public ContactsData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactsData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactsData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactsData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactsData withPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
    return this;
  }

  public ContactsData withEmailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
    return this;
  }

  public ContactsData withGroup(String group) {
    this.group = group;
    return this;
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
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
