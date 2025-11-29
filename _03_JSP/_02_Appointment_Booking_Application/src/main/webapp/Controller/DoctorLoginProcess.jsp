<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
    
<%
 
String email , password;

email = request.getParameter("email");
password = request.getParameter("password");



Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");

PreparedStatement ps = con.prepareStatement("select * from doctor where email = '"+email+"' and password = '"+password+"'");
ResultSet rs =  ps.executeQuery();

if(rs.next())
{
	int id = rs.getInt(1);
	HttpSession s1 = request.getSession();
	
	s1.setAttribute("email",email);
	
	
	out.println("<script>");
	out.println("alert('login successfull')");
	
	//response.sendRedirect("../Pages/DoctorWork/DoctorDashBoard.jsp/?id="+id);

	out.println("window.location.href = '../Pages/DoctorWork/DoctorDashBoard.jsp?id=" + id+  "';");
	
	out.println("</script>");
}else{


	out.println("<script>");
	out.println("alert('login failure')");
	
	//response.sendRedirect("../Pages/DoctorWork/DoctorDashBoard.jsp/?id="+id);

	out.println("window.location.href = '../'");
	
	out.println("</script>");
	
}

%>