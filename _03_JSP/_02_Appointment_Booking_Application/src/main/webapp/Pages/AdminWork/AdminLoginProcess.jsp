<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
        :root {
            --primary: #2563eb;
            --primary-dark: #1d4ed8;
            --success: #10b981;
            --warning: #f59e0b;
            --danger: #ef4444;
            --card-bg: #ffffff;
            --text-dark: #1e293b;
            --text-light: #64748b;
            --light-bg: #f8fafc;
            --border: #e2e8f0;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', system-ui, sans-serif;
        }

        body {
            background: linear-gradient(135deg, #f8fafc 0%, #f1f5f9 100%);
            min-height: 100vh;
            color: var(--text-dark);
        }

        /* HEADER */
        .admin-header {
            background: white;
            padding: 1rem 2rem;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        .logo-section {
            display: flex;
            align-items: center;
            gap: 1rem;
        }

        .logo {
            width: 50px;
            height: 50px;
            background: linear-gradient(135deg, var(--primary), #4f46e5);
            border-radius: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 1.5rem;
        }

        .logo-text h1 {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--primary);
        }

        .logo-text p {
            font-size: 0.85rem;
            color: var(--text-light);
        }

        .admin-info {
            display: flex;
            align-items: center;
            gap: 1.5rem;
        }

        .admin-profile {
            display: flex;
            align-items: center;
            gap: 0.75rem;
            padding: 0.75rem 1.25rem;
            background: var(--light-bg);
            border-radius: 10px;
            border: 1px solid var(--border);
        }

        .admin-avatar {
            width: 40px;
            height: 40px;
            background: linear-gradient(135deg, var(--primary), var(--primary-dark));
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: 600;
            font-size: 1.1rem;
        }

        .admin-details h4 {
            font-size: 0.95rem;
            font-weight: 600;
            margin-bottom: 0.25rem;
        }

        .admin-details p {
            font-size: 0.8rem;
            color: var(--text-light);
        }

        .logout-btn {
            padding: 0.75rem 1.5rem;
            background: linear-gradient(135deg, var(--danger), #f87171);
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-weight: 600;
            font-size: 0.9rem;
            display: flex;
            align-items: center;
            gap: 0.5rem;
            transition: all 0.3s ease;
        }

        .logout-btn:hover {
            background: linear-gradient(135deg, #dc2626, var(--danger));
            transform: translateY(-2px);
        }

    </style>
</head>
<body>

<%
String username , password;
username = request.getParameter("username");
password = request.getParameter("Password");

System.out.println(username);
System.out.println(password);

if(!username.equals("admin") && !password.equals("admin@123"))
{
	out.println("<script>");
	out.println("alert('Admin login failure! ')");
	out.println("window.location.href = '" + request.getContextPath() + "/index.jsp';");
	out.println("</script>");
}


HttpSession hs = request.getSession();

hs.setAttribute("username", username);

out.println("<script>");
out.println("alert('admin login Successfully')");
out.println("</script>");

%>
<h1>Welcome Back Admin</h1>
  <!-- HEADER -->
    <header class="admin-header">
        <div class="logo-section">
            <div class="logo">
                <i class="fas fa-shield-alt"></i>
            </div>
            <div class="logo-text">
                <h1>Admin Dashboard</h1>
                <p>Healthcare Management System</p>
            </div>
        </div>
        
        <div class="admin-info">
            <div class="admin-profile">
                <div class="admin-avatar">
                    <i class="fas fa-user-cog"></i>
                </div>
                <div class="admin-details">
                    <h4>Administrator</h4>
                    <p>System Admin</p>
                </div>
            </div>
            <a href="./AdminLogOutProcess.jsp" class="logout-btn">
                <i class="fas fa-sign-out-alt"></i>
                Logout
            </a>
        </div>
    </header>

       
	



</body>
</html>