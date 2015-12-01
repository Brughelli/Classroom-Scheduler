package com.scheduler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CourseDetails extends JDialog {
  private JButton closeButton;
  private JPanel infoPanel;
  private JPanel buttonPanel;
  private JLabel infoLabel;
  
  public CourseDetails(int courseId) {
    // Setup Window
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);   //Center Login
    this.setTitle("Course Details");
    this.setResizable(false);
    this.setLayout(new BorderLayout());
    
    // Create Components
    ButtonActionListener buttonListener = new ButtonActionListener(this);
    this.infoPanel = new JPanel();
    this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    // Setup Info Label
    this.infoLabel = new JLabel();
    infoLabel.setText("Row " + courseId + " was Opened");
    infoPanel.add(infoLabel);

    // Setup Close Button
    this.closeButton = new JButton("Close");
    this.closeButton.addActionListener(buttonListener);
    closeButton.setPreferredSize(new Dimension(75, 25));
    buttonPanel.add(closeButton);
    
    // Add Panels to Window
    this.add(infoPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }
}
