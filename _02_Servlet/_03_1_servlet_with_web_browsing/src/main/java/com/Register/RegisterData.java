package com.Register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Servlet implementation class RegisterData
 */
@WebServlet("/RegisterData")
public class RegisterData extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		System.out.println("I know your name : " + name);
		System.out.println("and you are from " + city);
	}

}
