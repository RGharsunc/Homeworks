<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: studentd
  Date: 6/22/2017
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="/registerServlet">
    name: <input type="text" name="name"/><br><br>
    surname: <input type="text" name="surname"/><br><br>
    age: <input type="number" name="age"/><br><br>
    username: <input type="text" name="username"/><br><br>
    password: <input type="password" name="password"><br>

    <input type="submit" value="register">
</form>

</body>
</html>
