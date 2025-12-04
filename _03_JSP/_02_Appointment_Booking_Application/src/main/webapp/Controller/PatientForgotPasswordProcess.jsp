<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@page import="java.sql.*" %> 
<%
String   email , password, cnfPassword;

email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking" , "root" , "gaurav@123");
PreparedStatement ps =  con.prepareStatement("update patient set  password = '"+password+"' , cnfPassword ='"+cnfPassword+"' where email = '"+email+"' ; ");
ps.execute();

out.println("<script>");
out.println("alert('Password Updated Successfully')");
out.println("alert('Please Login to check')");
out.println("window.location.href = '../Pages/PatientWork/PatientLoginForm.jsp '");
out.println("</script>");

%>