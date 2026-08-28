package com.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;


@WebServlet("/studentRegistration")
public class studentRegistration extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfPassword = request.getParameter("cnfPassword");
		
		
		Student student = new Student();
		student.setSname(name);
		student.setSemail(email);
		student.setSpassword(password);
		student.setScnfPassword(cnfPassword);
		
		PrintWriter out = response.getWriter();
		
		int row  = student.register();
		if(row > 0)
		{
			System.out.println("record saved successfully");
			out.println("<script type='text/javascript'>");
	        out.println("alert('Registration successful!');");
	        out.println("window.location='index.html';");
	        out.println("</script>");
		}else {
			System.out.println("failed to saved record");
			out.println("<script type='text/javascript'>");
	        out.println("alert('Failed to registerationRegistration');");
	        out.println("window.location='index.html';");
	        out.println("</script>");
		}
	}

}
