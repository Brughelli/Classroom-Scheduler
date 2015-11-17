import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
  private UserLogin loginDialog;
  
  public Main(){
    loginDialog = new UserLogin(this, true);
    loginDialog.setVisible(true);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
          JFrame frame = new Main();
          frame.setTitle("Logged In");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLocationRelativeTo(null);
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          
          JPanel testPanel = new JPanel();
          JLabel testLabel = new JLabel("Test Label");
          testLabel.setHorizontalAlignment(SwingConstants.CENTER);
          
          testPanel.add(testLabel);
          frame.add(testPanel);
          
      }
  });
  }
}
