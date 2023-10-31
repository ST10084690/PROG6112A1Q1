/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class StudentDatabase {
    private Student[] students;
    private int studentCount;
    
    // Constructor
    public StudentDatabase(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }
    
    // Add a student to the database
    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Database is full. Cannot add more students.");
        }
    }
    
    // Search for a student by ID
    public Student searchStudentById(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }
        return null; // Student not found
    }
    
    // List all students in the database
    public void listAllStudents() {
        System.out.println("\nStudent Database:");
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("-------------------------");
        }
    }
}
