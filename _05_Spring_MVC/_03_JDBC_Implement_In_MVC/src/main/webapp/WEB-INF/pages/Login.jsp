<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Login Page</title>



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
    <h1>Staff Login Form</h1>

    <form action="loginData" method="post">

        <input type="text" name="semail" placeholder="Enter your email" required>

        <input type="text" name="spassword" placeholder="Enter your password" required>

        <button type="submit" class="btn">Register</button>
    </form>
</div>



</body>
</html>