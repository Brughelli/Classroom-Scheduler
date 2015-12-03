package com.scheduler;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UpdateDatabase {
  private UpdateDatabase() {
    
  }
  
  public static void updateTable(Class<?> entity, ArrayList<Object> items) {
    // Hibernate Setup
    Configuration conf = new Configuration().configure();
    conf.addAnnotatedClass(entity);
    StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
    SessionFactory factory = conf.buildSessionFactory(reg.build());
    Session session = factory.openSession();
    
    // Write to Database
    session.beginTransaction();
    int len = items.size();
    for (int i = 0; i < len; i++) {
      session.save(items.get(i));
    }
    session.getTransaction().commit();
    // Close Session
    session.close();
    factory.close();
  }
}