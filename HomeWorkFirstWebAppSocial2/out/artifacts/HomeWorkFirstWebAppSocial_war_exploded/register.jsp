<%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 27.06.2017
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registr</title>
</head>
<body>
<%if (request.getSession().getAttribute("message")!=null){%>
<%=request.getSession().getAttribute("message")%>
<%}%>
<form method="post" action="registerServlet">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="email" name="email"><br>
    age: <input type="number" name="age"><br>
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="REGISTER"><br>
    <a href="index.jsp"><input type="button" value="Back to login"></a>
</form>
</body>
</html>
