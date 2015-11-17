import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserLogin extends JDialog {
  private JButton loginButton;
  private JButton closeButton;
  private JLabel usernameLabel;
  private JLabel passwordLabel;
  private JLabel statusLabel;
  private JTextField usernameTextField;
  private JPasswordField passwordTextField;
  
  public UserLogin() {
    this(null, true);
  }
  
  public UserLogin(final JFrame parent, boolean modal) {
    super(parent, modal);
    
    this.setSize(300,350);
    this.setLocationRelativeTo(null);   //Center Login
    this.setTitle("User Login");
    
    this.loginButton = new JButton("Login");
    this.closeButton = new JButton("Close");
    this.usernameLabel = new JLabel("Username:");
    this.passwordLabel = new JLabel("Password:");
    this.statusLabel = new JLabel(" ");
    this.usernameTextField = new JTextField("");
    this.passwordTextField = new JPasswordField("");
    
    JPanel loginPanel = new JPanel(new GridBagLayout());
    GridBagConstraints setup = new GridBagConstraints();
    
    this.usernameLabel.setPreferredSize(new Dimension(100, 35));
    this.usernameTextField.setPreferredSize(new Dimension(150, 25));
    this.passwordLabel.setPreferredSize(new Dimension(100, 35));
    this.passwordTextField.setPreferredSize(new Dimension(150, 25));
    this.statusLabel.setForeground(Color.RED);
    this.statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    JLabel tempLabel = new JLabel("LOGIN LOGO");
    tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    setup.gridx = 0;
    setup.gridy = 0;
    setup.gridwidth = 2;
    setup.ipady = 150;
    loginPanel.add(tempLabel, setup);
    setup.gridwidth = 1;
    setup.ipady = 0;
    
    setup.gridx = 0;
    setup.gridy = 1;
    loginPanel.add(this.usernameLabel, setup);
    
    setup.gridx = 1;
    setup.gridy = 1;
    loginPanel.add(this.usernameTextField, setup);
    
    setup.gridx = 0;
    setup.gridy = 2;
    loginPanel.add(this.passwordLabel, setup);
    
    setup.gridx = 1;
    setup.gridy = 2;
    loginPanel.add(this.passwordTextField, setup);
    
    setup.gridx = 0;
    setup.gridy = 3;
    setup.gridwidth = 2;
    loginPanel.add(this.statusLabel, setup);
    setup.gridwidth = 1;
    
    setup.gridx = 1;
    setup.gridy = 4;
    setup.insets = new Insets(10,0,0,80);
    loginPanel.add(this.closeButton, setup);
    
    setup.gridx = 1;
    setup.gridy = 4;
    setup.insets = new Insets(10,80,0,0);
    loginPanel.add(this.loginButton, setup);
    
    addWindowListener(new WindowAdapter() {  
      @Override
      public void windowClosing(WindowEvent e) {  
        System.exit(0);  
      }  
    });
    
    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        statusLabel.setText(" ");
        if(Login.authenticate(usernameTextField.getText(), passwordTextField.getText())) {  //TODO change password.getText()
          parent.setVisible(true);
          setVisible(false);
        } else {
          statusLabel.setText("Invalid Username/Password");
          usernameTextField.setText("");
          passwordTextField.setText("");
          usernameTextField.requestFocus();
        }
        
      }
    });
    
    closeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
      
    });
    usernameTextField.requestFocus();
    this.add(loginPanel);
  }
}
