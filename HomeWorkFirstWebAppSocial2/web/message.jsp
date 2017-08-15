<%@ page import="manager.UserManager" %>
<%@ page import="model.User" %>
<%@ page import="model.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 29.06.2017
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>welcome &nbsp;
    <%User currentUser = (User) session.getAttribute("user");%>
    <%UserManager userManager = new UserManager();%>
    <%=currentUser.getName() %>
</h4>

<table border="1px solid black">
    <th>from</th>
    <th>message</th>
    <th>created date</th>

        <%
            try {
                List<Message> messages = (List<Message>) request.getAttribute("messagesOfCurrentUser");

                for (Message message : messages) {
                    User sender = userManager.getUserById(message.getFromUserId());
                    String receivedMessage = message.getDescription();
                    String createdTime = message.getTimeStamp();%>

    <tr>
        <td><%=sender.getName()%><br><%=sender.getSurname()%></td>
        <td><%=receivedMessage%></td>
        <td><%=createdTime%></td>
    </tr>
        <%}
            } catch (SQLException e) {
            e.printStackTrace();
            } %>

</table>
<a href="/homeServlet" >home</a>
<br>
<a href="/logOutServlet">logout</a><br><br>

</body>
</html>
