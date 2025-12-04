
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<%

String email , password;
email = request.getParameter("email");
password = request.getParameter("password");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123");

PreparedStatement ps =  con.prepareStatement("select * from patient where email = '"+email+"' and password = '"+password+"'");
ResultSet rs =  ps.executeQuery();

if(rs.next())
{
	
	HttpSession hs  = request.getSession();
	hs.setAttribute("email", email);
	
	int id = rs.getInt(1);
	
	out.println("<script>");
	out.println("alert('User Login Successfull')");
	out.println("window.location.href= '../Pages/PatientWork/PatientDashBoard.jsp?id="+id+ "';");
	out.println("</script>");
}else{
	out.println("<script>");
	out.println("alert('User Login Fail , Try Again')");
	out.println("window.location.href='../index.html' ");
	out.println("</script>");
}



%>