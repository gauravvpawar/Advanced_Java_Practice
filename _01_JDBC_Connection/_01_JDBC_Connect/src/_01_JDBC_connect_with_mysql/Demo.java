package _01_JDBC_connect_with_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {

	public static void main(String[] args) {
		
		try
		{
//			to load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successfull");
			
			// Connection establish
			Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "gaurav@123");
			PreparedStatement p1 = c1.prepareStatement("insert into student(sid , sname , semail , spassword) values (1 , 'Gaurav' , 'gaurav@gmail.com' , 'gaurav@123')");
			p1.executeUpdate();
			
//			to fetch all data from table
			p1 = c1.prepareStatement("Select * from student");
			ResultSet rs = p1.executeQuery();
			
			rs.next();
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			
			System.out.println("data stored");
		}catch(Exception e)
		{
			System.out.println("Exception occur");
		}
		
	}

}
