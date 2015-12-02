package com.scheduler;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ButtonActionListener implements ActionListener {
  private Window myFrame;
  
  public ButtonActionListener(Window frame) {
    this.myFrame = frame;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // Get Source Button
    JButton button = (JButton) e.getSource();
    
    // Service Action
    if (button.getText().equalsIgnoreCase("close")) {
      // Close Window
      myFrame.dispose();
      
    } else if (button.getText().equalsIgnoreCase("courses")) {
      // Import Course List from selected File
      CourseListImport.importCourses(myFrame);
      
    } else if (button.getText().equalsIgnoreCase("scheduler")) {
      // Run Classroom Scheduler
      JDialog scheduler = new SchedulerDialog();
      scheduler.setVisible(true);
      
    } else if (button.getText().equalsIgnoreCase("login")) {
      UserLogin frame = (UserLogin) myFrame;
      
      // Authenticate Login
      if(Login.authenticate(frame.getUsernameTextField().getText(), new String(frame.getPasswordTextField().getPassword()))) {
        // Close Login and Open Main upon Success
        frame.getMyParent().setVisible(true);
        frame.setVisible(false);
      } else {
        // Failed Authentication
        frame.getStatusLabel().setText("Invalid Username/Password");
        frame.getUsernameTextField().setText("");
        frame.getPasswordTextField().setText("");
        frame.getUsernameTextField().requestFocus();
      }
    } 
  }
}
