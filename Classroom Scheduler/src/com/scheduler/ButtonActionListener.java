package com.scheduler;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class ButtonActionListener implements ActionListener {
  private Window myFrame;
  
  public ButtonActionListener(Window frame) {
    this.myFrame = frame;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // Setup Button
    JButton button = (JButton) e.getSource();
    
    // Action based on button label
    if (button.getText().equalsIgnoreCase("close")) {
      myFrame.dispose();    // Close window
    } else if (button.getText().equalsIgnoreCase("login")) {
      // Login button from UserLogin class
      UserLogin frame = (UserLogin) myFrame;
      
      // Authenticate User
      try {
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
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }

}
