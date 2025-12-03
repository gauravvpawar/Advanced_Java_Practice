<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // Sample staff data (in real application, this would come from session/database)
    String staffName = "John Smith";
    String staffEmail = "john.smith@company.com";
    String staffId = "EMP00123";
    String department = "Human Resources";
    String position = "Senior HR Manager";
    String joinDate = "2022-03-15";
    String phone = "+1 (555) 123-4567";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Staff Dashboard</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        background: #f5f7fa;
        color: #333;
        line-height: 1.6;
    }

    .dashboard-container {
        display: flex;
        min-height: 100vh;
    }

    /* Sidebar Styles */
    .sidebar {
        width: 250px;
        background: linear-gradient(180deg, #2c3e50, #1a252f);
        color: white;
        padding: 25px 0;
        position: fixed;
        height: 100vh;
        box-shadow: 3px 0 15px rgba(0,0,0,0.1);
    }

    .logo {
        text-align: center;
        margin-bottom: 30px;
        padding: 0 20px;
    }

    .logo h2 {
        color: #4a90e2;
        font-size: 24px;
    }

    .logo p {
        color: #bdc3c7;
        font-size: 12px;
        margin-top: 5px;
    }

    .nav-menu {
        list-style: none;
    }

    .nav-menu li {
        margin-bottom: 5px;
    }

    .nav-menu a {
        display: flex;
        align-items: center;
        padding: 15px 25px;
        color: #ecf0f1;
        text-decoration: none;
        transition: all 0.3s ease;
        font-size: 16px;
    }

    .nav-menu a:hover,
    .nav-menu a.active {
        background: rgba(255,255,255,0.1);
        border-left: 4px solid #4a90e2;
        padding-left: 21px;
    }

    .nav-menu i {
        margin-right: 15px;
        font-size: 18px;
    }

    /* Main Content Styles */
    .main-content {
        flex: 1;
        margin-left: 250px;
        padding: 20px;
    }

    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background: white;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        margin-bottom: 30px;
    }

    .welcome h1 {
        color: #2c3e50;
        font-size: 28px;
    }

    .welcome p {
        color: #7f8c8d;
        margin-top: 5px;
    }

    .user-info {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    .user-avatar {
        width: 50px;
        height: 50px;
        background: linear-gradient(135deg, #4a90e2, #357ABD);
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 22px;
        color: white;
        font-weight: bold;
    }

    .user-details h4 {
        font-size: 16px;
        color: #2c3e50;
    }

    .user-details p {
        font-size: 14px;
        color: #7f8c8d;
    }

    /* Dashboard Cards */
    .dashboard-cards {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
        gap: 25px;
        margin-bottom: 30px;
    }

    .card {
        background: white;
        border-radius: 12px;
        padding: 25px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.08);
        transition: transform 0.3s ease;
    }

    .card:hover {
        transform: translateY(-5px);
    }

    .card h3 {
        color: #2c3e50;
        margin-bottom: 20px;
        padding-bottom: 15px;
        border-bottom: 2px solid #f0f0f0;
        font-size: 20px;
    }

    .card i {
        color: #4a90e2;
        margin-right: 10px;
    }

    /* Profile Info Styles */
    .profile-info {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
        gap: 20px;
        margin-top: 20px;
    }

    .info-item {
        display: flex;
        flex-direction: column;
        margin-bottom: 15px;
    }

    .info-label {
        font-size: 14px;
        color: #7f8c8d;
        margin-bottom: 5px;
    }

    .info-value {
        font-size: 16px;
        color: #2c3e50;
        font-weight: 500;
        padding: 8px 0;
        border-bottom: 1px solid #eee;
    }

    /* Quick Stats */
    .stats {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
        gap: 20px;
        margin-top: 20px;
    }

    .stat-item {
        text-align: center;
        padding: 20px;
        background: linear-gradient(135deg, #4a90e2, #357ABD);
        color: white;
        border-radius: 10px;
    }

    .stat-number {
        font-size: 32px;
        font-weight: bold;
        margin-bottom: 10px;
    }

    .stat-label {
        font-size: 14px;
        opacity: 0.9;
    }

    /* Recent Activity */
    .activity-list {
        margin-top: 20px;
    }

    .activity-item {
        display: flex;
        align-items: center;
        padding: 15px;
        border-bottom: 1px solid #eee;
        transition: background 0.3s;
    }

    .activity-item:hover {
        background: #f9f9f9;
    }

    .activity-icon {
        width: 40px;
        height: 40px;
        background: #e3f2fd;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        margin-right: 15px;
        color: #4a90e2;
    }

    .activity-details {
        flex: 1;
    }

    .activity-title {
        font-weight: 500;
        color: #2c3e50;
    }

    .activity-time {
        font-size: 12px;
        color: #7f8c8d;
        margin-top: 5px;
    }

    /* Action Buttons */
    .action-buttons {
        display: flex;
        gap: 15px;
        margin-top: 25px;
        flex-wrap: wrap;
    }

    .btn {
        padding: 12px 25px;
        border-radius: 6px;
        border: none;
        cursor: pointer;
        font-weight: 500;
        transition: all 0.3s ease;
        display: inline-flex;
        align-items: center;
        gap: 8px;
    }

    .btn-primary {
        background: #4a90e2;
        color: white;
    }

    .btn-primary:hover {
        background: #357ABD;
        transform: translateY(-2px);
    }

    .btn-secondary {
        background: #f8f9fa;
        color: #495057;
        border: 1px solid #dee2e6;
    }

    .btn-secondary:hover {
        background: #e9ecef;
    }

    /* Responsive Design */
    @media (max-width: 992px) {
        .sidebar {
            width: 220px;
        }
        .main-content {
            margin-left: 220px;
        }
    }

    @media (max-width: 768px) {
        .sidebar {
            width: 100%;
            height: auto;
            position: relative;
            margin-bottom: 20px;
        }
        .main-content {
            margin-left: 0;
        }
        .dashboard-container {
            flex-direction: column;
        }
        .header {
            flex-direction: column;
            gap: 20px;
            text-align: center;
        }
    }
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>

<div class="dashboard-container">
    
    <!-- Sidebar -->
    <div class="sidebar">
        <div class="logo">
            <h2><i class="fas fa-briefcase"></i> STAFF PORTAL</h2>
            <p>Employee Dashboard</p>
        </div>
        
        <ul class="nav-menu">
            <li><a href="#" class="active"><i class="fas fa-home"></i> Dashboard</a></li>
            <li><a href="#"><i class="fas fa-user"></i> My Profile</a></li>
            <li><a href="#"><i class="fas fa-calendar-alt"></i> Schedule</a></li>
            <li><a href="#"><i class="fas fa-tasks"></i> Tasks</a></li>
            <li><a href="#"><i class="fas fa-file-alt"></i> Documents</a></li>
            <li><a href="#"><i class="fas fa-chart-bar"></i> Reports</a></li>
            <li><a href="#"><i class="fas fa-cog"></i> Settings</a></li>
            <li><a href="logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        
        <!-- Header -->
        <div class="header">
            <div class="welcome">
                <h1>Welcome back, <%= staffName %>!</h1>
                <p>Here's your dashboard with all important information</p>
            </div>
            
            <div class="user-info">
                <div class="user-avatar">
                    <%= staffName.charAt(0) %>
                </div>
                <div class="user-details">
                    <h4><%= staffName %></h4>
                    <p><%= department %></p>
                </div>
            </div>
        </div>

        <!-- Dashboard Cards -->
        <div class="dashboard-cards">
            
            <!-- Personal Information Card -->
            <div class="card">
                <h3><i class="fas fa-id-card"></i> Personal Information</h3>
                <div class="profile-info">
                    <div class="info-item">
                        <span class="info-label">Full Name</span>
                        <span class="info-value"><%= staffName %></span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Employee ID</span>
                        <span class="info-value"><%= staffId %></span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Email Address</span>
                        <span class="info-value"><%= staffEmail %></span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Phone Number</span>
                        <span class="info-value"><%= phone %></span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Department</span>
                        <span class="info-value"><%= department %></span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Position</span>
                        <span class="info-value"><%= position %></span>
                    </div>
                </div>
                
                <div class="action-buttons">
                    <button class="btn btn-primary">
                        <i class="fas fa-edit"></i> Edit Profile
                    </button>
                    <button class="btn btn-secondary">
                        <i class="fas fa-download"></i> Export Data
                    </button>
                </div>
            </div>

            <!-- Employment Details Card -->
            <div class="card">
                <h3><i class="fas fa-briefcase"></i> Employment Details</h3>
                <div class="profile-info">
                    <div class="info-item">
                        <span class="info-label">Date of Joining</span>
                        <span class="info-value"><%= joinDate %></span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Employment Type</span>
                        <span class="info-value">Full-time</span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Reporting Manager</span>
                        <span class="info-value">Sarah Johnson</span>
                    </div>
                    <div class="info-item">
                        <span class="info-label">Work Location</span>
                        <span class="info-value">New York Office</span>
                    </div>
                </div>
                
                <div class="stats">
                    <div class="stat-item">
                        <div class="stat-number">2.5</div>
                        <div class="stat-label">Years with Company</div>
                    </div>
                    <div class="stat-item">
                        <div class="stat-number">15</div>
                        <div class="stat-label">Days Leave Left</div>
                    </div>
                </div>
            </div>



    </div>
</div>

</body>
</html>