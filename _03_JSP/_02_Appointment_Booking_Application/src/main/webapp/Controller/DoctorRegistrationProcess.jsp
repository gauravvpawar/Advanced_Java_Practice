<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>


<%

String name , email , password ,phone, cnfPassword ,specialization ,  qualification  , gender;
int experience;
name = request.getParameter("name");
email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");
phone = request.getParameter("phone");
specialization = request.getParameter("specialization"); 
qualification = request.getParameter("qualification");
experience = Integer.parseInt(request.getParameter("experience"));
gender = request.getParameter("gender");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");
PreparedStatement ps =  con.prepareStatement("insert into doctor(name ,email , password , cnfPassword , phone  , specialization , qualification , experience_yrs , gender ) values('"+name+"' ,'"+email+"' , '"+password+"' , '"+cnfPassword+"' , '"+phone+"', '"+specialization+"' ,'"+qualification+"', '"+experience+"' , '"+gender+"' )"); 
		ps.executeUpdate();
		
out.println("<script>");
out.println("alert('registration succefull ✔️')");
out.println("window.location.href = '../Pages/DoctorWork/DoctorLoginForm.jsp'");
out.println("</script>");
%>
