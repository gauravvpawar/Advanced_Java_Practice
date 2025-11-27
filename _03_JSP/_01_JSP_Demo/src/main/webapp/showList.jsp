<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show the list</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<h1>Registrations</h1>

<table class="table">
<thead>
<tr>
<th>Student id</th>
<th>name</th>
<th>email</th>
<th>Student password</th>
<th>Student confirm password</th>
</tr>
</thead>
<tbody>

<%

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing" , "root" , "gaurav@123");

PreparedStatement ps = con.prepareStatement("Select * from student");
ResultSet rs =  ps.executeQuery();
while(rs.next())
{
%>	
	
	

<tr>
 <td><%= rs.getInt(1) %> </td>
 <td><%= rs.getString(2) %> </td>
  <td><%= rs.getString(3) %> </td>
  <td><%= rs.getString(4) %> </td>
   <td><%= rs.getString(5) %> </td>
   
   <td><button><a href="editForm.jsp?id=<%= rs.getInt(1) %>">edit</a></button>
	<button><a href="deleteData.jsp?x=<%= rs.getInt(1) %>">Delete</a></button></td>  	 
<tr>
	
<%	
}
%>




</tbody>

</table>




</body>
</html>