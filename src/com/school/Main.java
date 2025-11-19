package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("----- School Directory (Polymorphic display) -----");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // File storage, registration and attendance services
        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // Register students
        Student s1 = regService.registerStudent("Alice", "Grade 10");
        Student s2 = regService.registerStudent("Bob", "Grade 11");
        Student s3 = regService.registerStudent("Charlie", "Grade 12");
        Student s4 = regService.registerStudent("Diana", "Grade 10");

        // Create courses with capacities
        Course c1 = regService.createCourse("Mathematics", 2); // capacity 2
        Course c2 = regService.createCourse("Physics", 1);     // capacity 1
        Course c3 = regService.createCourse("Chemistry", 3);   // capacity 3

        // Register teachers and staff
        Teacher teacher1 = regService.registerTeacher("Mr. Smith", "Mathematics");
        Teacher teacher2 = regService.registerTeacher("Ms. Johnson", "Physics");
        Staff staff1 = regService.registerStaff("Mrs. Brown", "Clerk");
        Staff staff2 = regService.registerStaff("Mr. Green", "Lab Assistant");

        System.out.println("----- Student Details -----");
        for (Student s : regService.getStudents()) {
            s.displayDetails();
            System.out.println();
        }

        System.out.println("----- Teacher Details -----");
        for (Teacher t : regService.getTeachers()) {
            t.displayDetails();
            System.out.println();
        }

        System.out.println("----- Staff Details -----");
        for (Staff st : regService.getStaffMembers()) {
            st.displayDetails();
            System.out.println();
        }

        System.out.println("----- Course Details -----");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
            System.out.println();
        }

        // Enroll students in courses (including an over-capacity attempt)
        System.out.println("----- Enrollments -----");
        regService.enrollStudentInCourse(s1, c1); // should succeed
        regService.enrollStudentInCourse(s2, c1); // should succeed (fills c1)
        regService.enrollStudentInCourse(s3, c1); // should fail (over capacity)

        regService.enrollStudentInCourse(s3, c2); // should succeed
        regService.enrollStudentInCourse(s4, c2); // should fail (over capacity)

        // Display updated course details after enrollments
        System.out.println("----- Course Details (After Enrollment) -----");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
            System.out.println();
        }

        // Attendance Recording using AttendanceService
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c2, "Absent");
        // mark by ids using lookup overload (uses RegistrationService)
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Late"); // invalid -> becomes "Invalid"
        attendanceService.markAttendance(s4, c1, "present");

        System.out.println("----- Attendance Records (from AttendanceService) -----");
        attendanceService.displayAttendanceLog();

        // Display attendance for specific student and course
        attendanceService.displayAttendanceLog(s1);
        attendanceService.displayAttendanceLog(c1);

        // Display school directory using RegistrationService
        displaySchoolDirectory(regService);

        // Save registrations and attendance
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
