<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>
    
<%


Class.forName("com.mysql.cj.jdbc.Driver");

String name , email , password , cnfPassword , phone , specialization , qualification , gender , status;
int experience = Integer.parseInt(request.getParameter("experience"));

name = request.getParameter("name");
email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");
phone = request.getParameter("phone");
specialization = request.getParameter("specialization");
qualification = request.getParameter("qualification");
gender = request.getParameter("gender");
status = request.getParameter("status");



Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");
PreparedStatement ps =  con.prepareStatement("update doctor set name= '"+name+"' , password = '"+password+"' , cnfPassword = '"+cnfPassword+"' , phone = '"+phone+"' , specialization = '"+specialization+"' , qualification = '"+qualification+"' , experience_yrs = '"+experience+"' , gender ='"+gender+"' , status = '"+status+"' where email = '"+email+"' ");
ps.executeUpdate();

ps = con.prepareStatement("select * from doctor where email = '"+email+"' ");


// remain work for id match to dashboard
ResultSet rs =  ps.executeQuery();
//rs.next();

int id = 0;
if(rs.next())
{
		id = rs.getInt(1);
}


out.println("<script type='text/javascript'>");
out.println("alert('Data updated successfully');");
out.println("window.location.href='../Pages/DoctorWork/DoctorDashBoard.jsp?id=" + id + "';");
out.println("</script>");

%>

<h1>Updation successfull</h1>