<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SpringMVC</title>

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>SpringMVC</h1>
    <hr/>

    <h3>Blogs:  <a href="/admin/blogs/add" type="button" class="btn btn-primary btn-sm">ADD</a></h3>

    <c:if test="${empty blogList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Blog list is empty，create <a href="/admin/blogs/add" type="button" class="btn btn-primary btn-sm">Blog</a>
        </div>
    </c:if>

    <c:if test="${!empty blogList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>title</th>
                <th>user</th>
                <th>date</th>
                <th>action</th>
            </tr>

            <c:forEach items="${blogList}" var="blog">
                <tr>
                    <td>${blog.id}</td>
                    <td>${blog.title}</td>
                    <td>${blog.userByUserId.nickname}, ${blog.userByUserId.firstName} ${blog.userByUserId.lastName}</td>
                    <td><fmt:formatDate value="${blog.pubDate }" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <a href="/admin/blogs/show/${blog.id}" type="button" class="btn btn-sm btn-success">show</a>
                        <a href="/admin/blogs/update/${blog.id}" type="button" class="btn btn-sm btn-warning">update</a>
                        <a href="/admin/blogs/delete/${blog.id}" type="button" class="btn btn-sm btn-danger">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>