<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
        }

        .container {
            width: 350px;
            margin: 80px auto;
            background: #ffffff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .gender {
            margin-top: 10px;
        }

        .gender input {
            width: auto;
        }

        button {
            width: 100%;
            background: #4CAF50;
            color: white;
            padding: 10px;
            margin-top: 20px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background: #45a049;
        }
		
		img {
		    width: 60px;
		    height: 60px;
		    object-fit: cover;
		    border-radius: 5px;
		}
		
    </style>
</head>
<body>

<div class="container">
    <h2>Update Data </h2>

    <form action="/updateData" method="post" enctype="multipart/form-data">
		
		<input type="hidden" value="${User.uid}" name="uid" required>
		
        <label>Full Name</label>
        <input type="text" placeholder="Enter your name" value="${User.uname}" name="uname" required>

        <label>Email</label>
        <input type="email"  readOnly placeholder="Enter your email" value="${User.uemail}" name="uemail" required>

        <label>Password</label>
        <input type="text" placeholder="Enter password" value="${User.upassword}" name="upassword" required>

        <label>Confirm Password</label>
        <input type="text" placeholder="Enter Confirm password" value="${User.ucnfPassword}" name="ucnfPassword" required>

		<label>Gender</label>
		<div class="gender">
		    <input type="radio" name="gender" value="male"
		        ${User.gender == 'male' ? 'checked' : ''}> Male
			
			<input type="radio" name="gender" value="famale"
						        ${User.gender == 'famale' ? 'checked' : ''}> Female
		</div>


		<label>Enter your country :  </lebel>
		<select name="country" >
			<option value="India">India</option>
			<option value="USA">USA</option>
			<option value="Japan">Japan</option>
		</select>
		
		<div> 
	        <label>Phone</label>
	        <input type="tel" name="phoneNumber" value="${User.phoneNumber}"  placeholder="Enter phone number">
		</div>
		
		<div>
			<img src="/images/${User.filename}" alt="image loading">
			<label>Upload Image</label>
			<input type="file" name="fname">
		</div>

        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>
