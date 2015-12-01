import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame {
  private UserLogin loginDialog;
  
  public Main(){
    loginDialog = new UserLogin(this, true);
    loginDialog.setVisible(true);
  }
  
  public static void main(String[] args) {
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
	} catch (InstantiationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (UnsupportedLookAndFeelException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        // Setup Window
        JFrame frame = new Main();
        frame.setTitle("Logged In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(2,1));
        
        // Create Components
        ButtonActionListener buttonListener = new ButtonActionListener(frame);
        TableMouseListener tableMouseListener = new TableMouseListener();
        JPanel buttonPanel = new JPanel();
        JPanel tablePanel = new JPanel(new GridBagLayout());
        GridBagConstraints setup = new GridBagConstraints();
        
        // Create Buttons
        JButton courseListButton = new JButton("<html><center>Course<br>List</center></html>");
        JButton viewScheduleButton = new JButton("<html><center>View<br>Schedule</center></html>");
        JButton adminButton = new JButton("Admin");
        JButton closeButton = new JButton("Close");
        // Assign Listener to Buttons
        courseListButton.addActionListener(buttonListener);
        viewScheduleButton.addActionListener(buttonListener);
        adminButton.addActionListener(buttonListener);
        closeButton.addActionListener(buttonListener);
        // Re-Size Buttons
        courseListButton.setPreferredSize(new Dimension(75, 75));
        viewScheduleButton.setPreferredSize(new Dimension(75, 75));
        adminButton.setPreferredSize(new Dimension(75, 75));
        closeButton.setPreferredSize(new Dimension(75, 75));
        // Add Buttons to Panel
        buttonPanel.add(closeButton);
        buttonPanel.add(courseListButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(adminButton);
        
        // Setup Course Table
        JTable courseTable = new JTable(50, 2) {
          @Override
          public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(1, 1);
          }
        };
        courseTable.addMouseListener(tableMouseListener);
        courseTable.setEnabled(false);  // Make Non-Editable
        setup.fill = GridBagConstraints.BOTH;
        setup.weightx = 0.5;
        setup.weighty = 1;
        setup.gridx = 0;
        setup.insets = new Insets(10,10,10,5);
        tablePanel.add(new JScrollPane(courseTable), setup);
        
        // Setup Schedule Table
        JTable scheduleTable = new JTable(50, 5) {
          @Override
          public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(2, 1);
          }
        };
        scheduleTable.addMouseListener(tableMouseListener);
        scheduleTable.setEnabled(false);  // Make Cells Non-editable
        setup.fill = GridBagConstraints.BOTH;
        setup.weightx = 1;
        setup.weighty = 1;
        setup.gridx = 1;
        setup.insets = new Insets(10,5,10,10);
        tablePanel.add(new JScrollPane(scheduleTable), setup);
        
        // Add Labels to Window
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.CENTER);
      }
    });
  }
}
