package _04_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class _04_Delete_Record {
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
		    String sql = "delete from person where pid = 2";// to fetch all record from table
//		    int rs = statement.executeUpdate(sql);
		    
		    boolean rs = statement.execute(sql); // execute it just return true or false
		    if(rs)
		    {
		    	System.out.println("user deleted successfully");
		    }else {
		    	System.out.println("failure to delete user");
		    }
		   
		}catch(Exception e)
		{
//			System.out.println("exception occur");
			e.printStackTrace();
		}
	}
}
