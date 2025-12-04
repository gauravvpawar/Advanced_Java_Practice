<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
    
    
<%
String name , email , password , cnfPassword , phone , gender ;
int age;
name = request.getParameter("name");
email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");
phone = request.getParameter("phone");
gender = request.getParameter("gender");
age = Integer.parseInt(request.getParameter("age"));

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root" , "gaurav@123");
PreparedStatement ps =  con.prepareStatement("insert into patient(name , email , password , cnfPassword , phone , gender , age) values ('"+name+"' , '"+email+"' , '"+password+"' , '"+cnfPassword+"' , '"+phone+"' , '"+gender+"' , '"+age+"') ");

ps.execute();

out.println("<script>");
out.println("alert('Registration successfull, please Login')");
out.println("window.location.href = '../Pages/PatientWork/PatientLoginForm.jsp' ");
out.println("</script>");

%>