package com.scheduler;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
  @Id
  private String coursId;
  private String courseDepartment;
  private String courseNumber;
  private String courseName;
  private String instructorName;
  private String enrollmentSize;
  
  public Course(String id, String department,String number, String name, String instructor, String enrollment) {
    this.coursId = id;
    this.courseDepartment = department;
    this.courseNumber = number;
    this.courseName = name;
    this.instructorName = instructor;
    this.enrollmentSize = enrollment;
  }

  public String getCoursId() {
    return coursId;
  }

  public void setCoursId(String coursId) {
    this.coursId = coursId;
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
}
