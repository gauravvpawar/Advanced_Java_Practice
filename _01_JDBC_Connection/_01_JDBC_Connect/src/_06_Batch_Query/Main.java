package _06_Batch_Query;

import java.sql.Connection;
import java.sql.PreparedStatement;

import _05_CreateStatement_PreparedStatement.JDBC_Config;

public class Main {
	public static void main(String args[])
	{
		Connection con = null;
		try
		{
			con = JDBC_Config.getConnection();
			PreparedStatement pstmt =  con.prepareStatement("insert into person values(? , ? ,? ,?)");
			
			pstmt.setInt(1, 11);
			pstmt.setString(2, "kaif");
			pstmt.setString(3, "kaif@gmail.com");
			pstmt.setInt(4, 25);
			pstmt.addBatch();

			pstmt.setInt(1, 22);
			pstmt.setString(2, "Rahul");
			pstmt.setString(3, "rahul@gmail.com");
			pstmt.setInt(4, 26);
			pstmt.addBatch();

			pstmt.setInt(1, 33);
			pstmt.setString(2, "Amit");
			pstmt.setString(3, "amit@gmail.com");
			pstmt.setInt(4, 24);
			pstmt.addBatch();
			
			int[] response = pstmt.executeBatch(); // execute batch
			// it used for insert update and delete
			// not for the retrieving of data
			
			for(int check : response)
			{
				if(check > 0)
				{
					System.out.println("record added successfully");
				}else {
					System.out.println("Failed to add record");
				}
			}
			
			pstmt = con.prepareStatement("select * from person where id = 11");
			
			
			
		}catch(Exception e)
		{
			System.out.println("Data it can be alredy exist");
			e.printStackTrace();
		}finally
		{
			JDBC_Config.closeConnection(con);
		}
	}
}	
