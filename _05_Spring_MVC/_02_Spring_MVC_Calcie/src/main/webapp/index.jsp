<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Calculator</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
    }

    nav {
      background-color: #333;
      display: flex;
      align-items: center;
      padding: 10px 20px;
    }

    nav .logo {
      color: white;
      font-size: 24px;
      font-weight: bold;
      margin-right: auto;
    }

    nav ul {
      list-style: none;
      display: flex;
      margin: 0;
      padding: 0;
    }

    nav ul li {
      margin-left: 20px;
    }

    nav ul li a {
      color: white;
      text-decoration: none;
      font-size: 16px;
      padding: 6px 12px;
      transition: background-color 0.3s;
    }

    nav ul li a:hover {
      background-color: #575757;
      border-radius: 4px;
    }
  </style>
</head>
<body>

  <nav>
    <div class="logo">Calculator</div>
    <ul>
      <li><a href="Addition">Addition</a></li>
      <li><a href="Substraction">Subtraction</a></li>
      <li><a href="Multiplication">Multiplication</a></li>
      <li><a href="Division">Division</a></li>
    </ul>
  </nav>

</body>
</html>
