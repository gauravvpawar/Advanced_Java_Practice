package com.Test;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLife
 */
@WebServlet("/ServletLife")
public class ServletLife extends HttpServlet {
	
	 static {
	        System.out.println("1. Servlet class loaded");
	    }

	    @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	        System.out.println("2. init() called - once");
	    }

	    @Override
	    protected void service(HttpServletRequest request,
	                           HttpServletResponse response)
	            throws ServletException, IOException {

	        System.out.println("3. service() called - for every request");

	        super.service(request, response);
	    }

	    @Override
	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	            throws ServletException, IOException {

	        System.out.println("4. doGet() called");
	    }

	    @Override
	    public void destroy() {
	        System.out.println("5. destroy() called - once");
	    }

}
