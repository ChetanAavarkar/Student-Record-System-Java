package com.studentrecord;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * StudentRecordSystem - A simple console-based student management system
 * using HashMap to store student ID and Name.
 */
public class StudentRecordSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// a HashMap to store student records: Key = Student ID, Value = Student Name
		HashMap<Integer, String> students = new HashMap<>();

		// Scanner object to read user input
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// Display Menu
			System.out.println("\n===== Student Record System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Remove Students");
			System.out.println("4. Display Students");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();  // Consume the newline character after nextInt()
			
			switch (choice) {
				case 1:   // Add Student
					System.out.print("Enter Student ID: ");
					int s_id = sc.nextInt();
					sc.nextLine();   // Consume newline
				
					System.out.print("Enter Student Name: ");
					String name = sc.nextLine();
				
					students.put(s_id, name);   // Add to HashMap
					System.out.println("Student added successfully.");
					break;
					
				case 2:   // Search Student
					System.out.print("Enter Student ID to search: ");
					int searchId = sc.nextInt();
					sc.nextLine();
					
					if (students.containsKey(searchId)) {
						System.out.println("Student Found: ID = " + searchId + ", Name = " + students.get(searchId));
					} else {
						System.out.println("Student not found.");
					}
					break;
					
				case 3:  // Remove Student
					System.out.print("Enter student ID to remove: ");
					int removeId = sc.nextInt();
					sc.nextLine();
					
					if (students.remove(removeId) != null) {
						System.out.println("Student removed successfully.");
					} else {
						System.out.println("Student not found");
					}
					break;
					
				case 4:   // Display All Students
					if (students.isEmpty()) {
						System.out.println("No students available.");
					} else {
						System.out.println("\n--- Student List ---");
						// Iterate through HashMap using entrySet()
						for (Map.Entry<Integer, String> entry : students.entrySet()) {
							System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
						}
					}
					break;
					
				case 5:   // Exit Program
					System.out.println("Exiting program...");
					sc.close();   // Close scanner to prevent resource leak
					return;       // Exit the main method
					
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
