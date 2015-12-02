package com.scheduler;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
  @Id
  private String courseId;
  private String courseDepartment;
  private String courseNumber;
  private String startTime;
  private String endTime;
  private String roomNumber;
  
  public Schedule(String courseId, String courseDepartment, String courseNumber,
                                String startTime, String endTime, String roomNumber) {
    this.courseId = courseId;
    this.courseDepartment = courseDepartment;
    this.courseNumber = courseNumber;
    this.startTime = startTime;
    this.endTime = endTime;
    this.roomNumber = roomNumber;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseDepartment() {
    return courseDepartment;
  }

  public void setCourseDepartment(String courseDepartment) {
    this.courseDepartment = courseDepartment;
  }

  public String getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(String courseNumber) {
    this.courseNumber = courseNumber;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }
}
