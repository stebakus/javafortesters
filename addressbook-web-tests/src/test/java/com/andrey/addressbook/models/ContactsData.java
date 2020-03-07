package com.andrey.addressbook.models;

import java.util.Objects;

public class ContactsData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String emailAddress;
  private String emailAddress2;
  private String emailAddress3;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String allAddresses;
  private String allEmailAddresses;

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

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getEmailAddress2() {
    return emailAddress2;
  }

  public String getEmailAddress3() {
    return emailAddress3;
  }

  public String getGroup() {
    return group;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllAddresses() {
    return allAddresses;
  }

  public String getAllEmailAddresses() {
    return allEmailAddresses;
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

  public ContactsData withEmailaddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  public ContactsData withEmailAddress2(String emailAddress2) {
    this.emailAddress2 = emailAddress2;
    return this;
  }

  public ContactsData withEmailAddress3(String emailAddress3) {
    this.emailAddress3 = emailAddress3;
    return this;
  }

  public ContactsData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactsData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactsData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactsData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactsData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactsData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return this;
  }

  public ContactsData withAllEmailAddresses(String allEmailAddresses) {
    this.allEmailAddresses = allEmailAddresses;
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
