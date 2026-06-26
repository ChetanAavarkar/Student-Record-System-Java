package com.studentrecord;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class StudentRecordSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> students = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n===== Student Record System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Remove Students");
			System.out.println("4. Display Students");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
				case 1:
					System.out.print("Enter Student ID: ");
					int idToAdd = sc.nextInt();
					sc.nextLine();
				
					System.out.print("Enter Student Name: ");
					String name = sc.nextLine();
				
					students.put(idToAdd, name);
					System.out.println("Student added successfully.");
					break;
					
				case 2:
					System.out.print("Enter Student ID to search: ");
					int idToSearch = sc.nextInt();
					sc.nextLine();
					
					if (students.containsKey(idToSearch)) {
						System.out.println("Student Found: ID = " + idToSearch + ", Name = " + students.get(idToSearch));
					} else {
						System.out.println("Studnet not found.");
					}
					break;
					
				case 3:
					System.out.print("Enter studnet ID to remove: ");
					int idToRemove = sc.nextInt();
					sc.nextLine();
					
					if (students.remove(idToRemove) != null) {
						System.out.println("Student removed successfully.");
					} else {
						System.out.println("Student not found");
					}
					break;
					
				case 4:
					if (students.isEmpty()) {
						System.out.println("No students available.");
					} else {
						System.out.println("\n--- Student List ---");
						for (Map.Entry<Integer, String> entry : students.entrySet()) {
							System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
						}
					}
					break;
					
				case 5:
					System.out.println("Exiting program...");
					sc.close();
					return;
					
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
