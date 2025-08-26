# Attendance Management Project

This project is a basic Java application designed to manage attendance by modeling core entities like `Student` and `Course`. It follows an object-oriented programming approach and demonstrates foundational concepts such as class creation, encapsulation, arrays of objects, and use of the `this` keyword.

---

## Session 1: Project Setup and Orientation

- Set up the initial folder structure for the Java project.
- Created the `Main.java` file with a welcome message.
- Verified the build process using `javac` and executed the app using `java`.

### File Structure

- `src/com/school/Main.java`: Entry point of the program.


## Session 2: Core Domain Modelling
- Defined `Student` class with `studentId`, `name`, `setDetails()`, and `displayDetails()` method.
- Defined `Course` class with `courseId`, `courseName`, `setDetails()`, and `displayDetails()` method.
- Utilized arrays of objects in `Main.java` to manage and display multiple students and courses.
- Introduced basic usage of `this` keyword.

# Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run (ensure this is up-to-date)
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`