package com.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	// student register
	public static void studentRegister(Connection con, Scanner sc) throws SQLException {

		Greeting.intro("Student Registration");

		String name;
		String email;
		String password;
		String confirmPassword;

		System.out.println("Enter your name : ");
		name = sc.nextLine();

		while (name.isEmpty()) {
			System.out.println("Name cannot be empty. Enter your name again : ");
			name = sc.nextLine();
		}
		
		if (name.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}

		System.out.println("Enter your email : ");
		email = sc.nextLine();

		if (email.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}
		
		while (email.isEmpty() || !email.contains("@gmail.com")) {
			System.out.println("Invalid email. Enter your email again : ");
			email = sc.nextLine();
		}

		// Check whether email already exists
		String checkEmail = "select email from student where email = ?";

		PreparedStatement checkPs = con.prepareStatement(checkEmail);
		checkPs.setString(1, email);

		ResultSet rs = checkPs.executeQuery();

		if (rs.next()) {

			System.out.println("Email already exists. Please login.");

			rs.close();
			checkPs.close();

			Greeting.outro("Thank You");
			return;
		}

		rs.close();
		checkPs.close();

		System.out.println("Enter your password : ");
		password = sc.nextLine();
		
		if (password.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}

		while (password.isEmpty()) {
			System.out.println("Password cannot be empty. Enter your password again : ");
			password = sc.nextLine();
		}

		System.out.println("Enter your confirm password : ");
		confirmPassword = sc.nextLine();

		if (confirmPassword.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}
		
		while (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {

			if (confirmPassword.isEmpty()) {
				System.out.println("Confirm password cannot be empty.");
			} else {
				System.out.println("Password does not match.");
			}

			System.out.println("Enter your confirm password again : ");
			confirmPassword = sc.nextLine();
		}

		// Insert student data
		String sql = "insert into student(name, email, password, confirmPassword) values(?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, confirmPassword);

		int response = ps.executeUpdate();

		if (response > 0) {
			System.out.println("Student Registered Successfully");
		} else {
			System.out.println("Failure to register student");
		}

		ps.close();

		Greeting.outro("Thank You");
	}


	// ------------ student login
	public static void studentLogin(Connection con, Scanner sc) throws SQLException {

		Greeting.intro("Student Login");

		String email;
		String password;

		System.out.println("Enter your email : ");
		email = sc.nextLine();

		if (email.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}
		
		while (email.isEmpty() || !email.contains("@gmail.com")) {
			System.out.println("Invalid email. Enter your email again : ");
			email = sc.nextLine();
		}

		System.out.println("Enter your password : ");
		password = sc.nextLine();
		
		if (password.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}

		while (password.isEmpty()) {
			System.out.println("Password cannot be empty. Enter your password again : ");
			password = sc.nextLine();
		}

		String sql = "select * from student where email = ? and password = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, email);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			System.out.println("Welcome back to student dashboard : ");
			System.out.println("Name : " + rs.getString("name"));
			System.out.println("Email : " + rs.getString("email"));

		} else {

			System.out.println("Invalid email or password.");

		}

		rs.close();
		ps.close();

		Greeting.outro("Thank You");
	}


	// for the forgot password
	public static void studentForgotPassword(Connection con, Scanner sc) throws SQLException {

		Greeting.intro("Student Forgot Password Page");

		String email;
		String name;
		String password;
		String confirmPassword;

		System.out.println("Enter your email : ");
		email = sc.nextLine();
		
		if (email.equals("0")) {
		    System.out.println("Going back to main menu...");
		    return;
		}

		while (email.isEmpty() || !email.contains("@gmail.com")) {
			System.out.println("Invalid email , Enter your email again : ");
			email = sc.nextLine();
		}

		PreparedStatement ps = con.prepareStatement(
				"select * from student where email = ?");

		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			System.out.println("Enter your name : ");
			name = sc.nextLine();

			while (name.isEmpty()) {
				System.out.println("Name cannot be empty , Enter your name again : ");
				name = sc.nextLine();
			}

			System.out.println("Enter your new password : ");
			password = sc.nextLine();

			while (password.isEmpty()) {
				System.out.println("Password cannot be empty , Enter your password again : ");
				password = sc.nextLine();
			}

			System.out.println("Enter your confirm password : ");
			confirmPassword = sc.nextLine();

			if (confirmPassword.equals("0")) {
			    System.out.println("Going back to main menu...");
			    return;
			}
			
			while (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {

				if (confirmPassword.isEmpty()) {
					System.out.println("Enter your confirm password first.");
				} else {
					System.out.println("Password does not match.");
				}

				System.out.println("Enter confirm password again : ");
				confirmPassword = sc.nextLine();
			}

			ps = con.prepareStatement(
					"update student set name = ?, password = ?, confirmPassword = ? where sid = ?");

			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, confirmPassword);
			ps.setInt(4, rs.getInt("sid"));

			int response = ps.executeUpdate();

			if (response > 0) {
				System.out.println("Data updated Successfully");
			} else {
				System.out.println("Failed to update data.");
			}

		} else {

			System.out.println("Email not found.");

		}

		ps.close();
		rs.close();

		Greeting.outro("Thank You");
	}
}