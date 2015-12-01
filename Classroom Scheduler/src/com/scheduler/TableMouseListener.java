package com.scheduler;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JTable;

public class TableMouseListener implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    // Double-Click
    if (e.getClickCount() == 2) {
      // Get Row in Table
      JTable target = (JTable) e.getSource();
      Point myPoint = e.getPoint();
      int row = target.rowAtPoint(myPoint);
      row += 1;
      
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
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

}
