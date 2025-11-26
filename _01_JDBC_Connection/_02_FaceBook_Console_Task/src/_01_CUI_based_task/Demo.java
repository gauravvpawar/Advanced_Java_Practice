package _01_CUI_based_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo 
{
	public static void main(String args[])
	
	{
		
		PreparedStatement p1 = null;
		ResultSet rs = null;
		
//		load the driver
		try
		{
			Class.forName("org.postgresql.Driver");
			
			System.out.println("driver load");
			
			Connection c1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres" ,"gaurav@123");
			
			String ans;
			
			do {
				System.out.println("-------------------------------Facebook console application-----------------------------------------------------");
				System.out.println("Enter you number to perform action");
				Scanner sc = new Scanner(System.in);
				System.out.println("1 -> User Registration \n2 -> User Login \n3 -> forgot Password \n4 -> Exit from application");
				int num = sc.nextInt();
				
				
				switch(num)
				{
				
				// for user registration
				case 1 : 
					System.out.println("----------------------------------User registration----------------------------------------------");
					
					System.out.println("Enter your name : ");
					String name = sc.next();
					System.out.println("Enter your email : ");
					String email = sc.next();
					
					String password , cnfPassword;
					
				 	p1 =  c1.prepareStatement("select * from facebook where uemail = '"+email+"' ");
				 	
				 	 rs = p1.executeQuery();
				 	
				 	if(!rs.next())
				 	{
				 		if(!email.contains("@gmail.com"))
				 		{
				 			System.out.println("Your email is not valid");
				 			break;
				 		}
				 		System.out.println("Enter your password");
				 		password = sc.next();
				 		System.out.println("Enter your confirm password");
				 		cnfPassword = sc.next();
				 		
				 		if(!password.equals(cnfPassword))
				 		{
				 			System.out.println("Please enter password and confirm password must be same");
				 			break;
				 		}
				 		
				 		
				 		p1 = c1.prepareStatement("insert into facebook(uname , uemail , upassword , ucnfpassword) "
				 				+ "values('"+name+"' , '"+email+"' , '"+password+"', '"+cnfPassword+"') ");
				 		
				 		p1.executeUpdate();
				 		
				 		
				 		System.out.println("User registered Successfully");
				 		
				 		System.out.println("-------------------------------------Thank You--------------------------------------------------");
				 		
				 	}
				
					break;
					
				// for user login
				case 2 : 
					System.out.println("-------------------------------------User Login------------------------------------------------------");
					
					System.out.println("Enter your email : ");
					 email = sc.next();
					System.out.println("Enter your password : ");
					password = sc.next();
					
					p1 = c1.prepareStatement("select * from facebook where uemail = '"+email+"' and upassword = '"+password+"'");
					
					rs = p1.executeQuery();
					if(rs.next())
					{
						System.out.println("User login successfull");
					}else {
						System.out.println("User login Failure");
						System.out.println("Try Again");
					}
					
					
					break;
					
					
				case 3:
					System.out.println("---------------------------------------Forget Password action----------------------------------------");
					System.out.println("Enter your email : ");
					email = sc.next();
					
					p1 = c1.prepareStatement("select * from facebook where uemail = '"+email+"'");
					rs = p1.executeQuery();
					
					if(rs.next())
					{
						System.out.println("Enter you new  password : ");
						password = sc.next();
						
						System.out.println("Enter you confirm new password : ");
						cnfPassword = sc.next();
						
						if(password.equals(cnfPassword))
						{
							p1 = c1.prepareStatement("Update facebook set upassword = '"+password+"' , ucnfpassword= '"+cnfPassword+"' where uemail = '"+email+"'");
							p1.executeUpdate();
							
							System.out.println("---------------------------------------------Password Updated Successfully------------------------------");
						}else {
							System.out.println("Your password and confirm password not matched");
						}
					}
					
					
				case 4:
					System.out.println("----------------------------------------Exiting the application --------------------------------------------------------");
					System.out.println("---------------------------------------------Visit Again --------------------------------------------------------------");
					
					ans = "No";
					break;
//					return;
					
				}
				
				
				System.out.println("Enter Yes to perform :");
				ans = sc.next();
			}while(ans.equals("Yes"));
		
			
			
			
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
		
		
		
		
	}

}
