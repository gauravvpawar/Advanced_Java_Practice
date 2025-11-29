<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


    <!-- Patient Registration Modal -->
    <div class="modal" id="patientRegisterModal">
        <div class="modal-content">
            <span class="close-modal">&times;</span>
            <h2 class="modal-title">Patient Registration</h2>
            <form id="patientRegisterForm">
                <div class="form-group">
                    <label for="patientFullName">Full Name</label>
                    <input type="text" id="patientFullName" class="form-control" placeholder="Enter your full name" required>
                </div>
                <div class="form-group">
                    <label for="patientRegEmail">Email</label>
                    <input type="email" id="patientRegEmail" class="form-control" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="patientRegPassword">Password</label>
                    <input type="password" id="patientRegPassword" class="form-control" placeholder="Create a password" required>
                </div>
                <div class="form-group">
                    <label for="patientPhone">Phone Number</label>
                    <input type="tel" id="patientPhone" class="form-control" placeholder="Enter your phone number" required>
                </div>
                <button type="submit" class="btn btn-primary" style="width: 100%;">Register</button>
            </form>
            <p style="text-align: center; margin-top: 15px;">
                Already have an account? <a href="./Pages/PatientWork/PatientLogin.jsp" id="showPatientLogin">Login here</a>
            </p>
        </div>
    </div>

</body>
</html>