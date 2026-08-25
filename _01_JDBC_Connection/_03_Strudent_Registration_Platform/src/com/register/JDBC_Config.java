package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Config 
{
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useSSL=false", "root", "gaurav@123");
	}
	
	public static void closeConnection(Connection con) throws SQLException
	{
		con.close();
	}
}
