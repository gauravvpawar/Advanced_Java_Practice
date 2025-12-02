<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>User Registration</h1>

<form action="userSaveData" method="post">
<input type="text" name="uname" placeholder="Enter your name :" >
<br>
<input type="text" name="uemail" placeholder="Enter your email : "> 
<br>

<input type="text" name="upassword" placeholder="Enter you password">
<br>

<input type="text" name="ucnfpassword" placeholder="Enter your confirm password">

<button type="Submit">Register</button>
</form>


</body>
</html>