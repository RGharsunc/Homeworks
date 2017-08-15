<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="manager.UserManager" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 27.06.2017
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
Welcome &nbsp
<%User currentUser = (User) session.getAttribute("user");%>
<%UserManager userManager = new UserManager();%>
<%=currentUser.getName() %>
<br>
<a href="/logOutServlet">logout</a><br><br>

<h3><a href="/messageServlet">view all messages</a></h3><br>
<table border="2px solid black">
    <h3> All users list</h3>
    <th>name</th>
    <th>surname</th>
    <th>age</th>
    <th>add to friend list</th>

    <% List<User> users = (List<User>) request.getAttribute("usersList");%>
    <%
        for (User user : users) {
            if (user.getId() != currentUser.getId()) {
    %>
    <tr align="center">
        <td><%=user.getName()%>
        </td>
        <td><%=user.getSurname()%>
        </td>
        <td><%=user.getAge()%>
        </td>

        <td>
            <%
                boolean b = false;
                List<User> usersFriendList = (List<User>) request.getAttribute("usersFriendList");
                for (User friend : usersFriendList) {
                    if (friend.getId() == user.getId()) {
                        b = true;
                        break;
                    }
                }
            %>
            <%if (!b) {%>
            <a href="/addFriendServlet?ToId=<%=user.getId() %> ">add</a>
            <%} else {%>
            added
            <%}%>
        </td>
    </tr>
    <%}%>
    <%}%>

</table>

<table border="2px solid black">
    <h3>Friends list</h3>
    <th>name</th>
    <th>surname</th>
    <th>write message to friend</th>
    <%--<th>delete from friendslist</th>--%>
    <%List<User> usersFriendList = (List<User>) request.getAttribute("usersFriendList");%>
    <%
        for (User friend : usersFriendList) {%>
    <tr>
        <td>
            <%=friend.getName() %>
        </td>
        <td>
            <%=friend.getSurname() %>
        </td>
        <td>
            <a href="/sendMessage.jsp?ToFriendId=<%=friend.getId()%>&name=<%=friend.getName()%>&surname=<%=friend.getSurname()%>">send
                message</a>
        </td>
        <%--<td>--%>
            <%--delete from friends list--%>
        <%--</td>--%>

    </tr>
    <%}%>

</table>

</body>
</html>
