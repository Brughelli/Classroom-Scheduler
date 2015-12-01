import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TableMouseListener implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2) {
      JTable target = (JTable) e.getSource();
      Point myPoint = e.getPoint();
      int row = target.rowAtPoint(myPoint);
      row += 1;
      
      JDialog infoDialog = new JDialog();
      JPanel infoPanel = new JPanel();
      JLabel infoLabel = new JLabel();
      
      infoDialog.setSize(400, 500);
      infoDialog.setLocationRelativeTo(null);   //Center Login
      infoDialog.setTitle("Course Details");
      infoDialog.setResizable(false);
      
      infoLabel.setText("Row " + row + " was Clicked");
      infoPanel.add(infoLabel);
      infoDialog.add(infoPanel);
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
