/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class Student {
        private int studentId;
    private String name;
    private int age;
    
    // Constructor
    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
    
    // Getter methods
    public int getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
}
