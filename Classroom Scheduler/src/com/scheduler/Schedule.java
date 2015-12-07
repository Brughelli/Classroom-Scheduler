package com.scheduler;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
  @Id
  private String courseId;
  private String courseDepartment;
  private String courseNumber;
  private String courseName;
  private String instructorName;
  private String enrollmentSize;
  private String day;
  private String startTime;
  private String endTime;
  
  public Schedule(String courseId, String courseDepartment, String courseNumber, String courseName,
                                String instructor, String enrollment, String day,
                                String startTime, String endTime) {
    this.courseId = courseId;
    this.courseDepartment = courseDepartment;
    this.courseNumber = courseNumber;
    this.courseName = courseName;
    this.instructorName = instructor;
    this.enrollmentSize = enrollment;
    this.day = day;
    this.startTime = startTime;
    this.endTime = endTime;
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

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
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

  public String getInstructorName() {
    return instructorName;
  }

  public void setInstructorName(String instructorName) {
    this.instructorName = instructorName;
  }

  public String getEnrollmentSize() {
    return enrollmentSize;
  }

  public void setEnrollmentSize(String enrollmentSize) {
    this.enrollmentSize = enrollmentSize;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  
}
