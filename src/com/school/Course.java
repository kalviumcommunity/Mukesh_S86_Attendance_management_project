package com.school;

public class Course {
    private int courseId;
    private String courseName;

    public void setDetails(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + this.courseId);
        System.out.println("Course Name: " + this.courseName);
    }
}
