/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 *
 * @author lab_services_student
 */
public class StudentManagementAppTest {

    private static ByteArrayOutputStream outputStream;
    private static ByteArrayInputStream inputStream;
    private static PrintStream originalOut;
    private static InputStream originalIn;

    @BeforeAll
    public static void setUpStreams() {
        originalOut = System.out;
        originalIn = System.in;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @BeforeEach
    public void setInputOutput() {
        outputStream.reset();
    }

    @Test
    public void testSearchStudent() {
        StudentManagementApp.students.clear();
        Student student = new Student(1, "John", 20, "john@example.com", "Math");
        StudentManagementApp.students.add(student);

        inputStream = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(inputStream);

        StudentManagementApp.searchStudent();

        String expectedOutput = "Enter the student id to search:\nSTUDENT ID:1\nSTUDENT NAMEJohn\nSTUDENT AGE20\nSTUDENT EMAILjohn@example.com\nSTUDENT COURSEMath\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        StudentManagementApp.students.clear();

        inputStream = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(inputStream);

        StudentManagementApp.searchStudent();

        String expectedOutput = "Enter the student id to search:\nStudent with student Id:1was not found!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDeleteStudent() {
        StudentManagementApp.students.clear();
        Student student = new Student(1, "John", 20, "john@example.com", "Math");
        StudentManagementApp.students.add(student);

        inputStream = new ByteArrayInputStream("1\n1\ny\n".getBytes());
        System.setIn(inputStream);

        StudentManagementApp.deleteStudent();

        String expectedOutput = "Enter the student id to delete:\nARE YOU SURE WANT TO DELETE STUDENT:1FROM THE SYSTEM? [y] \nStudent with Student Id:1was deleted!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        StudentManagementApp.students.clear();

        inputStream = new ByteArrayInputStream("1\n1\n".getBytes());
        System.setIn(inputStream);

        StudentManagementApp.deleteStudent();

        String expectedOutput = "Enter the student id to delete:\nStudent with Student Id:1was not found!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        assertTrue(StudentManagementApp.isStudentAgeValid(18));
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        assertFalse(StudentManagementApp.isStudentAgeValid(15));
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        assertFalse(StudentManagementApp.isStudentAgeValid("abc"));
    }

    @Test
    public void testStudentAge_StudentAgeValidString() {
        assertTrue(StudentManagementApp.isStudentAgeValid("18"));
    }
}