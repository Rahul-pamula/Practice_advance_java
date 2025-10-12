package com.hibernate.pract.main;

import com.hibernate.pract.dao.StudentDao;
import com.hibernate.pract.model.Student;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert new record");
            System.out.println("2. Update existing record (name & course)");
            System.out.println("3. Delete a record");
            System.out.println("4. Select a record by ID");
            System.out.println("5. Show all records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student course: ");
                        String course = scanner.nextLine();
                        Student newStudent = new Student(name, age, course);
                        dao.saveStudent(newStudent);
                        System.out.println("Student inserted.");
                        break;

                    case 2:
                        System.out.print("Enter student ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new course: ");
                        String newCourse = scanner.nextLine();
                        dao.updateStudentDetails(updateId, newName, newCourse);
                        System.out.println("Student updated.");
                        break;

                    case 3:
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = scanner.nextInt();
                        dao.deleteStudent(deleteId);
                        System.out.println("Student deleted.");
                        break;

                    case 4:
                        System.out.print("Enter student ID to select: ");
                        int selectId = scanner.nextInt();
                        Student student = dao.getStudent(selectId);
                        if (student != null) {
                            System.out.println("Fetched: " + student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        List<Student> students = dao.getAllStudents();
                        if (students.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            System.out.println("\n--- All Students ---");
                            students.forEach(System.out::println);
                        }
                        break;

                    case 6:
                        System.out.println("Exiting application.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.close();
    }
}