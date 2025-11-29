<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%

String email , password, cnfPassword;
email = request.getParameter("email");
password = request.getParameter("password");
cnfPassword = request.getParameter("cnfPassword");
 
Class.forName("com.mysql.cj.jdbc.Driver");

try
{
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");

PreparedStatement ps = con.prepareStatement("select * from doctor where email = '"+email+"' ");

ResultSet rs =  ps.executeQuery();
if(rs.next())
{
	ps =  con.prepareStatement("update doctor set password = '"+password+"' , cnfPassword = '"+cnfPassword+"' where email = '"+email+"' ");
	ps.executeUpdate();

	out.println("<script>");
	out.println("alert('Password updated Successfully ✔️!, Please login');");
	out.println("window.location.href = '../'");
	out.println("</script>");
}else{
	throw new Exception("email not found");
}



}catch(Exception e)
{
	
	out.println("<script>");
	out.println("alert('Email does not Exist , Register first! ');");
	out.println("window.location.href = '../'");
	out.println("</script>");
	
}


 %>       
        

</body>
</html>