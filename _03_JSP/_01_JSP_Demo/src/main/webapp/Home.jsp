<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

HttpSession s1 =  request.getSession();
String email = (String)s1.getAttribute("x");

if(email == null)
{
	//response.sendRedirect("./");
	out.println("<Script>");
	out.println("alert('Login must !')");
	out.println("window.location.href = 'index.jsp'");
	out.println("</Script>");
}

%>
<h1>This is home page of Web</h1>

<a href="showList.jsp">Click here to show all registration</a>

<a href="logoutData.jsp">Logout</a>

</body>
</html>