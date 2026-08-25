package _05_CreateStatement_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Config {
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "gaurav@123");
	}
	
	public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}