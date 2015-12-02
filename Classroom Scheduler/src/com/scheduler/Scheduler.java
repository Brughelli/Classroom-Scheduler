package com.scheduler;

import java.util.ArrayList;

public class Scheduler {
  private Scheduler() {
    
  }
  
  // TODO Replace Temp Schedule with Real Algorithm
  public static void runScheduler() {
    ArrayList<Object> schedules = new ArrayList<Object>();
    
    // Temp Schedule
    for (int i = 0; i < 10; i++) {
      schedules.add(new Schedule(String.valueOf("0" + i), "CSCI", "4300", "10:00", "10:50", "ECCS 120"));
    }
    for (int i = 10; i < 20; i++) {
      schedules.add(new Schedule(String.valueOf(i), "CSCI", "4800", "11:00", "11:50", "ECCS 120"));
    }
    for (int i = 20; i < 40; i++) {
      schedules.add(new Schedule(String.valueOf(i), "CSCI", "3300", "12:00", "12:50", "ECCS 120"));
    }
    for (int i = 40; i < 60; i++) {
      schedules.add(new Schedule(String.valueOf(i), "CSCI", "2300", "1:00", "1:50", "ECCS 120"));
    }
    for (int i = 60; i < 80; i++) {
      schedules.add(new Schedule(String.valueOf(i), "CSCI", "2400", "2:00", "2:50", "ECCS 120"));
    }
    for (int i = 80; i < 100; i++) {
      schedules.add(new Schedule(String.valueOf(i), "CSCI", "1300", "3:00", "3:50", "ECCS 120"));
    }
    
    DatabaseToolbox.updateDatabse(Schedule.class, schedules);
  }
}
