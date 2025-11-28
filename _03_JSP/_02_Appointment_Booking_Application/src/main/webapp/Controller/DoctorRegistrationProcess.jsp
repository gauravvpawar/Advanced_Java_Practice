<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>


<%

String name , email , password , cnfPassword , qualification , experience , gender;

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appoinment_booking", "root","gaurav@123");
con.prepareStatement("insert into doctor(name ,email , password , cnfPassword , phone  , specialization , qualification , experience_yrs , gender ) values()"); 
		
%>
