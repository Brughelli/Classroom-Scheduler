import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
        JFrame frame = new Main();
        frame.setTitle("Logged In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(2,1));
        
        JPanel buttonPanel = new JPanel();
        JButton courseListButton = new JButton("<html><center>Course<br>List</center></html>");
        JButton viewScheduleButton = new JButton("<html><center>View<br>Schedule</center></html>");
        JButton adminButton = new JButton("Admin");
        JButton closeButton = new JButton("Close");
        
        courseListButton.setPreferredSize(new Dimension(75, 75));
        viewScheduleButton.setPreferredSize(new Dimension(75, 75));
        adminButton.setPreferredSize(new Dimension(75, 75));
        closeButton.setPreferredSize(new Dimension(75, 75));
        
        buttonPanel.add(courseListButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(adminButton);
        buttonPanel.add(closeButton);
        
        closeButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.exit(0);
          }
          
        });
        
        JPanel tablePanel = new JPanel(new GridBagLayout());
        GridBagConstraints setup = new GridBagConstraints();
        
        JTextArea courseTextArea = new JTextArea();
        setup.fill = GridBagConstraints.BOTH;
        setup.ipady = 40;      //make this component tall
        setup.weightx = 0.5;
        setup.weighty = 1;
        setup.gridwidth = 1;
        setup.gridx = 0;
        setup.gridy = 1;
        setup.insets = new Insets(10,10,10,5);
        tablePanel.add(new JScrollPane(courseTextArea), setup);
        
        JTextArea scheduleTextArea = new JTextArea();
        setup.fill = GridBagConstraints.BOTH;
        setup.ipady = 40;      //make this component tall
        setup.weightx = 1;
        setup.weighty = 1;
        setup.gridwidth = 2;
        setup.gridx = 1;
        setup.gridy = 1;
        setup.insets = new Insets(10,5,10,10);
        tablePanel.add(new JScrollPane(scheduleTextArea), setup);
        
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.CENTER);
        
        
      }
  });
  }
}
