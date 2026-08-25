package _05_CreateStatement_PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class _01_CreateStatement {
	public static void main(String args[])
	{
		
		Connection con = null;
		
		try
		{
			
			con = JDBC_Config.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id you want to fetch : ");
			int id = sc.nextInt();
			String sql = "select * from person where pid = '" + id+"'";
			
//			String sql = "select * from person where pid = ?";
//			setInt(1 , id); we dont have this in create statement
//			you have to write the proper sql query
			Statement stmt = con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 if(rs.next())
			 {
				 System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			 }
			
		}catch(Exception e)
		{
			System.out.println("Exception : " + e);
		}finally
		{
			JDBC_Config.closeConnection(con);
		}
	}
}
