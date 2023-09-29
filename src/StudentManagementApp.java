/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class StudentManagementApp {

    private static Scanner scanner = new Scanner(System.in);
    public static List<Student> students = new ArrayList<>();
    private static int studentCount = 0;
    
    public static void main(String[] args) {
        
    }
    public static void displayMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("--------------------------------------------------");
        System.out.println("Enter 1 to launch menu or any other key to exit.");
        
        int input;
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid selection. Exiting the program.");
            return;
        }
        
        if (input == 1) {
            while (true) {
                //Display the menu
                System.out.println("MENU:");
                System.out.println("1. Capture a new Student");
                System.out.println("2. Search for a student.");
                System.out.println("3. Delete a student.");
                System.out.println("4. Print student report.");
                System.out.println("5. Exit application.");
                
                int option = scanner.nextInt();
                scanner.nextLine();
                
                if (option == 1) {
                    saveStudent();
                } else if (option == 2) {
                    searchStudent();
                } else if (option == 3) {
                    deleteStudent();
                } else if (option == 4) {
                    studentReport();
                } else if (option == 5) {
                    System.out.println("Exiting App.");
                    return;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    
                }
            }
        } else {
            System.out.println("Exiting App.");
        }
        
        
    }
    
    public static void saveStudent() {
        Scanner in = new Scanner(System.in);
        studentCount++;
        
        System.out.println("-------------------------------------");
        System.out.println("STUDENT" + studentCount);
        System.out.println("-------------------------------------");
        
        System.out.println("Enter the student id:");
        int id = in.nextInt();
        System.out.println("Enter the student name:");
        String name = in.nextLine();
        System.out.println("Enter the student age:");
        int age;
        while (true) {
            try {
                age = in.nextInt();
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age!!!");
                }
            } catch (InputMismatchException e) { 
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age!!!");
                in.nextLine();
            }
            
        }
        in.nextLine();
        System.out.println("Enter the student email:");
        String email = in.nextLine();
        System.out.println("Enter the student course:");
        String course = in.nextLine();

        Student student = new Student(id, name, age, email, course);
        students.add(student);
        
        System.out.println("---------------------------------------------------");
        System.out.println("Student details have been successfully saved.");
        
}


public static void searchStudent() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the student id to search:");
        int searchId = in.nextInt();
        in.nextLine();
        
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == searchId) {
                 System.out.println("STUDENT ID:" + student.getId());
                 System.out.println("STUDENT NAME" + student.getName());
                 System.out.println("STUDENT AGE" + student.getAge());
                 System.out.println("STUDENT EMAIL" + student.getEmail());
                 System.out.println("STUDENT COURSE" + student.getCourse());
                 found = true;
                 break;
            }
        }
        
        if (!found) {
            System.out.println("Student with student Id:" + searchId + "was not found!");
        }
}

public static void deleteStudent(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the student id to delete:");
    int deleteId = in.nextInt();
    in.nextLine();
    
    boolean deleted = false;
    for (Student student : students) {
        if (student.getId() == deleteId) {
            System.out.println("ARE YOU SURE WANT TO DELETE STUDENT:" + student.getId() + "FROM THE SYSTEM? [y] ");
            String confirmation = in.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                students.remove(students);
                System.out.println("Student with Student Id:" + deleteId + "was deleted!");
                deleted = true;
            }
            break;
        }
    }
    
    if (!deleted) {
        System.out.println("Student with Student Id:" + deleteId + "was not found!");
    }
}

public static void studentReport() {
    System.out.println("STUDENT REPORT");
    System.out.println("-----------------------------------------------------------");
    for (Student student : students) {
        System.out.println("STUDENT ID:" + student.getId());
        System.out.println("STUDENT NAME" + student.getName());
        System.out.println("STUDENT AGE" + student.getAge());
        System.out.println("STUDENT EMAIL" + student.getEmail());
        System.out.println("STUDENT COURSE" + student.getCourse());
        System.out.println();
    }
}
public static boolean isStudentAgeValid(int age) {
    return age >= 16 && age <= 100;
}

public static boolean  isStudentAgeValid(String age) {
    try {
        int ageValue = Integer.parseInt(age);
        return isStudentAgeValid(ageValue);
    } catch (NumberFormatException e) {
        return false;
    }
}

}