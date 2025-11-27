<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
/* Center the form on the page */
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: #f0f2f5;
    font-family: Arial, sans-serif;
}

.login-form {
    background: #ffffff;
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    width: 350px;
}

.login-form h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #333;
}

.login-form label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    color: #555;
}

.login-form input {
    width: 100%;
    padding: 10px 12px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 6px;
    transition: all 0.3s ease;
}

.login-form input:focus {
    border-color: #007BFF;
    box-shadow: 0 0 5px rgba(0,123,255,0.5);
    outline: none;
}

.login-form button {
    width: 100%;
    padding: 12px;
    background: #007BFF;
    color: white;
    font-size: 16px;
    font-weight: bold;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    transition: background 0.3s ease;
}

.login-form button:hover {
    background: #0056b3;
}
</style>


</head>
<body>



<form action="loginProcess.jsp" method="post">
 	 <label>Enter your email:</label>
        <input type="text" name="email" placeholder="Enter email">

     <label>Enter your password:</label>
        <input type="text" name="password" placeholder="Enter password">
		<button type="Submit">Login</button>
</form>


</body>
</html>