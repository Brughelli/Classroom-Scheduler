package com.scheduler;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SchedulerTableModel extends AbstractTableModel {
  private static final long serialVersionUID = 1L;
  private Object[] columnNames;
  private Object[][] data;
  
  public SchedulerTableModel(Object[][] data, Object[] columnNames) {
    this.columnNames = columnNames;
    this.data = data;
  }
  
  public void removeRow(int selectedRow) {
    ArrayList<Object[]> newData = new ArrayList<Object[]>();
    int len = data.length;
    
    for (int i = 0; i < len; i++) {
      if (i != selectedRow) {
        newData.add(data[i]);
      }
    }
    
    int numRows = newData.size();
    Object[][] finalData = new Object[numRows][];
    for (int i = 0; i < numRows; i++) {
      finalData[i] = newData.get(i);
    }
    
    this.data = finalData;
    this.fireTableDataChanged();
  }
  
  @Override
  public int getColumnCount() {
    return columnNames.length;
  }
  @Override
  public String getColumnName(int column) {
    return (String) columnNames[column];
  }
  @Override
  public int getRowCount() {
    return data.length;
  }
  @Override
  public Object getValueAt(int row, int col) {
    return data[row][col];
  }
  @Override
  public boolean isCellEditable(int row, int column){
    return false;
  }
  
  public void updateTable(Object[][] data) {
    this.data = data;
    this.fireTableDataChanged();
  }
}
