package com.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
  public static boolean authenticate(String username, String password){
    // Connect to Database
    try {
      Connection databaseConnection = (Connection) DriverManager.getConnection(
                        "jdbc:mysql://db4free.net:3306/ooserver", "classroom", "Scheduler");
      // Setup query
      Statement statement = (Statement) databaseConnection.createStatement();
      String query = "SELECT * FROM User WHERE username='" + username + "'";
      
      // Get Table Entry
      ResultSet user = statement.executeQuery(query);
      
      // Authenticate
      if (user.next()) {  // True if user found
        // TODO Hash Passwords to make them safe
        if (user.getString("password").equals(password)) {
          if (user.getBoolean("admin") == true) {
            SchedulerUI.setAdmin(true);
          } else {
            SchedulerUI.setAdmin(false);
          }
          return true;
        }
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return false;
  }
}
