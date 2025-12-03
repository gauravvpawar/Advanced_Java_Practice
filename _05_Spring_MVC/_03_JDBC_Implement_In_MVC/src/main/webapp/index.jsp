<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar Example</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 10px 20px;
        }

        .navbar .logo {
            color: #fff;
            font-size: 22px;
            font-weight: bold;
        }

        .navbar ul {
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
        }

        .navbar ul li {
            margin-left: 20px;
        }

        .navbar ul li a {
            color: white;
            text-decoration: none;
            font-size: 18px;
            padding: 8px;
        }

        .navbar ul li a:hover {
            background-color: #575757;
            border-radius: 4px;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <div class="logo">Navbar</div>

        <ul>
            <li><a href="reg">Register</a></li>
            <li><a href="display">Show</a></li>
            <li><a href="login">Login</a></li>
        </ul>
    </div>

</body>
</html>
