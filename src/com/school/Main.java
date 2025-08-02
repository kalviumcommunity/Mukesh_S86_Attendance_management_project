package com.school;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        Course[] courses = new Course[2];

        // Initialize and set student details
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setDetails(100 + i, "Student" + (i + 1));
        }

        // Initialize and set course details
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new Course();
            courses[i].setDetails(200 + i, "Course" + (i + 1));
        }

        System.out.println("----- Student Details -----");
        for (Student s : students) {
            s.displayDetails();
            System.out.println();
        }

        System.out.println("----- Course Details -----");
        for (Course c : courses) {
            c.displayDetails();
            System.out.println();
        }
    }
}
