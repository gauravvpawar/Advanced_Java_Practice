<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display data</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<table class="table">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Confirm Password</th>
<th>Action</th>
</tr>
<tbody>
<c:forEach items="${temp}" var="e" >
<tr>
<td>${e.sid}</td>
<td>${e.sname}</td>
<td>${e.semail}</td>
<td>${e.spassword}</td>
<td>${e.scnfPassword}</td>
<td> 
<a href="editData/${e.sid}" class="btn btn-primary">Edit</a> || 
<a href="deleteData/${e.sid}" class="btn btn-danger">Delete</a>
</td>
</tr>

</c:forEach>
</tbody>

</table>

</body>
</html>