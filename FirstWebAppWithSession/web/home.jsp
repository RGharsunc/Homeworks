<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("/login.jsp");
    } else {

%>


Welcome <%= user.getName() %>   | <a href="/logoutServlet">logout</a>


<%}%>
</body>
</html>
