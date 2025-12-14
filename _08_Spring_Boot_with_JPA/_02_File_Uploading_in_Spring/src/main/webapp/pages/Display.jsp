<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    table {
        width: 95%;
        margin: 0 auto 20px auto;
        border-collapse: collapse;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
        background-color: #fff;
        text-align: center;
    }

    th, td {
        padding: 12px 15px;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #4CAF50;
        color: white;
        text-transform: uppercase;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    td {
        color: #555;
    }

    img {
        width: 60px;
        height: 60px;
        object-fit: cover;
        border-radius: 5px;
    }

    /* Button container for each row */
    .action-btns a {
        display: inline-block;
        margin: 2px;
        padding: 6px 12px;
        background-color: #4CAF50;
        color: white;
        border-radius: 4px;
        text-decoration: none;
        font-size: 14px;
        transition: 0.3s;
    }

    .action-btns a:hover {
        background-color: #45a049;
    }

    /* Optional: Delete button in red */
    .action-btns a.delete {
        background-color: #f44336;
    }

    .action-btns a.delete:hover {
        background-color: #e53935;
    }
</style>
</head>
<body>

<h2>User Details</h2>

<table>
    <tr>
        <th>UID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Confirm Password</th>
        <th>Gender</th>
        <th>Country</th>
        <th>Phone Number</th>
        <th>File Name</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${temp}" var="e">
        <tr>
            <td>${e.uid}</td>
            <td>${e.uname}</td>
            <td>${e.uemail}</td>
            <td>${e.upassword}</td>
            <td>${e.ucnfPassword}</td>
            <td>${e.gender}</td>
            <td>${e.country}</td>
            <td>${e.phoneNumber}</td>
            <td>
                <img src="images/${e.filename}" alt="User Image">
            </td>
            <td class="action-btns">
                <a href="edit/${e.uid}">Edit</a>
                <a href="delete/${e.uid}" class="delete">Delete</a>
            </td>  
        </tr>
    </c:forEach>

</table>

</body>
</html>
