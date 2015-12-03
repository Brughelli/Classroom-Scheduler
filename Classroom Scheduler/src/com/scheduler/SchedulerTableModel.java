package com.scheduler;

import javax.swing.table.AbstractTableModel;

public class SchedulerTableModel extends AbstractTableModel {
  private static final long serialVersionUID = 1L;
  private Object[] columnNames;
  private Object[][] data;
  
  public SchedulerTableModel(Object[][] data, Object[] columnNames) {
    this.columnNames = columnNames;
    this.data = data;
  }
  
  @Override
  public int getColumnCount() {
    return columnNames.length;
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
