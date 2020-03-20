package com.andrey.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactsData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE; //private transient int id = Integer.MAX_VALUE; to exclude from json.

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String emailAddress;

  @Transient
  private String emailAddress2;

  @Transient
  private String emailAddress3;

  //@Expose
  //@Transient
  //private String group;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Transient
  private String allPhones;

  @Transient
  private String allAddresses;

  @Transient
  private String allEmailAddresses;

  @Expose
  @Transient
  private File photo;

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

  //public String getGroup() {
  //  return group;
  //}

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

  public File getPhoto() {
    return photo;
  }

  public ContactsData withPhoto(File photo) {
    this.photo = photo;
    return this;
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

  //public ContactsData withGroup(String group) {
  //  this.group = group;

  public Groups getGroups() {
    return new Groups(groups);
  }

  //  return this;
  //}

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
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(emailAddress, that.emailAddress) &&
            Objects.equals(mobilePhone, that.mobilePhone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, emailAddress, mobilePhone);
  }

  public ContactsData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
