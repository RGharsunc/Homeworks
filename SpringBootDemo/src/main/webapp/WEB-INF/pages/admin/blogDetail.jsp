<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <td>${blog.id}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${blog.title}</td>
        </tr>
        <tr>
            <th>Author</th>
            <td>${blog.userByUserId.nickname}, ${blog.userByUserId.firstName} ${blog.userByUserId.lastName}</td>
        </tr>
        <tr>
            <th>Content</th>
            <td>${blog.content}</td>
        </tr>
        <tr>
            <th>Publish Date</th>
            <td><fmt:formatDate value="${blog.pubDate}" pattern="yyyy-MM-dd"/></td>
        </tr>
    </table>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>