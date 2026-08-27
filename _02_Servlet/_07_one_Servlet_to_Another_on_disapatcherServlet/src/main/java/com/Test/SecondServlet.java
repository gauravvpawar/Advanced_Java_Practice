package com.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		
		writer.print("<h1>Second Servlet page</h1>");
		writer.print("<h1>Welcome to the dashboard '"+name+"'</h1>");
	}

}
