import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
  private JFrame myParent;
  
  public UserLogin() {
    this(null, true);
  }
  
  public UserLogin(final JFrame parent, boolean modal) {
    // Setup Window
    super(parent, modal);
    this.myParent = parent;
    this.setSize(300,350);
    this.setLocationRelativeTo(null);   //Center Login
    this.setTitle("User Login");
    this.setResizable(false);
    
    // Setup Components
    ButtonActionListener buttonListener = new ButtonActionListener(this);
    JPanel loginPanel = new JPanel(new GridBagLayout());
    GridBagConstraints setup = new GridBagConstraints();
    
    // Setup Logo
    JLabel tempLabel = new JLabel("LOGIN LOGO");
    tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
    setup.gridx = 0;
    setup.gridy = 0;
    setup.gridwidth = 2;
    setup.ipady = 150;
    loginPanel.add(tempLabel, setup);
    setup.gridwidth = 1;
    setup.ipady = 0;
    
    // Setup Username Label / Text Field
    this.usernameLabel = new JLabel("Username:");
    this.usernameLabel.setPreferredSize(new Dimension(100, 35));
    setup.gridx = 0;
    setup.gridy = 1;
    loginPanel.add(this.usernameLabel, setup);

    this.usernameTextField = new JTextField("");
    this.usernameTextField.setPreferredSize(new Dimension(150, 25));
    setup.gridx = 1;
    setup.gridy = 1;
    loginPanel.add(this.usernameTextField, setup);
    
    // Setup Password Label / Text Field
    this.passwordLabel = new JLabel("Password:");
    this.passwordLabel.setPreferredSize(new Dimension(100, 35));
    setup.gridx = 0;
    setup.gridy = 2;
    loginPanel.add(this.passwordLabel, setup);

    this.passwordTextField = new JPasswordField("");
    this.passwordTextField.setPreferredSize(new Dimension(150, 25));
    setup.gridx = 1;
    setup.gridy = 2;
    loginPanel.add(this.passwordTextField, setup);
    
    // Setup Status Label
    this.statusLabel = new JLabel(" ");
    this.statusLabel.setForeground(Color.RED);
    this.statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
    setup.gridx = 0;
    setup.gridy = 3;
    setup.gridwidth = 2;
    loginPanel.add(this.statusLabel, setup);
    setup.gridwidth = 1;
    
    // Setup Close Button
    this.closeButton = new JButton("Close");
    closeButton.addActionListener(buttonListener);
    setup.gridx = 1;
    setup.gridy = 4;
    setup.insets = new Insets(10,0,0,80);
    loginPanel.add(this.closeButton, setup);
    
    // Setup Login Button
    this.loginButton = new JButton("Login");
    loginButton.addActionListener(buttonListener);
    setup.gridx = 1;
    setup.gridy = 4;
    setup.insets = new Insets(10,80,0,0);
    loginPanel.add(this.loginButton, setup);
    
    // Setup Default Button and Focus
    this.getRootPane().setDefaultButton(loginButton);
    usernameTextField.requestFocus();
    
    // Add Panel
    this.add(loginPanel);
  }

  public JLabel getStatusLabel() {
    return statusLabel;
  }

  public JTextField getUsernameTextField() {
    return usernameTextField;
  }

  public JPasswordField getPasswordTextField() {
    return passwordTextField;
  }

  public JFrame getMyParent() {
    return myParent;
  }
}