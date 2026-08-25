package _04_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class _01_Store_User {
	public static void main(String args[])
	{
		try
		{
			//1 step to load the class after adding the jar
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// 2 establish the connection 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","gaurav@123");
			
		    Statement statement =  con.createStatement(); // inside create statement we can pass the sql statement in executeupdate or execute query
			
//		    String sql = "insert into person(pid , name , email , age) values(1 , 'gaurav','gaurav@gmail.com',22)";
//		    String sql = "insert into person(pid , name , email , age) values(2 , 'umesh','umesh@gmail.com',24)";

		    String sql = "insert into person(pid , name , email , age) values(3 , 'nitin','nitin@gmail.com',25)";
		    int res = statement.executeUpdate(sql);// it always return response in integer
		    
		    if(res > 0)
		    {
		    	System.out.println("record added successfully");
		    }else {
		    	System.out.println("failure occur");
		    }
		    
			
		}catch(Exception e)
		{
//			System.out.println("exception occur");
			e.printStackTrace();
		}
		
		
	}
}
