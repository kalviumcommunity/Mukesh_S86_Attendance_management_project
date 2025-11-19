package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storage;

    public RegistrationService(FileStorageService storage) {
        this.storage = storage;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public Student registerStudent(String name, String gradeLevel) {
        Student s = new Student(name, gradeLevel);
        students.add(s);
        return s;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher t = new Teacher(name, subject);
        teachers.add(t);
        return t;
    }

    public Staff registerStaff(String name, String role) {
        Staff st = new Staff(name, role);
        staffMembers.add(st);
        return st;
    }

    public Course createCourse(String courseName, int capacity) {
        Course c = new Course(courseName, capacity);
        courses.add(c);
        return c;
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        if (student == null || course == null) return false;
        boolean added = course.addStudent(student);
        if (added) {
            System.out.println("Enrolled " + student.getName() + " (ID:" + student.getId() + ") in course " + course.getCourseName());
        } else {
            System.out.println("Failed to enroll " + student.getName() + " in course " + course.getCourseName() + ". Course may be full or student already enrolled.");
        }
        return added;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    public void saveAllRegistrations() {
        storage.saveData(students, "students.txt");
        storage.saveData(teachers, "teachers.txt");
        storage.saveData(staffMembers, "staff.txt");
        storage.saveData(courses, "courses.txt");
    }
}
