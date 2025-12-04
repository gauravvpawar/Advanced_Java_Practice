<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Update Data</title>
</head>
<body>

<%
String name ,email , password , cnfPassword , phone  , gender , dob , address ,bloodGroup , status;
int age;
int id = Integer.parseInt(request.getParameter("id"));

name = request.getParameter("name");
email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");
phone = request.getParameter("phone");
gender = request.getParameter("gender");
age = Integer.parseInt(request.getParameter("age"));
dob = request.getParameter("dob");
address = request.getParameter("address");
bloodGroup = request.getParameter("bloodGroup");
status = request.getParameter("status");


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123");

PreparedStatement ps =  con.prepareStatement("update patient set name = '"+name+"' , password = '"+password+"' , cnfPassword = '"+cnfPassword+"' , phone= '"+phone+"' ,gender= '"+gender+"' , age = '"+age+"' , dob = '"+dob+"' , address = '"+address+"' , blood_group = '"+bloodGroup+"' , status = '"+status+"' where email = '"+email+"' ;");

ps.execute();

out.println("<script>");
out.println("alert('data updated successfully')");
out.println("window.location.href = '../Pages/PatientWork/PatientDashBoard.jsp?id=" + id + " '; ");
out.println("</script>");

%>

</body>
</html>