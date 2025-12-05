<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

HttpSession hs = request.getSession();
hs.invalidate();

out.println("<script>");
out.println("alert('Admin Logout successfully ')");
out.println("window.location.href = '../../index.jsp' ");
out.println("</script>");
%>
