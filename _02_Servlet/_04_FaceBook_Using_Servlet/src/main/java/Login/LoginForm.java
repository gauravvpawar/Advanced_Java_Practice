package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.*;

public class LoginForm extends HttpServlet
{	
	public void doPost(HttpServletRequest req , HttpServletResponse res )
	{
		System.out.println("You reach Login page");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","gaurav@123");
			
			PreparedStatement p1 = con.prepareStatement("Select * from facebook where uemail = '"+email+"' and upassword ='"+password+"'");
			
			ResultSet rs = p1.executeQuery();
			
			if(rs.next())
			{
				System.out.println("User logged in");
				
//				to show on web page
				
				res.getWriter().println("<html>");
				res.getWriter().println("<body>");
				res.getWriter().println("<h1>User Login Successfully</h1>");
				res.getWriter().println("</body>");
				res.getWriter().println("</html>");
				
			}else {
				System.out.println("User login failed");
			}
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
		
	}
	
}
