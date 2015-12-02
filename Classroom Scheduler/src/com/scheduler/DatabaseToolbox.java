package com.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DatabaseToolbox {
  private DatabaseToolbox() {
    
  }
  
  public static void updateDatabse(Class<?> entity, ArrayList<Object> items) {
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
  
  public static String[][] getTableData(String tableName, int[] desiredColumns) throws SQLException {
    // Connect to Database
    Connection databaseConnection = (Connection) DriverManager.getConnection(
                      "jdbc:mysql://db4free.net:3306/ooserver", "classroom", "Scheduler");
  
    // Setup test query
    Statement statement = (Statement) databaseConnection.createStatement();
    String query = "SELECT * FROM " + tableName + " limit 1";
    
    // Get Single Row for Column Names
    ResultSet tableData = statement.executeQuery(query);
    ResultSetMetaData metaData = tableData.getMetaData();
    
    // Setup Database Query
    String fetchColumns = "";
    int numColumns = desiredColumns.length;
    for (int i = 0; i < numColumns - 1; i++) {
      fetchColumns += (metaData.getColumnName(desiredColumns[i]) + ", ");
    }
    fetchColumns += (metaData.getColumnName(desiredColumns[numColumns - 1]) + " ");
    query = "SELECT " + fetchColumns + " FROM " + tableName;
    
    // Get Desired Data from table
    tableData = statement.executeQuery(query);
    
    // Get Table Data
    String[] temp;
    ArrayList<String[]> data = new ArrayList<String[]>();
    while (tableData.next()) {
      temp = new String[numColumns];
      for (int i = 0; i < numColumns; i++) {
        temp[i] = tableData.getString(i + 1);
      }
      data.add(temp);
    }
    
    // Convert to Arrays
    String[][] dataArray = new String[data.size()][];
    int numRows = data.size();
    for (int i = 0; i < numRows; i++) {
      dataArray[i] = data.get(i);
    }
    
    return dataArray;
  }
}