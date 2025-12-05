<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 /* Doctors Section */
        .doctors {
            padding: 80px 0;
            background-color: #f5f7fa;
            width:100%;
        }
        
        .doctors-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 30px;
        }
        
        .doctor-card {
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
            transition: transform 0.3s;
        }
        
        .doctor-card:hover {
            transform: translateY(-5px);
        }
        
        .doctor-img {
            height: 200px;
            background-color: var(--secondary);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 60px;
        }
        
        .doctor-info {
            padding: 20px;
        }
        
        .doctor-info h3 {
            margin-bottom: 5px;
        }
        
        .doctor-specialty {
            color: var(--primary);
            margin-bottom: 10px;
            font-weight: 500;
        }
</style>
</head>
<body>

 <!-- Doctors Section -->
    
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123");

PreparedStatement ps=  con.prepareStatement("Select * from doctor");
ResultSet rs =  ps.executeQuery();
%>
    
<section class="doctors" id="doctors">
    <div class="container">
        <div class="section-title">
            <h2>Our Specialist Doctors</h2>
            <p>Meet our team of experienced and qualified healthcare professionals.</p>
        </div>
        
        <div class="doctors-grid">

<% while(rs.next()) { %>    

            <div class="doctor-card">
                <div class="doctor-img">
                    <i class="fas fa-user-md"></i>
                </div>
                <div class="doctor-info">
                    <h3>Dr. <%= rs.getString(2) %></h3>
                    <p class="doctor-specialty"><%= rs.getString(7) %></p>
                    <p><%= rs.getString(9) %> years of experience.</p>
                </div>
            </div>

<% } %>

        </div>  <!-- end doctors-grid -->
    </div>
</section>

</body>
</html>
