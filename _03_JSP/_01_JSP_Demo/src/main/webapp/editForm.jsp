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

int id =Integer.parseInt(request.getParameter("id"));

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing" , "root" , "gaurav@123");
PreparedStatement ps = con.prepareStatement("Select * from student where sid = '"+id+"'");

ResultSet rs = ps.executeQuery();
rs.next();
%>

 <h1>Edit Form</h1>

    <form action="registerProcess.jsp" method="post">
        <label>Enter your name:</label>
        <input type="text" name="name" value="<%= rs.getString(2)%>"  placeholder="Enter name">

        <label>Enter your email:</label>
        <input type="text" name="email" value="<%= rs.getString(3)%>" placeholder="Enter email">

        <label>Enter your password:</label>
        <input type="text" name="password" value="<%= rs.getString(4)%>" placeholder="Enter password">

        <label>Confirm password:</label>
        <input type="text" name="cnfPassword" value="<%= rs.getString(5)%>" placeholder="Confirm password">

        <button type="submit">Register</button>
    </form>

</body>
</html>