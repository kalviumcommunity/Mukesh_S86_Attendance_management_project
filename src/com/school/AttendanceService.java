package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) {
            System.out.println("Cannot mark attendance: student or course is null");
            return;
        }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student s = findStudentById(studentId, allStudents);
        Course c = findCourseById(courseId, allCourses);
        if (s == null) {
            System.out.println("Warning: Student with ID " + studentId + " not found. Attendance not recorded.");
            return;
        }
        if (c == null) {
            System.out.println("Warning: Course with ID " + courseId + " not found. Attendance not recorded.");
            return;
        }
        markAttendance(s, c, status);
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        if (allStudents == null) return null;
        for (Student s : allStudents) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        if (allCourses == null) return null;
        for (Course c : allCourses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("----- Attendance Log (All) -----");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("----- Attendance Log for Student: " + student.getName() + " (ID: " + student.getId() + ") -----");
        for (AttendanceRecord r : attendanceLog) {
            if (r.getStudent().getId() == student.getId()) {
                r.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("----- Attendance Log for Course: " + course.getCourseName() + " (C" + course.getCourseId() + ") -----");
        for (AttendanceRecord r : attendanceLog) {
            if (r.getCourse().getCourseId() == course.getCourseId()) {
                r.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }

    public List<AttendanceRecord> getAttendanceLog() {
        return attendanceLog;
    }
}
