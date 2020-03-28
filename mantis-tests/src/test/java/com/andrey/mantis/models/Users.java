package com.andrey.mantis.models;

import com.andrey.mantis.models.UsersData;
import com.google.common.collect.ForwardingSet;

import java.util.*;

public class Users extends ForwardingSet<UsersData> {

  private Set<UsersData> delegate;

  public Users(Users users) {
    this.delegate = new HashSet<UsersData>(users.delegate);
  }

  public Users() {
    this.delegate = new HashSet<UsersData>();
  }

  public Users(Collection<UsersData> contacts) {
    this.delegate = new HashSet<UsersData>(contacts);
  }

  @Override
  protected Set<UsersData> delegate() {
    return delegate;
  }

  public Users withAdded(UsersData user){
    Users users = new Users(this);
    users.add(user);
    return users;
  }

  public Users without(UsersData user){
    Users users = new Users(this);
    users.remove(user);
    return users;
  }
}
