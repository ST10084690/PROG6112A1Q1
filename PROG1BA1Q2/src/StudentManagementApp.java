/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class StudentManagementApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase studentDatabase = new StudentDatabase(10); // Create a database with a capacity of 10 students
        
        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student by ID");
            System.out.println("3. List all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    
                    Student student = new Student(studentId, name, age);
                    studentDatabase.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Student foundStudent = studentDatabase.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("ID: " + foundStudent.getStudentId());
                        System.out.println("Name: " + foundStudent.getName());
                        System.out.println("Age: " + foundStudent.getAge());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    studentDatabase.listAllStudents();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
    

