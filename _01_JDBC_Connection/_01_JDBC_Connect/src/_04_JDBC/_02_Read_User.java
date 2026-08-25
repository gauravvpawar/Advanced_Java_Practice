package _04_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _02_Read_User {
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
		    String sql = "select * from person";// to fetch all record from table
		    ResultSet rs = statement.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3) + " " + rs.getString(4));
		    }
		  
			
		}catch(Exception e)
		{
//			System.out.println("exception occur");
			e.printStackTrace();
		}
	}
}
