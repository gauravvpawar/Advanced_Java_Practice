package First;

import javax.servlet.http.*;

public class Test extends HttpServlet
{
	public void doGet(HttpServletRequest req , HttpServletResponse res)
	{
		System.out.println("Here we are");
		System.out.println("Path mapped Successfully");
	}
}
