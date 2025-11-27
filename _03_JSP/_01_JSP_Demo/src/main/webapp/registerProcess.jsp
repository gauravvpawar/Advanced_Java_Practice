<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>
    
 <%
String name , email , password , cnfPassword;

name = request.getParameter("name");
email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing" , "root" , "gaurav@123");
PreparedStatement ps =  con.prepareStatement("insert into student(sname , semail , spassword , scnfPassword)" +
		"values('"+name+"' , '"+email+"' , '"+password+"' ,'"+cnfPassword+"')");

ps.executeUpdate();

//<%--out.println("Registration Successfull"); 

out.println("<script>");
out.println("alert('Registration Successfull,  Login For Verify')");
out.println("window.location.href = './'");
out.println("</script>");

%>