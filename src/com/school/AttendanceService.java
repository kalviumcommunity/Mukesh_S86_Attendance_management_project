package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) {
            System.out.println("Cannot mark attendance: student or course is null");
            return;
        }
        // Optional: only mark attendance if student is enrolled in the course
        if (!course.getEnrolledStudents().contains(student)) {
            System.out.println("Cannot mark attendance: " + student.getName() + " is not enrolled in " + course.getCourseName());
            return;
        }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status) {
        Student s = registrationService.findStudentById(studentId);
        Course c = registrationService.findCourseById(courseId);
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
