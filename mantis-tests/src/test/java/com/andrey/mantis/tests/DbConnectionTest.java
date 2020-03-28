package com.andrey.mantis.tests;

import com.andrey.mantis.models.Users;
import com.andrey.mantis.models.UsersData;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost/bugtracker?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select id, username from mantis_user_table");
      Users users = new Users();
      while (rs.next()) {
        users.add(new UsersData().getId(rs.getInt("id")));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(users);
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
