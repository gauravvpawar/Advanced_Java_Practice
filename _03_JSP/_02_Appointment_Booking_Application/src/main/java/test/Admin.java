package test;

import java.io.PrintWriter;

import javax.servlet.http.*;

public class Admin extends HttpServlet
{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) 
	{
		
		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Admin Page</title>");
			out.print("</head>");
			out.print("<body>");
			
			out.print("<h2>Admin Login</h2>");
			
			out.print("<form action='" + req.getContextPath() + "/Pages/AdminWork/AdminLoginProcess.jsp' method='post'>");
			out.print("Username: <input type='text' name='username'><br><br>");
			out.print("Password: <input type='text' name='password'><br><br>");
			out.print("<button type='submit'>Login</button>");
			out.print("</form>");
			
			out.print("</body>");
			out.print("</html>");
			
		}catch(Exception e)
		{
			System.out.println("Exception occur");
		}
	}
}
