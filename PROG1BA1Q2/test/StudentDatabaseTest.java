/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author lab_services_student
 */
public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @Before
    public void setUp() {
        studentDatabase = new StudentDatabase(5); // Create a database with a capacity of 5 for testing
    }


    @Test
    public void testAddStudent() {
        Student student1 = new Student(1, "Alice", 20);
        studentDatabase.addStudent(student1);
        assertEquals(1, studentDatabase.searchStudentById(1).getStudentId());
    }

    @Test
    public void testSearchStudentById() {
        Student student1 = new Student(1, "Alice", 20);
        studentDatabase.addStudent(student1);
        Student foundStudent = studentDatabase.searchStudentById(1);
        assertNotNull(foundStudent);
        assertEquals("Alice", foundStudent.getName());
        assertEquals(20, foundStudent.getAge());
    }

    @Test
    public void testListAllStudents() {
        Student student1 = new Student(1, "Alice", 20);
        Student student2 = new Student(2, "Bob", 22);
        studentDatabase.addStudent(student1);
        studentDatabase.addStudent(student2);

        String expectedOutput = "\nStudent Database:\n" +
                "ID: 1\nName: Alice\nAge: 20\n-------------------------\n" +
                "ID: 2\nName: Bob\nAge: 22\n-------------------------\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        studentDatabase.listAllStudents();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDatabaseFull() {
        Student student1 = new Student(1, "Alice", 20);
        Student student2 = new Student(2, "Bob", 22);
        Student student3 = new Student(3, "Charlie", 25);
        Student student4 = new Student(4, "David", 21);
        Student student5 = new Student(5, "Eva", 23);
        Student student6 = new Student(6, "Frank", 24);

        studentDatabase.addStudent(student1);
        studentDatabase.addStudent(student2);
        studentDatabase.addStudent(student3);
        studentDatabase.addStudent(student4);
        studentDatabase.addStudent(student5);

        studentDatabase.addStudent(student6); // This should not be added due to database full

        assertNull(studentDatabase.searchStudentById(6));
    }
}