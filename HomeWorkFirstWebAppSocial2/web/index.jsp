<%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 27.06.2017
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form method="post" action="loginServlet">

   username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="LOGIN">&nbsp;
    <a href="/register.jsp"><input type="button" value="REGISTER" >  </a>
  </form>
  </body>
</html>
