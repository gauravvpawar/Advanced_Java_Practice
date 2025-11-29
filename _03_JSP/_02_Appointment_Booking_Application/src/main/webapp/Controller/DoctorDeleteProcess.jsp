<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

int id = Integer.parseInt(request.getParameter("id"));
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");

PreparedStatement ps =  con.prepareStatement("delete from doctor where did = '"+id+"'");
ps.executeUpdate();

out.println("<script>");
out.println("alert('Deleted Your account Successfully')");
out.println("window.location.href = '../'");
out.println("</script>");




%>

</body>
</html>