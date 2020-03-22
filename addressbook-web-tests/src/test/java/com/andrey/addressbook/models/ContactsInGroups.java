package com.andrey.addressbook.models;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class ContactsInGroups extends ForwardingSet<ContactsInGroupsData> {

  private Set<ContactsInGroupsData> delegate;

  public ContactsInGroups(ContactsInGroups contactsInGroups) {
    this.delegate = new HashSet<ContactsInGroupsData>(contactsInGroups.delegate);

  }

  @Override
  protected Set<ContactsInGroupsData> delegate() {
    return delegate;
  }

  public ContactsInGroups withAdded(ContactsInGroupsData contactsInGroup) {
    ContactsInGroups contactsInGroups = new ContactsInGroups(this);
    contactsInGroups.add(contactsInGroup);
    return contactsInGroups;
  }

  public ContactsInGroups without(ContactsInGroupsData contactsInGroup) {
    ContactsInGroups contactsInGroups = new ContactsInGroups(this);
    contactsInGroups.remove(contactsInGroup);
    return contactsInGroups;
  }

}
