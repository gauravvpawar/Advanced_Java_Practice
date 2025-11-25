package _01_JDBC_connect_with_mysql;

public class Demo {

	public static void main(String[] args) {
		
		try
		{
//			to load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successfull");
			
		}catch(Exception e)
		{
			System.out.println("Exception occur");
		}
		
		
	}

}
