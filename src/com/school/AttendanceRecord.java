package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status;

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        if (status != null && (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status. Setting status to 'Invalid'.");
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student ID: " + studentId + ", Course ID: C" + courseId + ", Status: " + status);
    }
}
