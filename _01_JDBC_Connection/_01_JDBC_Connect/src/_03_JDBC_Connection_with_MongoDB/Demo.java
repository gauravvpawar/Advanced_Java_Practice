package _03_JDBC_Connection_with_MongoDB;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Demo {

	public static void main(String[] args) {
		
		try
		{
			   
			   MongoClient mongoClient =
	                    MongoClients.create("mongodb://localhost:27017");

	            MongoDatabase database =
	                    mongoClient.getDatabase("college");

	            System.out.println("Connection Successful");
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}

	}

}
