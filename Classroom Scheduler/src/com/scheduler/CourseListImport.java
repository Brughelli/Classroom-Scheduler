package com.scheduler;

import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class CourseListImport {
  private CourseListImport(Window frame) {
    
  }
  
  public static void importCourses(Window frame) {
    // Get Course List
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(frame);
    if (result == JFileChooser.APPROVE_OPTION) {
      String filename = fileChooser.getSelectedFile().getPath();
      try {
        // Open file for reading
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        // Read Lines
        // TODO Implement actual Course import
        /*String line;
        while((line = bufferedReader.readLine()) != null) {
          // Unfinished
        }*/
        
        // Close Reader
        bufferedReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("Unable to Open File " + filename);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      // Temp Course Import
      ArrayList<Object> courses = new ArrayList<Object>();
      for (int i = 0; i < 10; i++) {
        courses.add(new Course(String.valueOf("0" + i), "CSCI", "4300", "Temp Name", "Professor X", "25"));
      }
      for (int i = 10; i < 20; i++) {
        courses.add(new Course(String.valueOf(i), "CSCI", "4800", "Temp Name", "Professor X", "25"));
      }
      for (int i = 20; i < 40; i++) {
        courses.add(new Course(String.valueOf(i), "CSCI", "3300", "Temp Name", "Professor X", "35"));
      }
      for (int i = 40; i < 60; i++) {
        courses.add(new Course(String.valueOf(i), "CSCI", "2300", "Temp Name", "Professor X", "50"));
      }
      for (int i = 60; i < 80; i++) {
        courses.add(new Course(String.valueOf(i), "CSCI", "2400", "Temp Name", "Professor X", "75"));
      }
      for (int i = 80; i < 100; i++) {
        courses.add(new Course(String.valueOf(i), "CSCI", "1300", "Temp Name", "Professor X", "100"));
      }
      
      // Update Course Database
      DatabaseToolbox.updateDatabse(Course.class, courses);
    }
  }
}
