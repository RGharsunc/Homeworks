<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kareng
  Date: 7/20/2017
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>
<form name='loginForm'
      action="<c:url value='j_spring_security_check' />" method='POST'>
    <h1>Login</h1>
    <input type="text" id="username" name="j_username" placeholder="Username"  />
    <input type="password" id="password" name="j_password" placeholder="Password" />
    <button>Submit</button>
</form></body>
</html>
