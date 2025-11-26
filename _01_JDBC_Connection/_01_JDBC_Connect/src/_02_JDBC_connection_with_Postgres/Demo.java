package _02_JDBC_connection_with_Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo {
	public static void main(String args[])
	{
		PreparedStatement  p1 = null;
		try
		{
			
		Class.forName("org.postgresql.Driver");
		
//		System.out.println("DB connection");
		
		Connection c1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","gaurav@123");
		
		
		p1 = c1.prepareStatement("insert into staff(sname , semail , spassword , scnfpassword) values('Gaurav' , 'gaurav@gmail.com' , 'gaurav@123' , 'gaurav@123')");
		
		p1.executeUpdate();
		
//		take from user
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name : ");
		String name = sc.next();
		
		System.out.println("Enter your email : ");
		String email = sc.next();
		
		System.out.println("Enter your password : ");
		String password = sc.next();
		
		System.out.println("Enter your confirm password : ");
		String cnfPassword = sc.next();
		
		p1 = c1.prepareStatement("insert into staff(sname , semail , spassword, scnfpassword) values('"+name+"', '"+email+ "' , '"+password+"','"+cnfPassword+"' )");
		
		p1.executeUpdate();
		
		
//		to fetch all data
		p1 = c1.prepareStatement("Select * from staff");
		ResultSet rs = p1.executeQuery();
		
//		rs.next();

		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}
		
		System.out.println("Data saved");
		
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
	}
}
