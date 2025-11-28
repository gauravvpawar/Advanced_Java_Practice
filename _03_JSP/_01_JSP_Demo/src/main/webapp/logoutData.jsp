<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Process</title>
</head>
<body>

<%

HttpSession s1 =  request.getSession();
s1.invalidate();
out.println("<script>");
out.println("alert('log out successfully')");
out.println("window.location.href = './'");
out.println("</script>");
%>

</body>
</html>