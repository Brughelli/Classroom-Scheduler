package com.scheduler;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SchedulerDialog extends JDialog {
  private static final long serialVersionUID = 1L;

  public SchedulerDialog() {
    // Setup Window
    this.setSize(250, 100);
    this.setLocationRelativeTo(null);   //Center Login
    this.setTitle("Course Details");
    this.setResizable(false);
    this.setLayout(new BorderLayout());
    
    // Create Panels
    JPanel labelPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    
    // Confirmation Label
    JLabel confirmationLabel = new JLabel("Do you want to run the Scheduler?");
    labelPanel.add(confirmationLabel);
    
    // Confirmation Button
    JButton confirmRun = new JButton("Yes");
    confirmRun.setPreferredSize(new Dimension(50, 25));
    confirmRun.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Scheduler.runScheduler();
      }
    });
    buttonPanel.add(confirmRun);
    
    // Cancel Button
    JButton cancelRun = new JButton("No");
    cancelRun.setPreferredSize(new Dimension(50, 25));
    cancelRun.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    buttonPanel.add(cancelRun);

    // Add Panels to main panel
    this.add(labelPanel, BorderLayout.NORTH);
    this.add(buttonPanel, BorderLayout.CENTER);
  }
}
