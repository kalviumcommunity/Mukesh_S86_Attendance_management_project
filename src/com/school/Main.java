package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        Course[] courses = new Course[3];

        // Create students using constructor
        students[0] = new Student("Alice", "Grade 10");
        students[1] = new Student("Bob", "Grade 11");
        students[2] = new Student("Charlie", "Grade 12");
        students[3] = new Student("Diana", "Grade 10");

        // Create courses using constructor
        courses[0] = new Course("Mathematics");
        courses[1] = new Course("Physics");
        courses[2] = new Course("Chemistry");

        // Create Teacher and Staff objects
        Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "Physics");
        Staff staff1 = new Staff("Mrs. Brown", "Clerk");
        Staff staff2 = new Staff("Mr. Green", "Lab Assistant");

        System.out.println("----- Student Details -----");
        for (Student s : students) {
            s.displayDetails();
            System.out.println();
        }

        System.out.println("----- Teacher Details -----");
        teacher1.displayDetails();
        System.out.println();
        teacher2.displayDetails();
        System.out.println();

        System.out.println("----- Staff Details -----");
        staff1.displayDetails();
        System.out.println();
        staff2.displayDetails();
        System.out.println();

        System.out.println("----- Course Details -----");
        for (Course c : courses) {
            c.displayDetails();
            System.out.println();
        }

        // Attendance Recording
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "Late")); // Invalid status
        attendanceLog.add(new AttendanceRecord(students[3].getId(), courses[0].getCourseId(), "present")); // Lowercase, should be valid

        System.out.println("----- Attendance Records -----");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
