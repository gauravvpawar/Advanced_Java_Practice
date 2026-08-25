package com.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Connection con = null;
		PreparedStatement studentQuery = null;
		ResultSet rs = null;
		 String email = null;
		 String password = null;
		 String confirmPassword = null;
		int response = 0;
		Scanner sc = new Scanner(System.in);
		String choice = "yess";
		while(choice.equals("yess") || choice.equals("Yess") || choice.equals("yes"))
		{
		try
		{
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			System.out.println("+++++++++++++++++++++++++++++++++++++ Student Registration System +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			// to perform student operation
			System.out.println("Enter operation you want to perform : ");
			System.out.println("\n1.Student register \n2.Login Student panel \n3.forgot password \n4.Admin Login");
			int action = sc.nextInt();
			sc.nextLine();
			
			con = JDBC_Config.getConnection();
			
			switch(action)
			{
			case 1: 
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("+++++++++++++++++++++++++++++++++++++ Student Registration +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				
				System.out.println("Enter your name : ");
				String name = sc.nextLine();

				if (!name.isEmpty()) {

				    System.out.println("Enter your email: ");
				     email = sc.nextLine();

				    if (!email.isEmpty() && email.contains("@gmail.com")) {

				        System.out.println("Enter your password: ");
				         password = sc.nextLine();

				        if (!password.isEmpty()) {

				            System.out.println("Enter your confirm password: ");
				            confirmPassword = sc.nextLine();

				            if (!confirmPassword.isEmpty()) {

				            	while (!confirmPassword.equals(password)) {
				            	    System.out.println("Password does not match. Enter confirm password again: ");
				            	    confirmPassword = sc.nextLine();
				            	}
				            	
				            } else {
				                System.out.println("Enter your confirm password first.");
				                confirmPassword = sc.nextLine();
				            }

				        } else {
				            System.out.println("Enter your password first.");
				            password = sc.nextLine();
				        }

				    } else {
				        System.out.println("Enter your email first.");
				        password = sc.nextLine();
				    }

				} else {
				    System.out.println("Enter your name first.");
				    name = sc.nextLine();

				}
				
				PreparedStatement ps =  con.prepareStatement("insert into student(name , email , password , confirmPassword) values(?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				
//				studentQuery= con.prepareStatement("select * from student where email = ?");
//				rs = studentQuery.executeQuery();
//				while(rs.next())
//				{
//					System.out.println("Email already exist , please login");
////					studentQuery= con.prepareStatement("select * from student where email = ?");
////					rs = studentQuery.executeQuery();
//					
//					break;
//				}
				ps.setString(3, password);
				ps.setString(4, confirmPassword);
				
				response = ps.executeUpdate();
				if(response > 0)
				{
					System.out.println("Student Registered Successfully");
				}else {
					System.out.println("Failure to registerd student");
				}
				
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("+++++++++++++++++++++++++++++++++++++ Thank You +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				
				break;
				
			case 2:
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("+++++++++++++++++++++++++++++++++++++ Student Login +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				
				  System.out.println("Enter your email: ");
				     email = sc.nextLine();

				    if (!email.isEmpty() && email.contains("@gmail.com")) {

				        System.out.println("Enter your password: ");
				         password = sc.nextLine();
				         while (password.isEmpty()) {

						        System.out.println("Try again , Enter your password: ");
						         password = sc.nextLine();
				         }
				    }else {
				    	System.out.println("Enter the email again : ");
				    	email = sc.next();
				    }
				    
				  ps =  con.prepareStatement("select * from student where email = ? and password = ?");
				  ps.setString(1, email);
				  ps.setString(2, password);
				  rs = ps.executeQuery();
				  while(rs.next())
				  {
					  System.out.println("Welcome back to student dashboard : ");
					  System.out.println(rs.getString(2) + " " + rs.getString(3));  
				  }
				    
				
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("+++++++++++++++++++++++++++++++++++++ Thank You +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				break;
				
			case 3:
			    System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			    System.out.println("+++++++++++++++++++++++++++++++++++++ Student Forgot Password Page +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			    System.out.println("-------------------------------------------------------------------------------------------------------------------------");

			    System.out.println("Enter your email: ");
			    email = sc.nextLine();

			    if (!email.isEmpty() && email.contains("@gmail.com")) {

			        ps = con.prepareStatement("SELECT * FROM student WHERE email = ?");
			        ps.setString(1, email);

			        rs = ps.executeQuery();

			        if (rs.next()) {

			            System.out.println("Enter your name: ");
			            name = sc.nextLine();

			            if (!name.isEmpty()) {

			                System.out.println("Enter your password: ");
			                password = sc.nextLine();

			                if (!password.isEmpty()) {

			                    System.out.println("Enter your confirm password: ");
			                    confirmPassword = sc.nextLine();

			                    while (confirmPassword.isEmpty()
			                            || !confirmPassword.equals(password)) {

			                        if (confirmPassword.isEmpty()) {
			                            System.out.println("Enter your confirm password first.");
			                        } else {
			                            System.out.println("Password does not match.");
			                        }

			                        System.out.println("Enter confirm password again: ");
			                        confirmPassword = sc.nextLine();
			                    }

			                    ps = con.prepareStatement("update student set name=? , password =? , confirmPassword = ? where sid = '"+rs.getInt(1)+"'");
			                    ps.setString(1, name);
			                    ps.setString(2, password);
			                    ps.setString(3, confirmPassword);
			                    
			                    response = ps.executeUpdate();
			                    if(response > 0)
			                    {
			                    	System.out.println("Data updated Successfully");
			                    }else{
			                    System.out.println("Failed to update data.");
			                    }

			                } else {
			                    System.out.println("Enter your password first.");
			                    password = sc.nextLine();
			                }

			            } else {
			                System.out.println("Enter the name first.");
			                name = sc.nextLine();
			            }

			        } else {
			            System.out.println("Email not found.");
			        }

			    } else {
			        System.out.println("Please enter a valid Gmail address.");
			    }

			    System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			    System.out.println("+++++++++++++++++++++++++++++++++++++ Thank You +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			    System.out.println("-------------------------------------------------------------------------------------------------------------------------");

			    break;
			    
			case 4:
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("+++++++++++++++++++++++++++++++++++++ Admin Login +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");

				System.out.println("Enter your username: ");
				name = sc.nextLine();

				if (!name.isEmpty()) {

				    System.out.println("Enter your password: ");
				    password = sc.nextLine();

				    if (!password.isEmpty()) {

				        if (name.equals("admin") && password.equals("admin@123")) {

				            ps = con.prepareStatement("select name , email from student");
				            rs = ps.executeQuery();

				            System.out.println("Student Data:");
				            while (rs.next()) {

				                System.out.println(rs.getString(1) + " " + rs.getString(2));
				            }
				        }

				    } else {
				        System.out.println("Password cannot be empty. Please enter your password.");
				        password = sc.nextLine();
				    }

				} else {

				    System.out.println("Username cannot be empty. Please enter your username.");
				    name = sc.nextLine();
				}

				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("+++++++++++++++++++++++++++++++++++++ Thank You ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");

				break;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				JDBC_Config.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("+++++++++++++++++++++++++++++++++++++ Enter Yess to continue +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		
		choice = sc.next();
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("+++++++++++++++++++++++++++++++++++++ Thank You visit Again +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		
		
	}
}
