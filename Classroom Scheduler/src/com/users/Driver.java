package com.users;

import java.util.ArrayList;

import com.scheduler.DatabaseToolbox;

public class Driver {
  public static void main(String[] args) {
    ArrayList<Object> users = new ArrayList<Object>();
    String username;
    
    // TODO Implement real user setup
    // Temp User Setup
    for (int i = 0; i < 10; i++) {
      username = "user" + i;
      users.add(new User(username, "", false));
    }
    users.add(new User("admin", "", true));
    
    DatabaseToolbox.updateDatabse(User.class, users);
  }
}
