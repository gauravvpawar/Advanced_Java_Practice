<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration</title>

	<style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f4f7;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .registration-container {
            width: 450px;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
            transition: 0.3s;
        }

        input:focus, select:focus, textarea:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
        }

        button {
            width: 100%;
            padding: 12px;
            background: #007bff;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #0056b3;
        }
    </style>

</head>
<body>

<div class="registration-container">
    <h2>Doctor Registration</h2>

    <form action="DoctorRegistrationProcess.jsp" method="post">
        <label>Full Name:</label>
        <input type="text" name="full_name" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="text" name="password" required>

		<label> confirm Password:</label>
        <input type="text" name="cnfPassword" required>
		

        <label>Phone:</label>
        <input type="text" name="phone" required>

        <label>Specialization:</label>
        <select name="specialization">
            <option>Cardiologist</option>
            <option>Dentist</option>
            <option>Neurologist</option>
            <option>General Physician</option>
            <option>Dermatologist</option>
        </select>

        <label>Qualification:</label>
        <input type="text" name="qualification" placeholder="MBBS, MD" required>

        <label>Experience (years):</label>
        <input type="number" name="experience_years" min="0">

        <label>Gender:</label>
        <select name="gender">
            <option>Male</option>
            <option>Female</option>
            <option>Other</option>
        </select>

        <button type="submit">Register</button>
    </form>
</div>

</body>
</html>