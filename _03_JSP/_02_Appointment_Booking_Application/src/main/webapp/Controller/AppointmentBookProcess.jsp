<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%
    String appointment_date, appointment_time, reason;
    int pid, did;

    pid = Integer.parseInt(request.getParameter("id"));
    did = Integer.parseInt(request.getParameter("did"));
    appointment_date = request.getParameter("appointment_date");
    appointment_time = request.getParameter("appointment_time");
    reason = request.getParameter("reason");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123"
    );

    PreparedStatement ps = con.prepareStatement(
        "insert into appointment(pid, did, appointment_date, appointment_time, reason) values  ('"+pid+"' , '"+did+"' , '"+appointment_date+"' , '"+appointment_time+"' , '"+reason+"') "
    );

    ps.executeUpdate();
%>

<script>
    alert('Appointment Booked Successfully');
    window.location.href = '../Pages/PatientWork/PatientDashBoard.jsp?id=<%= pid %>';
</script>
