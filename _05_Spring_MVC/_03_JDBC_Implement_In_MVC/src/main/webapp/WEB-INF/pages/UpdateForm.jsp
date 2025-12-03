<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Staff</title>



<style>
    body {
        font-family: Arial, sans-serif;
        background: #f3f4f6;
        padding: 40px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: white;
        width: 400px;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
    }

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
        font-size: 24px;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 12px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 15px;
    }

    input:focus {
        border-color: #4a90e2;
        outline: none;
        box-shadow: 0 0 5px rgba(74,144,226,0.4);
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: #4a90e2;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
        margin-top: 15px;
    }

    .btn:hover {
        background: #357ABD;
    }
</style>
</head>

<body>

<div class="container">
    <h1>Staff Update Data</h1>
<c:forEach items="${temp}" var="e">
    <form action="/_03_JDBC_Implement_In_MVC/updateData" method="post">
		 <input type="hidden" name="sid" value="${e.sid}" placeholder="Enter your name" required>
		 
        <input type="text" name="sname" value="${e.sname}" placeholder="Enter your name" required>

        <input type="text" name="semail" value="${e.semail}" readOnly  placeholder="Enter your email" required>

        <input type="text" name="spassword" value="${e.spassword}"  placeholder="Enter your password" required>

        <input type="text" name="scnfPassword" value="${e.scnfPassword}"  placeholder="Confirm your password" required>

        <button type="submit" class="btn">Update</button>
    </form>
</c:forEach>
</div>


</body>
</html>