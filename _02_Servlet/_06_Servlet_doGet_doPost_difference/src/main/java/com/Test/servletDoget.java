package com.Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletDoget
 */
@WebServlet(description = "for do get", urlPatterns = { "/servletDoget" })
public class servletDoget extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		http://localhost:5050/_06_Servlet_doGet_doPost_difference/servletDoget?name=nitin&city=jalgaon
		// get action pass the essential data  through the url
		// by default the form action is get
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		System.out.println(name + " " + city);
		
	}

}
