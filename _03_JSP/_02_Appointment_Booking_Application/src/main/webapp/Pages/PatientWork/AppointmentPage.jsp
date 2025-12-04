<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    
<%

int id = Integer.parseInt(request.getParameter("id"));

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123");
PreparedStatement ps =  con.prepareStatement("select * from patient where pid = '"+id+ "'; ");

ResultSet rs1 =  ps.executeQuery();

rs1.next();


%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment Form</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }
        .container {
            width: 450px;
            margin: 50px auto;
            padding: 25px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            height: 80px;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background: #0056b3;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Book Appointment</h2>
    <form action="${pageContext.request.contextPath}/Controller/AppointmentBookProcess.jsp?id=<%= rs1.getInt(1) %>" method="POST">

        <!-- Patient Name -->
        <label>Patient Name</label>
        <input type="text" name="name" value="<%= rs1.getString(2)%>" required>

        <!-- Patient Email -->
        <label>Email</label>
        <input type="email" name="email" value="<%= rs1.getString(3)%>"  required>

        <!-- Phone -->
        <label>Phone</label>
        <input type="text" name="phone"  value="<%= rs1.getString(3)%>" required>

        <!-- Select Doctor (dynamic later) -->
        <label>Select Doctor</label>
        <select name="did" required>
            <option value="">-- Select Doctor --</option>
        
        
        <%

	Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123");
	 PreparedStatement ps2 = con.prepareStatement("Select did ,name , specialization from doctor ;");
       ResultSet rs2 = ps2.executeQuery();
       
       while(rs2.next())
       {
       
        %>
            <!-- Example options (replace with dynamic from database) -->
            <option value="<%= rs2.getInt(1) %>">
 			   Dr. <%= rs2.getString(2) %> ( <%= rs2.getString(3) %> )
            </option>


            
            <%
       }
            %>
        </select>

        <!-- Appointment Date -->
        <label>Appointment Date</label>
        <input type="date" name="appointment_date" required>

        <!-- Appointment Time -->
        <label>Appointment Time</label>
        <input type="time" name="appointment_time" required>

        <!-- Reason -->
        <label>Reason for Appointment</label>
        <textarea name="reason" placeholder="Describe your symptoms or reason for visit..."></textarea>

        <button type="submit">Book Appointment</button>
    </form>
</div>
</body>
</html>