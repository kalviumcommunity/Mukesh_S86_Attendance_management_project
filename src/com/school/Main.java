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

        // File storage and attendance service
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

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

        // Attendance Recording using AttendanceService
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
        // mark by ids using lookup overload
        attendanceService.markAttendance(students.get(2).getId(), courses.get(2).getCourseId(), "Late", students, courses); // invalid -> becomes "Invalid"
        attendanceService.markAttendance(students.get(3), courses.get(0), "present");

        System.out.println("----- Attendance Records (from AttendanceService) -----");
        attendanceService.displayAttendanceLog();

        // Display attendance for specific student and course
        attendanceService.displayAttendanceLog(students.get(0));
        attendanceService.displayAttendanceLog(courses.get(0));

        // Save data using AttendanceService and FileStorageService
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        attendanceService.saveAttendanceData();
    }
}
