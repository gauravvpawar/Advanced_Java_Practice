package _02_JDBC_connection_with_Postgres;

public class Demo {
	public static void main(String args[])
	{
		try
		{
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Connection established");
			
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
	}
}
