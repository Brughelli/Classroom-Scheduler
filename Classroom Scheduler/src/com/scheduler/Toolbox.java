package com.scheduler;

import java.util.ArrayList;

public class Toolbox {
  private Toolbox() {
    
  }
  
  /**
   * Creates a new sorting condition based on the sortIndex of each sub
   * array. 2D array is sorted based on data at the sortIndex.
   * 
   * @param array       2D array of Objects to be sorted
   * @param sortIndex   index in sub arrays that will be used for sorting (Converted to Strings)
   * @return            void
   */
  public static void twoDArraySort(Object[][] array, int sortIndex) {
    java.util.Arrays.sort(array, new java.util.Comparator<Object[]>() {
      public int compare(Object[] a, Object[] b) {
          return ((String) a[sortIndex]).compareTo((String) b[sortIndex]);
      }
    });
  }
  
  /**
   * Creates a new 2D array of Strings with duplicate rows, based on dupIndex,
   * removed from the array.
   * 
   * @param array       2D array of Strings to be checked for duplicates
   * @param dupIndex    index in sub arrays that determine duplicate status
   * @return            2D array of Strings with dupIndex duplicates removed
   */
  public static String[][] twoDArrayDuplicateRemoval(String[][] array, int dupIndex) {
    ArrayList<String[]> tempArray = new ArrayList<String[]>();
    int size = array.length;
    
    // Transfer Data
    for (int i = 0; i < size; i++) {
      tempArray.add(array[i]);
    }
    
    //Remove Duplicates
    int i = 1;
    while (i < tempArray.size()) {
      if (tempArray.get(i)[dupIndex].equals(tempArray.get(i - 1)[dupIndex])) {
        tempArray.remove(i);
      } else {
        i += 1;
      }
    }
    
    // Create new String[][]
    String[][] dataArray = new String[tempArray.size()][];
    int numRows = tempArray.size();
    for (i = 0; i < numRows; i++) {
      dataArray[i] = tempArray.get(i);
    }
    
    return dataArray;
  }
}
