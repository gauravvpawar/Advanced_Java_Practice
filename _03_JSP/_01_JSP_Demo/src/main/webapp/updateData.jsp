<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

String email = request.getParameter("email");

String name  , password , cnfPassword;
name = request.getParameter("name");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing" , "root" , "gaurav@123");
PreparedStatement ps = con.prepareStatement("update student set sname= '"+name+"',spassword = '"+password+"', scnfPassword = '"+cnfPassword+"' where semail = '"+email+"'");

ps.executeUpdate();

out.println("<script>");
out.println("alert('data update Successfully')");
out.println("window.location.href = 'showList.jsp'");
out.println("</script>");
%>






</body>
</html>