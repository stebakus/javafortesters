package com.andrey.addressbook.models;

import java.util.Objects;

public class ContactsData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String emailAddress;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;

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

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmailAddress() {
    return emailAddress;
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

  public ContactsData withMobilePhone(String phonenumber) {
    this.mobilePhone = phonenumber;
    return this;
  }

  public ContactsData withEmailaddress(String emailaddress) {
    this.emailAddress = emailaddress;
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
