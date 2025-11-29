<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


    <!-- Patient Login Modal -->
    <div class="modal" id="patientLoginModal">
        <div class="modal-content">
            <span class="close-modal">&times;</span>
            <h2 class="modal-title">Patient Login</h2>
            <form id="patientLoginForm">
                <div class="form-group">
                    <label for="patientEmail">Email</label>
                    <input type="email" id="patientEmail" class="form-control" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="patientPassword">Password</label>
                    <input type="password" id="patientPassword" class="form-control" placeholder="Enter your password" required>
                </div>
                <button type="submit" class="btn btn-primary" style="width: 100%;">Login</button>
            </form>
            <p style="text-align: center; margin-top: 15px;">
                Don't have an account? <a href="./PatientSignForm.jsp" id="showPatientRegister">Register here</a>
            </p>
        </div>
    </div>


</body>
</html>