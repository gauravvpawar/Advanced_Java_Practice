package com.register;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		Connection con = null;
		Scanner sc = new Scanner(System.in);

		String choice = "yess";

		while (choice.equals("yess") || choice.equals("Yess") || choice.equals("yes")) {

			try {

				Greeting.intro("Student Registration System");

				System.out.println("Enter operation you want to perform : ");
				System.out.println("\n1.Student register \n2.Login Student panel \n3.forgot password \n4.Admin Login");

				int action = sc.nextInt();
				sc.nextLine();

				con = JDBC_Config.getConnection();

				switch (action) {

				case 1:
					Student.studentRegister(con, sc);
					break;

				case 2:
					Student.studentLogin(con, sc);
					break;

				case 3:
					Student.studentForgotPassword(con, sc);
					break;

				case 4:
					AdminLogin.adminLogin(con, sc);
					break;

				default:
					System.out.println("Invalid operation. Please select 1 to 4.");
				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				try {
					JDBC_Config.closeConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			Greeting.outro("Enter Yess to continue");

			choice = sc.next();
		}

		Greeting.outro("Thank You Visit Again");

		sc.close();
	}
}