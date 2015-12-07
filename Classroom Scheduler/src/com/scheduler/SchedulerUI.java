package com.scheduler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class SchedulerUI extends JFrame {
  private static final long serialVersionUID = 1L;
  private static boolean ready = false;
  private static boolean admin = false;
  private JFrame frame;
  SchedulerTableModel scheduleTableModel;
  SchedulerTableModel courseTableModel;
  
  public SchedulerUI() {
    frame = new JFrame();
    frame.setTitle("Logged In");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1200, 800);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout(2,1));
    
    // Create Components
    ButtonActionListener buttonListener = new ButtonActionListener(frame);
    JPanel tablePanel = new JPanel(new GridBagLayout());
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    GridBagConstraints setup = new GridBagConstraints();
    
    /************************
     * SCHEDULE TABLE SETUP *
     ************************/
    Object[][] scheduleData = TableDataRetriever.getTableData("Schedule", new int[]{1, 2, 4, 9, 6, 8});
    String[] columnNames = new String[]{"Course ID", "Department", "Course", "Start Time", "End Time", "Instructor"};
    scheduleTableModel = new SchedulerTableModel(scheduleData, columnNames);
    JTable scheduleTable = new JTable(scheduleTableModel);
    
    // Mouse Listener
    scheduleTable.addMouseListener(new ScheduleTableMouseListener());
    
    // Layout Parameters
    setup.fill = GridBagConstraints.BOTH;
    setup.weightx = 1;
    setup.weighty = 1;
    setup.gridx = 1;
    setup.insets = new Insets(10,5,10,10);
    
    // Create Scroll Pane for Table
    JScrollPane scheduleScrollPane = new JScrollPane(scheduleTable);
    scheduleScrollPane.setBorder(BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                  "Course Schedule", TitledBorder.CENTER, TitledBorder.TOP));
    tablePanel.add(scheduleScrollPane, setup);
    
    /**********************
     * Course Table Setup *
     **********************/
    Object[][] courseData = TableDataRetriever.getTableData("Course", new int[]{2});
    Toolbox.twoDArraySort(courseData, 0);
    courseData = Toolbox.twoDArrayDuplicateRemoval(courseData, 0);
    columnNames = new String[]{"Course"};
    courseTableModel = new SchedulerTableModel(courseData, columnNames);
    JTable courseTable = new JTable(courseTableModel);
    courseTable.setPreferredScrollableViewportSize(new Dimension(1, 1));
    
    // Mouse Listener
    courseTable.addMouseListener(new CourseTableMouseListener(scheduleTableModel));
    
    // Layout Parameters
    setup.fill = GridBagConstraints.BOTH;
    setup.weightx = 0.5;
    setup.weighty = 1;
    setup.gridx = 0;
    setup.insets = new Insets(10,10,10,5);
    
    // Create Scroll Pane for Table
    JScrollPane courseScrollPane = new JScrollPane(courseTable);
    courseScrollPane.setBorder(BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                    "Course List", TitledBorder.CENTER, TitledBorder.TOP));
    tablePanel.add(courseScrollPane, setup);
    
    // Setup Popup Menu
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem menuItemRemove = new JMenuItem("Remove");
    menuItemRemove.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          int selectedRow = scheduleTable.getSelectedRow();
          scheduleTableModel.removeRow(selectedRow);
      }
    });
    popupMenu.add(menuItemRemove);
    
    // Set Table Popup Menus
    scheduleTable.setComponentPopupMenu(popupMenu);
    
    while (!ready) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e1) {
        Thread.currentThread().interrupt();
      }
    }
    
    // Admin Only Buttons
    if (SchedulerUI.isAdmin()) {
      // Requested Changes Button
      JButton requestedChanges = new JButton("Requests");
      requestedChanges.addActionListener(buttonListener);
      requestedChanges.setPreferredSize(new Dimension(100, 25));
      buttonPanel.add(requestedChanges);
      
      // Run Scheduler Button
      JButton runScheduler = new JButton("Scheduler");
      runScheduler.addActionListener(buttonListener);
      runScheduler.setPreferredSize(new Dimension(100, 25));
      buttonPanel.add(runScheduler);
      
      // Update Course List Button
      JButton updateCourses = new JButton("Courses");
      updateCourses.addActionListener(buttonListener);
      updateCourses.setPreferredSize(new Dimension(100, 25));
      buttonPanel.add(updateCourses);
      
      // Update Classroom Database Button
      JButton updateClassrooms = new JButton("Classrooms");
      updateClassrooms.addActionListener(buttonListener);
      updateClassrooms.setPreferredSize(new Dimension(100, 25));
      buttonPanel.add(updateClassrooms);
    }
    
    // Setup Close Button Button
    JButton closeButton = new JButton("Close");
    closeButton.setPreferredSize(new Dimension(100, 25));
    closeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Main Close Button should exit the program
        System.exit(0);
      }
    });
    buttonPanel.add(closeButton);
    
    // Set Default Button
    // TODO: Fix this (doesn't set close as default)
    frame.getRootPane().setDefaultButton(closeButton);
    closeButton.requestFocus();
    
    // Add Labels to Window
    frame.add(tablePanel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);
  }
    
  public void showUI() {
    frame.setVisible(true);
  }
  public static boolean isAdmin() {
    return admin;
  }
  
  // Temporary Fix, Having a public method that makes you admin is probably not wise
  public static void setAdmin(boolean admin) {
    SchedulerUI.admin = admin;
  }

  public static void setReady(boolean b) {
    SchedulerUI.ready = true;
  }
}

