<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	 <%@ page import="java.sql.*" %>
    
    <%
String email , password;
email = request.getParameter("email");
password = request.getParameter("password");
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing" , "root" , "gaurav@123");


PreparedStatement ps = con.prepareStatement("Select * from student where semail = '"+email+"' and spassword='"+password+"'");
ResultSet rs = ps.executeQuery();

if(rs.next())
{
	out.println("<script>");
	out.println("alert('User login successfull')");
	out.println("window.location.href='Home.jsp'");
	out.println("</script>");
}else{
	out.println("<script>");
	out.println("alert('Login Failed')");
	out.println("window.location.href = './'");
	out.println("</script>");	
}

%>