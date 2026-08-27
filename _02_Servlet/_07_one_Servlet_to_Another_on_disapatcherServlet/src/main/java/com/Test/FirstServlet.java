package com.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("name", name);//  session is used store user data across multiple controller
		
		RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
		
		rd.forward(request, response); // by forward  and includes through we can pass 
		
		PrintWriter writer =  response.getWriter();
		writer.print("<h1>This is first servlet </h1>");
		
		writer.close();
	}

}
