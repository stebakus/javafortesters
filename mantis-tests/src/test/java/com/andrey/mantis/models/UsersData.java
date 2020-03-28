package com.andrey.mantis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
public class UsersData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "username")
  private String username;

  @Override
  public String toString() {
    return "UsersData{" +
            "id=" + id +
            ", username='" + username + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsersData usersData = (UsersData) o;
    return id == usersData.id &&
            Objects.equals(username, usersData.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username);
  }

  public UsersData getId(int id) {
    this.id = id;
    return this;
  }

  public void setId(int id) {
    this.id = id;
  }

  public UsersData getUsername(String username) {
    this.username = username;
    return this;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
