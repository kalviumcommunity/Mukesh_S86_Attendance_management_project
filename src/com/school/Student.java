package com.school;

public class Student {
    private int studentId;
    private String name;

    public void setDetails(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Name: " + this.name);
    }
}
