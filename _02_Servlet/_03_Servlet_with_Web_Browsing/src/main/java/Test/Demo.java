package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.*;

public class Demo extends HttpServlet
{
	public void doPost(HttpServletRequest req , HttpServletResponse res)
	{
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
//		System.out.println(name);
//		System.out.println(email);
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","gaurav@123");
			
			PreparedStatement p1 = con.prepareStatement("select * from person where name = '"+name+"' and email = '"+email+"'");
			ResultSet rs = p1.executeQuery();
			
			if(rs.next())
			{
				System.out.println("User login successfully");
			}else {
				System.out.println("User login failed");
			}
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
		
	}
}
