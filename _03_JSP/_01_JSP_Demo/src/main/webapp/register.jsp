<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Form container */
    .container {
        background: #fff;
        padding: 40px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        width: 350px;
        text-align: center; /* Center everything inside */
    }

    /* Heading */
    h1 {
        color: #1877f2;
        margin-bottom: 30px;
        font-size: 28px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #555;
        text-align: left; /* Keep labels aligned left */
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 14px;
        box-sizing: border-box;
        transition: border-color 0.3s;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        border-color: #1877f2;
        outline: none;
    }

    button {
        width: 100%;
        padding: 12px;
        background-color: #1877f2;
        color: #fff;
        font-size: 16px;
        font-weight: bold;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    button:hover {
        background-color: #145db8;
    }

    @media (max-width: 400px) {
        .container {
            width: 90%;
            padding: 30px 20px;
        }
    }
</style>
</head>
<body>

<div class="container">
    <h1>Registration Form</h1>

    <form action="registerProcess.jsp" method="post">
        <label>Enter your name:</label>
        <input type="text" name="name" placeholder="Enter name">

        <label>Enter your email:</label>
        <input type="text" name="email" placeholder="Enter email">

        <label>Enter your password:</label>
        <input type="text" name="password" placeholder="Enter password">

        <label>Confirm password:</label>
        <input type="text" name="cnfPassword" placeholder="Confirm password">

        <button type="submit">Register</button>
    </form>
</div>

</body>
</html>
