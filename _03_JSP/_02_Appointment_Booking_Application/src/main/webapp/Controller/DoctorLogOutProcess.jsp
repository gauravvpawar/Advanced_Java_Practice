<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

HttpSession hs = request.getSession();
hs.invalidate();

out.println("<script>");
out.println("alert('User logOut Successfully')");
out.println("window.location.href = '../' ");
out.println("</script>");
%>
