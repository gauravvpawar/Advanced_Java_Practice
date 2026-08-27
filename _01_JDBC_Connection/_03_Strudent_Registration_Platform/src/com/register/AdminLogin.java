package com.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	public static void adminLogin(Connection con, Scanner sc) throws SQLException {

		Greeting.intro("Admin Login");
		
	    System.out.print("Enter your username: ");
	    String username = sc.nextLine();

	    if (username.equals("0")) {
	        System.out.println("Going back to main menu...");
	        return;
	    }
	    
	    while (username.isBlank()) {
	        System.out.print("Username cannot be empty. Enter username again: ");
	        username = sc.nextLine();
	    }

	    System.out.print("Enter your password: ");
	    String password = sc.nextLine();
	    
	    if (password.equals("0")) {
	        System.out.println("Going back to main menu...");
	        return;
	    }

	    while (password.isBlank()) {
	        System.out.print("Password cannot be empty. Enter password again: ");
	        password = sc.nextLine();
	    }

	    // Admin authentication
	    if (username.equals("admin") && password.equals("admin@123")) {

	        System.out.println("\nAdmin Login Successful!");
	        System.out.println("Welcome to Admin Panel.");

	        String sql = "SELECT name, email FROM student";

	        try (PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            System.out.println("\nStudent Data:");
	            System.out.println("--------------------------------------------------");
	            System.out.printf("%-20s %-30s%n", "Name", "Email");
	            System.out.println("--------------------------------------------------");

	            boolean studentFound = false;

	            while (rs.next()) {
	                studentFound = true;

	                String name = rs.getString("name");
	                String email = rs.getString("email");

	                System.out.printf("%-20s %-30s%n", name, email);
	            }

	            if (!studentFound) {
	                System.out.println("No students registered.");
	            }
	        }

	    } else {
	        System.out.println("Invalid admin username or password.");
	    }

	    Greeting.intro("Visit Again");
	  }
}
