<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Edit Form</title>
</head>

<style>
    body {
        font-family: 'Segoe UI', Arial, sans-serif;
        background: #eef2f7;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .registration-container {
        width: 400px;
        background: #fff;
        padding: 25px 30px;
        border-radius: 12px;
        box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.08);
    }

    h2 {
        text-align: center;
        margin-bottom: 18px;
        font-size: 24px;
        color: #222;
        font-weight: 600;
    }

    label {
        font-size: 14px;
        font-weight: 600;
        margin-bottom: 4px;
        color: #555;
        display: block;
    }

    input, select {
        width: 100%;
        padding: 8px 10px;
        margin-bottom: 12px;
        border: 1px solid #cbd2d9;
        border-radius: 6px;
        font-size: 14px;
        transition: border 0.3s, box-shadow 0.3s;
    }

    input:focus, select:focus {
        border-color: #0069d9;
        box-shadow: 0 0 4px rgba(0, 105, 217, 0.4);
    }

    button {
        width: 100%;
        padding: 10px;
        background: #0069d9;
        border: none;
        color: #fff;
        font-size: 15px;
        border-radius: 6px;
        cursor: pointer;
        transition: background 0.3s;
        margin-top: 5px;
    }

    button:hover {
        background: #0052a3;
    }
</style>

<body>

<%


int id = Integer.parseInt(request.getParameter("id"));
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");

PreparedStatement ps = con.prepareStatement("select * from doctor where did =  '"+id+"'");

ResultSet rs =  ps.executeQuery();

rs.next();

%>



<div class="registration-container">
    <h2>Doctor Update Data</h2>

    <form action="<%= request.getContextPath() %>/Controller/DoctorUpdateProcess.jsp" method="post">

        <label>Full Name:</label>
        <input type="text" name="name" value="<%= rs.getString(2) %>" required>

        <label>Email:</label>
        <input type="email" name="email" value="<%= rs.getString(3) %>"  readOnly required>

        <label>Password:</label>
        <input type="text" name="password" value="<%= rs.getString(4) %>" required>

        <label>Confirm Password:</label>
        <input type="text" name="cnfPassword" value="<%= rs.getString(5) %>" required>

        <label>Phone:</label>
        <input type="text" name="phone" value="<%= rs.getString(6) %>"  required>

        <label>Specialization:</label>
        <select name="specialization" required>
            <option value="Cardiologist">Cardiologist</option>
            <option value="Dentist">Dentist</option>
            <option value="Neurologist">Neurologist</option>
            <option value="General Physician">General Physician</option>
            <option value="Dermatologist">Dermatologist</option>
        </select>

        <label>Qualification:</label>
        <input type="text" name="qualification"  value="<%= rs.getString(8)%>" placeholder="MBBS, MD" required>

        <label>Experience (years):</label>
        <input type="number" name="experience" value="<%= rs.getString(9) %>" min="0">

        <label>Gender:</label>
       <select name="gender" required>
		    <option <%= "Male".equals(rs.getString(10)) ? "selected" : "" %>>Male</option>
		    <option <%= "Female".equals(rs.getString(10)) ? "selected" : "" %>>Female</option>
		    <option <%= "Other".equals(rs.getString(10)) ? "selected" : "" %>>Other</option>
		</select>

        
        
       <label>Status:</label>
        <select name="status" required>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
            <option value="Out Off Town">Out Off Town</option>
        </select>

        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>