package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Config {
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/testing?useSSL=false","root","gaurav@123");
	}
	
	public static void closeConnection(Connection con , PreparedStatement psmnt) throws SQLException
	{
		con.close();
		psmnt.close();
	}
}
