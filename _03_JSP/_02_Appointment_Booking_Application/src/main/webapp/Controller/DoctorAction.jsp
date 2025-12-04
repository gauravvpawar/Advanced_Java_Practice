<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
<%
int id = Integer.parseInt(request.getParameter("id"));

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking","root","gaurav@123");
PreparedStatement ps = con.prepareStatement("update appointment set status = 'accept' where appt_id = '"+id+"' ");

ps.execute();


ps = con.prepareStatement("select * from appointment where appt_id = '"+id+"' ");
ResultSet rs = ps.executeQuery();

if(!rs.next())
{

out.println("<script>");
out.println("alert('Problem occur')");
out.println("</script>");

}

id = rs.getInt(3);


out.println("<script>");
out.println("alert('accepted the Appointment')");
out.println("window.location.href = '../Pages/DoctorWork/DoctorDashBoard.jsp?id="+ id +" ' ;");
out.println("</script>");

%>