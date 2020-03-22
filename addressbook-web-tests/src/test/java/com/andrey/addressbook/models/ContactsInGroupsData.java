package com.andrey.addressbook.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address_in_groups")
public class ContactsInGroupsData {

  @Id
  @Column(name = "id")
  private int contactId = Integer.MAX_VALUE;

  @Id
  @Column(name = "group_id")
  private int groupId = Integer.MAX_VALUE;

  public int getContactId() {
    return contactId;
  }

  public void setContactId(int contactId) {
    this.contactId = contactId;
  }

  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

}
