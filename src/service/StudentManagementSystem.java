package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
	private List<Student> students;
	private int nextStudentId;

	public StudentManagementSystem() {
		students = new ArrayList<>();
		nextStudentId = 10000;
	}

	public void addStudent(String name) {
		String studentId = generateStudentId();
		Student student = new Student(studentId, name);
		students.add(student);
		System.out.println("Student added successfully. Student ID: " + studentId);
	}

	private String generateStudentId() {
		return String.valueOf(nextStudentId++);
	}

	public void enrollStudent(String studentId, String course) {
		Student student = findStudentById(studentId);
		if (student != null) {
			student.enroll(course);
			System.out.println("Enrollment successful for student ID: " + studentId);
		} else {
			System.out.println("Student ID not found.");
		}
	}

	public void viewBalance(String studentId) {
		Student student = findStudentById(studentId);
		if (student != null) {
			System.out.println("Balance for student ID " + studentId + ": $" + student.getBalance());
		} else {
			System.out.println("Student ID not found.");
		}
	}

	public void payTuition(String studentId, double amount) {
		Student student = findStudentById(studentId);
		if (student != null) {
			student.payTuition(amount);
			System.out.println("Payment of $" + amount + " received from student ID: " + studentId);
		} else {
			System.out.println("Student ID not found.");
		}
	}

	public void showStatus(String studentId) {
		Student student = findStudentById(studentId);
		if (student != null) {
			System.out.println("----- Student Details -----");
			System.out.println("Name: " + student.getName());
			System.out.println("Student ID: " + student.getStudentId());
			System.out.println("Courses Enrolled: " + student.getCourses());
			System.out.println("Balance: $" + student.getBalance());
		} else {
			System.out.println("Student ID not found.");
		}
	}

	private Student findStudentById(String studentId) {
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentManagementSystem sms = new StudentManagementSystem();

		while (true) {
			System.out.println("\n---- Student Management System ----");
			System.out.println("1. Add Student");
			System.out.println("2. Enroll Student");
			System.out.println("3. View Balance");
			System.out.println("4. Pay Tuition Fees");
			System.out.println("5. Show Status");
			System.out.println("6. Quit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				System.out.print("Enter student name: ");
				String name = scanner.nextLine();
				sms.addStudent(name);
				break;
			case 2:
				System.out.print("Enter student ID: ");
				String studentId = scanner.nextLine();
				System.out.print("Enter course to enroll: ");
				String course = scanner.nextLine();
				sms.enrollStudent(studentId, course);
				break;
			case

					3:
				System.out.print("Enter student ID: ");
				studentId = scanner.nextLine();
				sms.viewBalance(studentId);
				break;
			case 4:
				System.out.print("Enter student ID: ");
				studentId = scanner.nextLine();
				System.out.print("Enter payment amount: $");
				double amount = scanner.nextDouble();
				sms.payTuition(studentId, amount);
				break;
			case 5:
				System.out.print("Enter student ID: ");
				studentId = scanner.nextLine();
				sms.showStatus(studentId);
				break;
			case 6:
				System.out.println("Exiting the program.");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

class Student {
	private String studentId;
	private String name;
	private List<String> courses;
	private double balance;

	public Student(String studentId, String name) {
		this.studentId = studentId;
		this.name = name;
		this.courses = new ArrayList<>();
	}

	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public double getBalance() {
		return balance;
	}

	public void enroll(String course) {
		courses.add(course);
	}

	public void payTuition(double amount) {
		balance -= amount;
	}
}
