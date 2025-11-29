<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <title>Doctor Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        :root {
            --primary: #2c7be5;
            --secondary: #6c757d;
            --success: #00d97e;
            --info: #39afd1;
            --warning: #f6c343;
            --danger: #e63757;
            --light: #f9fafd;
            --dark: #12263f;
            --sidebar: #12263f;
            --card-bg: #ffffff;
        }

        body {
            background-color: #f5f7fa;
            color: var(--dark);
            display: flex;
            min-height: 100vh;
        }

        /* Sidebar Styles */
        .sidebar {
            width: 250px;
            background: var(--sidebar);
            color: white;
            height: 100vh;
            position: fixed;
            transition: all 0.3s;
            z-index: 100;
        }

        .sidebar-header {
            padding: 20px;
            text-align: center;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }

        .sidebar-header h2 {
            font-size: 1.5rem;
            margin-bottom: 5px;
        }

        .sidebar-header p {
            font-size: 0.8rem;
            color: rgba(255, 255, 255, 0.7);
        }

        .sidebar-menu {
            padding: 15px 0;
        }

        .sidebar-menu ul {
            list-style: none;
        }

        .sidebar-menu li {
            padding: 12px 20px;
            transition: all 0.3s;
        }

        .sidebar-menu li:hover {
            background: rgba(255, 255, 255, 0.1);
        }

        .sidebar-menu li.active {
            background: var(--primary);
        }

        .sidebar-menu a {
            color: white;
            text-decoration: none;
            display: flex;
            align-items: center;
        }

        .sidebar-menu i {
            margin-right: 10px;
            font-size: 1.2rem;
        }

        /* Main Content Styles */
        .main-content {
            flex: 1;
            margin-left: 250px;
            padding: 20px;
            transition: all 0.3s;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0 20px;
            border-bottom: 1px solid rgba(0, 0, 0, 0.1);
        }

        .user-info {
            display: flex;
            align-items: center;
        }

        .user-info img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .page-title h1 {
            font-size: 1.8rem;
            color: var(--dark);
        }

        /* Card Styles */
        .card {
            background: var(--card-bg);
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
            margin-bottom: 20px;
            overflow: hidden;
        }

        .card-header {
            padding: 15px 20px;
            border-bottom: 1px solid rgba(0, 0, 0, 0.05);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .card-body {
            padding: 20px;
        }

        /* Dashboard Stats */
        .stats-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }

        .stat-card {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
            display: flex;
            align-items: center;
        }

        .stat-icon {
            width: 60px;
            height: 60px;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-right: 15px;
            font-size: 1.5rem;
        }

        .stat-info h3 {
            font-size: 1.8rem;
            margin-bottom: 5px;
        }

        .stat-info p {
            color: var(--secondary);
            font-size: 0.9rem;
        }

        /* Profile Section */
        .profile-container {
            display: grid;
            grid-template-columns: 1fr 2fr;
            gap: 20px;
        }

        .profile-card {
            text-align: center;
            padding: 20px;
        }

        .profile-img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            margin: 0 auto 15px;
            background: var(--light);
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 3rem;
            color: var(--primary);
        }

        .profile-info h2 {
            margin-bottom: 5px;
        }

        .profile-info p {
            color: var(--secondary);
            margin-bottom: 15px;
        }

        .profile-actions {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 20px;
        }

        .btn {
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: 500;
            transition: all 0.3s;
            display: inline-flex;
            align-items: center;
            justify-content: center;
        }

        .btn i {
            margin-right: 5px;
        }

        .btn-primary {
            background: var(--primary);
            color: white;
        }

        .btn-danger {
            background: var(--danger);
            color: white;
        }

        .btn-primary:hover {
            background: #1a68d1;
        }

        .btn-danger:hover {
            background: #d42a4a;
        }

        /* Table Styles */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid rgba(0, 0, 0, 0.05);
        }

        th {
            background: var(--light);
            font-weight: 600;
        }

        tr:hover {
            background: rgba(0, 0, 0, 0.02);
        }

        .status {
            padding: 5px 10px;
            border-radius: 20px;
            font-size: 0.8rem;
            font-weight: 500;
        }

        .status-active {
            background: rgba(0, 217, 126, 0.1);
            color: var(--success);
        }

        .status-pending {
            background: rgba(246, 195, 67, 0.1);
            color: var(--warning);
        }

        /* Responsive */
        @media (max-width: 992px) {
            .sidebar {
                width: 80px;
                text-align: center;
            }
            
            .sidebar-header h2, .sidebar-header p, .sidebar-menu span {
                display: none;
            }
            
            .sidebar-menu i {
                margin-right: 0;
                font-size: 1.5rem;
            }
            
            .main-content {
                margin-left: 80px;
            }
            
            .profile-container {
                grid-template-columns: 1fr;
            }
        }

        @media (max-width: 768px) {
            .stats-container {
                grid-template-columns: 1fr;
            }
            
            .profile-actions {
                flex-direction: column;
            }
        }
    </style>
</head>
<body>

<%

HttpSession s1 = request.getSession();
String email = (String)s1.getAttribute("email");

if(email == null)
{
	out.println("<script>");
	out.println("alert('You cannot access directly ! Login first')");
	out.println("window.location.href = './'");
	out.println("</script>");
}


int id = Integer.parseInt(request.getParameter("id"));


Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_booking", "root","gaurav@123");

PreparedStatement ps =  con.prepareStatement("select * from doctor where did = '"+id+"'");

ResultSet rs = ps.executeQuery();

if(!rs.next())
{
	System.out.println("Data not found");
}


%>


    <!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-header">
            <h2>MediCare</h2>
            <p>Doctor Portal</p>
        </div>
        <div class="sidebar-menu">
            <ul>
                <li class="active"><a href="#"><i class="fas fa-home"></i> <span>Dashboard</span></a></li>
                <li><a href="#"><i class="fas fa-calendar-alt"></i> <span>Appointments</span></a></li>
                <li><a href="#"><i class="fas fa-user-injured"></i> <span>Patients</span></a></li>
                <li><a href="#"><i class="fas fa-prescription"></i> <span>Prescriptions</span></a></li>
                <li><a href="#"><i class="fas fa-chart-line"></i> <span>Reports</span></a></li>
                <li><a href="#"><i class="fas fa-cog"></i> <span>Settings</span></a></li>
            </ul>
        </div>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <div class="header">
            <div class="page-title">
                <h1>Doctor Dashboard</h1>
            </div>
            <div class="user-info">	
                <img src="https://ui-avatars.com/api/?name=Doctor+User&background=2c7be5&color=fff" alt="User">
                <div>
                    <h4><%= rs.getString(2) %></h4>
                    <p><%= rs.getString(7) %></p>
                </div>
                
                <div>
                <button class="btn btn-outline-danger">
                	<a href='${pageContext.request.contextPath}/Controller/DoctorLogOutProcess.jsp'>Logout</a>
                </button>
                </div>
            </div>
        </div>

        <!-- Stats Cards -->
        <div class="stats-container">
            <div class="stat-card">
                <div class="stat-icon" style="background: rgba(44, 123, 229, 0.1); color: var(--primary);">
                    <i class="fas fa-user-injured"></i>
                </div>
                <div class="stat-info">
                    <h3>42</h3>
                    <p>Total Patients</p>
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-icon" style="background: rgba(0, 217, 126, 0.1); color: var(--success);">
                    <i class="fas fa-calendar-check"></i>
                </div>
                <div class="stat-info">
                    <h3>18</h3>
                    <p>Today's Appointments</p>
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-icon" style="background: rgba(246, 195, 67, 0.1); color: var(--warning);">
                    <i class="fas fa-prescription"></i>
                </div>
                <div class="stat-info">
                    <h3>36</h3>
                    <p>Prescriptions This Month</p>
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-icon" style="background: rgba(57, 175, 209, 0.1); color: var(--info);">
                    <i class="fas fa-chart-line"></i>
                </div>
                <div class="stat-info">
                    <h3>92%</h3>
                    <p>Patient Satisfaction</p>
                </div>
            </div>
        </div>

        <!-- Profile and Patient Info -->
        <div class="profile-container">
            <!-- Profile Card -->
            <div class="card profile-card">
                <div class="profile-img">
                    <i class="fas fa-user-md"></i>
                </div>
                <div class="profile-info">
                    <h2><%= rs.getString(2) %></h2>
                    <p><%= rs.getString(7) %></p>
                    <p><i class="fas fa-envelope"></i> <%= rs.getString(3) %></p>
                    <p><i class="fas fa-phone"></i> <%= rs.getString(6) %></p>
                    <p><i class="fas fa-graduation-cap"></i> <%= rs.getString(7) %>, <%= rs.getInt(9) %> years experience</p>
                    <p><i class="fas fa-venus"></i> <%= rs.getString(10) %></p>
                    <div class="status status-active"><%= rs.getString(11) %></div>
                </div>
                <div class="profile-actions">
                    <button class="btn btn-primary">
                    <i class="fas fa-edit"></i>
                     <a href="./DoctorEditForm.jsp?id=<%= rs.getInt(1)%>">
                     Edit Profile
                     </a> </button>
                    <button class="btn btn-danger"><i class="fas fa-trash-alt">
                    </i> <a href="${pageContext.request.contextPath}/Controller/DoctorDeleteProcess.jsp?id=<%= rs.getInt(1)%>">
                    Delete Profile</a></button>
                </div>
            </div>

            <!-- Patient List -->
            <div class="card">
                <div class="card-header">
                    <h3>Recent Patients</h3>
                    <button class="btn btn-primary"><i class="fas fa-plus"></i> Add Patient</button>
                </div>
                <div class="card-body">
                    <table>
                        <thead>
                            <tr>
                                <th>Patient Name</th>
                                <th>Age</th>
                                <th>Condition</th>
                                <th>Last Visit</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Rajesh Kumar</td>
                                <td>45</td>
                                <td>Hypertension</td>
                                <td>2023-10-15</td>
                                <td><span class="status status-active">Stable</span></td>
                                <td><button class="btn btn-primary" style="padding: 5px 10px; font-size: 0.8rem;">View</button></td>
                            </tr>
                            <tr>
                                <td>Priya Sharma</td>
                                <td>32</td>
                                <td>Diabetes</td>
                                <td>2023-10-12</td>
                                <td><span class="status status-active">Improving</span></td>
                                <td><button class="btn btn-primary" style="padding: 5px 10px; font-size: 0.8rem;">View</button></td>
                            </tr>
                            <tr>
                                <td>Amit Patel</td>
                                <td>58</td>
                                <td>Arthritis</td>
                                <td>2023-10-10</td>
                                <td><span class="status status-pending">Follow-up</span></td>
                                <td><button class="btn btn-primary" style="padding: 5px 10px; font-size: 0.8rem;">View</button></td>
                            </tr>
                            <tr>
                                <td>Sunita Singh</td>
                                <td>29</td>
                                <td>Migraine</td>
                                <td>2023-10-08</td>
                                <td><span class="status status-active">Stable</span></td>
                                <td><button class="btn btn-primary" style="padding: 5px 10px; font-size: 0.8rem;">View</button></td>
                            </tr>
                            <tr>
                                <td>Vikram Joshi</td>
                                <td>65</td>
                                <td>Cardiac Issue</td>
                                <td>2023-10-05</td>
                                <td><span class="status status-pending">Monitoring</span></td>
                                <td><button class="btn btn-primary" style="padding: 5px 10px; font-size: 0.8rem;">View</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Upcoming Appointments -->
        <div class="card">
            <div class="card-header">
                <h3>Upcoming Appointments</h3>
            </div>
            <div class="card-body">
                <table>
                    <thead>
                        <tr>
                            <th>Patient Name</th>
                            <th>Time</th>
                            <th>Purpose</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Rajesh Kumar</td>
                            <td>10:00 AM</td>
                            <td>Follow-up</td>
                            <td><span class="status status-active">Confirmed</span></td>
                        </tr>
                        <tr>
                            <td>Neha Gupta</td>
                            <td>11:30 AM</td>
                            <td>General Checkup</td>
                            <td><span class="status status-active">Confirmed</span></td>
                        </tr>
                        <tr>
                            <td>Sanjay Verma</td>
                            <td>2:15 PM</td>
                            <td>Consultation</td>
                            <td><span class="status status-pending">Pending</span></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>