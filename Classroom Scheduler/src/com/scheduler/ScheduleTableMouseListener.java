package com.scheduler;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JTable;

public class ScheduleTableMouseListener implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    // Double-Click
    if (e.getClickCount() == 2) {
      // Get Row in Table
      JTable table = (JTable) e.getSource();
      Point point = e.getPoint();
      int row = table.rowAtPoint(point);
      
      // Setup Window
      JDialog infoDialog = new CourseDetails(row);
      
      // Show Window
      infoDialog.setVisible(true);
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
    JTable table = (JTable) e.getSource();
    Point point = e.getPoint();
    int currentRow = table.rowAtPoint(point);
    table.setRowSelectionInterval(currentRow, currentRow);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

}
