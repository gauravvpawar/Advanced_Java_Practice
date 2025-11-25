package _03_JDBC_Connection_with_MongoDB;

public class Demo {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("mongodb.jdbc.MongoDriver");
			System.out.println("Connection Successfull");
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}

	}

}
