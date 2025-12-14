<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }

        .form-container {
            background: #fff;
            padding: 30px;
            width: 350px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            outline: none;
            font-size: 14px;
        }

        input:focus {
            border-color: #667eea;
        }

        button {
            width: 100%;
            margin-top: 20px;
            padding: 12px;
            background: #667eea;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
        }

        button:hover {
            background: #5a67d8;
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h1>Customer Registration Form</h1>

        <form action="saveData" method="post" >
            <label>Enter your name:</label>
            <input type="text" placeholder="Name" name="name" required>

            <label>Enter your email:</label>
            <input type="email" placeholder="Email" name="email" required>

            <label>Enter your password:</label>
            <input type="text" placeholder="Password" name="password" required>

            <label>Confirm your password:</label>
            <input type="text" placeholder="Confirm Password" name="cnfPassword" required>

            <button type="submit">Register</button>
        </form>
    </div>

</body>
</html>
