<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=
    <c:url value="/css/style.css"/>>
    <link rel="stylesheetBoots" href=
    <c:url value="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"/>>


</head>
<body>


    <div id="form">
        <form:form method="post" commandName="admin" action="/admin/logIn" class="box logIn">
            <fieldset class="boxBody">
                <form:label path="username">Username</form:label>
                <form:input path="username"/>

                <form:label path="password">Password</form:label>
                <form:password path="password"/>

            </fieldset>
            <footer>
                <label><input type="checkbox" tabindex="3">Keep Me logged in</label>
                <input type="submit" class="btnLogin" value="login" tabindex="4">
            </footer>
        </form:form>
    </div>
</div>
</body>
</html>
