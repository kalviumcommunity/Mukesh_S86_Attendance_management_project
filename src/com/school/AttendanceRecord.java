package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        if (status != null && (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status. Setting status to 'Invalid'.");
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")"
                + ", Course: " + course.getCourseName() + " (C" + course.getCourseId() + ")"
                + ", Status: " + status);
    }

    @Override
    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
