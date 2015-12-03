package com.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableDataRetriever {
  private TableDataRetriever() {
    
  }
  
  public static Object[][] getTableData(String tableName, int[] desiredColumns) {
    try {
      String columnNames = getColumnNames(tableName, desiredColumns);
      String query = "SELECT " + columnNames + " FROM " + tableName;
      Object[][] data = getData(tableName, desiredColumns, query);
      return data;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  
  public static Object[][] getTableData(String tableName, int[] desiredColumns, String filter, String filterColumnName) {
    try {
      String columnNames = getColumnNames(tableName, desiredColumns);
      String query = "SELECT " + columnNames + " FROM " + tableName + " WHERE " + filterColumnName + " = " + filter;
      Object[][] data = getData(tableName, desiredColumns, query);
      return data;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return null;
    
  }
  
  public static String getColumnNames(String tableName, int[] desiredColumns) throws SQLException {
    // Connect to Database
    Connection databaseConnection = (Connection) DriverManager.getConnection(
                      "jdbc:mysql://db4free.net:3306/ooserver", "classroom", "Scheduler");
  
    // Setup query
    Statement statement = (Statement) databaseConnection.createStatement();
    String query = "SELECT * FROM " + tableName + " limit 1";
    
    // Get Single Row for Column Names
    ResultSet tableData = statement.executeQuery(query);
    ResultSetMetaData metaData = tableData.getMetaData();
    
    // Setup Database Query
    String columnNames = "";
    int numColumns = desiredColumns.length;
    for (int i = 0; i < numColumns - 1; i++) {
      columnNames += (metaData.getColumnName(desiredColumns[i]) + ", ");
    }
    columnNames += (metaData.getColumnName(desiredColumns[numColumns - 1]) + " ");
    
    return columnNames;
  }
  
  public static Object[][] getData(String tableName, int[] desiredColumns, String query) throws SQLException {
    // Connect to Database
    Connection databaseConnection = (Connection) DriverManager.getConnection(
                      "jdbc:mysql://db4free.net:3306/ooserver", "classroom", "Scheduler");
    
    // Get Table Data
    Statement statement = (Statement) databaseConnection.createStatement();
    ResultSet tableData = statement.executeQuery(query);
    
    // Get Desired Data from table
    tableData = statement.executeQuery(query);
    
    // Get Table Data
    Object[] temp;
    ArrayList<Object[]> tempData = new ArrayList<Object[]>();
    int numColumns = desiredColumns.length;
    while (tableData.next()) {
      temp = new Object[numColumns];
      for (int i = 0; i < numColumns; i++) {
        temp[i] = tableData.getString(i + 1);
      }
      tempData.add(temp);
    }
    
    // Convert to Arrays
    Object[][] data = new Object[tempData.size()][];
    int numRows = tempData.size();
    for (int i = 0; i < numRows; i++) {
      data[i] = tempData.get(i);
    }
    
    return data;
  }
}
