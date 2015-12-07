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
      ArrayList<Object> courses = new ArrayList<Object>();
      String filename = fileChooser.getSelectedFile().getPath();
      try {
        // Open file for reading
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        // Read Lines
        // TODO Implement actual Course import
        String line;
        int i = 0;
        while((line = bufferedReader.readLine()) != null) {
          // Unfinished
          courses.add(new Course(String.valueOf(i), line, bufferedReader.readLine(), bufferedReader.readLine(),
                                                            bufferedReader.readLine(), bufferedReader.readLine()));
          
          // Bypass Trash in temp file
          bufferedReader.readLine();
          bufferedReader.readLine();
          bufferedReader.readLine();
          i += 1;
        }
        
        // Close Reader
        bufferedReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("Unable to Open File " + filename);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      // Temp Course Duplicate Remover for faster searching
      
      
      
      // Update Course Database
      UpdateDatabase.updateTable(Course.class, courses);
    }
  }
}
