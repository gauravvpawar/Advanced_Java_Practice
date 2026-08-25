package _04_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class _03_Update_record {
	public static void main(String args[])
	{
		try
		{
			//1 step to load the class after adding the jar
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// 2 establish the connection 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","gaurav@123");
			
		    Statement statement =  con.createStatement(); // inside create statement we can pass the sql statement in executeupdate or execute query
			
		    // to fetch data from table
		    String sql = "select * from person where pid = 2";// to fetch all record from table
		    ResultSet rs = statement.executeQuery(sql);
		  
		    int pid = 0;
		    while(rs.next())
		    {
		    	  pid = rs.getInt(1);
		    	System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3) + " " + rs.getString(4));
		    }
		    
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Enter the which have to change you : ");
		    System.out.println("Enter name you want to change");
		    String name = sc.next();
			System.out.println("Enter age you want to change : ");
			int age = sc.nextInt();
			
			sql = "update person set name = '"+name+"', age='"+age+"' where pid = '"+pid+"'";
			int result = statement.executeUpdate(sql);
			if(result > 0)
			{
				System.out.println("record updated successfully");
			}else {
				System.out.println("failed to update record");
			}
		}catch(Exception e)
		{
//			System.out.println("exception occur");
			e.printStackTrace();
		}
	}
}
