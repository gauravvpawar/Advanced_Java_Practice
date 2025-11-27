<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo Page</title>


<style>
    /* Reset some default styles */
    body, ul, li, div, nav, a {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        background-color: #f9f9f9;
        color: #333;
        padding: 20px;
    }

    nav {
        background-color: #4CAF50; /* Green navbar */
        padding: 10px 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }

    nav ul {
        list-style: none;
        display: flex;
        align-items: center;
    }

    nav ul div {
        font-weight: bold;
        font-size: 20px;
        margin-right: 20px;
    }

    nav ul div a {
        color: #fff;
        text-decoration: none;
    }

    nav ul li {
        margin-right: 15px;
    }

    nav ul li a {
        text-decoration: none;
        color: #fff;
        padding: 8px 12px;
        border-radius: 4px;
        transition: background-color 0.3s;
    }

    nav ul li a:hover {
        background-color: #45a049;
    }

    /* Optional: add some spacing below nav */
    h1 {
        text-align: center;
        margin-top: 40px;
    }
</style>
</head>
<body>
<%-- 	<h1>This is the demo page</h1> this is comment tag--%>
	
	<nav>
	<ul>
	<div><a href="./">Student Registration</a></div>
	<li><a href="register.jsp"> Click Registration</a></li>
	<li><a href="login.jsp"> Login</a></li>
	<li><a href="showList.jsp"> Show Registrations</a></li>
	</ul>
	</nav>
</body>
</html>