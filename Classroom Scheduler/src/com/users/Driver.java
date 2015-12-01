package com.users;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Driver {
  public static void main(String[] args) {
    ArrayList<User> users = new ArrayList<User>();
    String username;
    String password;
    
    // Temp User Setup
    for (int i = 0; i < 10; i++) {
      username = "user" + i;
      password = "password" + i;
      users.add(new User(username, password));
    }
    
    // Hibernate Setup
    Configuration conf = new Configuration().configure();
    conf.addAnnotatedClass(User.class);
    StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(
                                                                            conf.getProperties());
    SessionFactory factory = conf.buildSessionFactory(reg.build());
    Session session = factory.openSession();
    
    // Write to Database
    session.beginTransaction();
    for (User user : users) {
      session.save(user);
    }
    session.getTransaction().commit();
    
    // Close Session
    session.close();
    factory.close();
  }
}
