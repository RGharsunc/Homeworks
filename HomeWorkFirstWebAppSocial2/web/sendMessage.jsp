<%@ page import="model.User" %>
<%@ page import="manager.UserManager" %><%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 29.06.2017
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>write yor message</title>
</head>
<body>


<h4>welcome &nbsp;
    <%User currentUser = (User) session.getAttribute("user");%>
    <%UserManager userManager = new UserManager();%>
    <%=currentUser.getName() %>
</h4>
<form method="post" action="/sendMessageServlet">
    <input type="hidden" name="ToFriendId" value="<%=request.getParameter("ToFriendId")%>">
    to: <br><span><%=request.getParameter("name")%>&nbsp;&nbsp;<%=request.getParameter("surname")%></span><br><br>
    <textarea name="message"></textarea><br>
    <input type="submit" value="send message">

</form>
<a href="/homeServlet" >home</a>

<br>
<a href="/logOutServlet">logout</a><br><br>


</body>
</html>
