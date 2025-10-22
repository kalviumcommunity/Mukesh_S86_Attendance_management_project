package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("----- School Directory (Polymorphic display) -----");
        for (Person p : people) {
            p.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<AttendanceRecord> records = new ArrayList<>();

        // Create students using constructor
        students.add(new Student("Alice", "Grade 10"));
        students.add(new Student("Bob", "Grade 11"));
        students.add(new Student("Charlie", "Grade 12"));
        students.add(new Student("Diana", "Grade 10"));

        // Create courses using constructor
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Chemistry"));

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

    // Attendance Recording (now passing objects)
    records.add(new AttendanceRecord(students.get(0), courses.get(0), "Present"));
    records.add(new AttendanceRecord(students.get(1), courses.get(1), "Absent"));
    records.add(new AttendanceRecord(students.get(2), courses.get(2), "Late")); // Invalid status
    records.add(new AttendanceRecord(students.get(3), courses.get(0), "present")); // Lowercase, should be valid

        System.out.println("----- Attendance Records -----");
        for (AttendanceRecord record : records) {
            record.displayRecord();
        }

        // File Storage
        FileStorageService storage = new FileStorageService();
        // Save students list (already List<Student>)
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");
    }
}
