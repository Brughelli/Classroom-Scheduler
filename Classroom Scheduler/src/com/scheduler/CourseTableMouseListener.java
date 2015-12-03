package com.scheduler;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

public class CourseTableMouseListener implements MouseListener {
  private SchedulerTableModel myModel;

  public CourseTableMouseListener(SchedulerTableModel model) {
    this.myModel = model;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // Double-Click
    if (e.getClickCount() == 2) {
      // Get Row in Table
      JTable table = (JTable) e.getSource();
      String filter = table.getValueAt(table.getSelectedRow(), 1).toString();
      Object[][] newScheduleData = TableDataRetriever.getTableData("Schedule", new int[]{1, 2, 3, 6, 4 ,5}, filter, "courseNumber");
      myModel.updateTable(newScheduleData);
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
}
