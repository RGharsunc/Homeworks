<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <link rel="stylesheet" href=    <c:url value="/css/style.css"/>>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div id="mainAdmin">
    <div id="addCategory">

        <form:form action="/admin/add/category" commandName="category" method="post" role="form">
            Input category name: &nbsp; <input type="text" name="name" placeholder="category name"><br><br>
            <input type="submit" value="add category" style="margin-left: 147px">
        </form:form>
    </div>












    <div id="addPost">
        <form:form action="/admin/add/post" commandName="post" enctype="multipart/form-data" method="post" style="margin-left: 100px" role="form">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" placeholder="Enter Title:"/>
            <br><br>


            category name: &nbsp; <select name="categoryId">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}">${category.name}
                </option>
            </c:forEach>
        </select><br><br>


            <label for="description">Title:</label>
            <input type="text" id="description" name="description" placeholder="Enter text:"/><br><br>

            <label for="postPic">Post pic:</label>
            <input type="file" id="postPic" name="image"/><br><br>


            <input type="submit" value="Add post" style="color: red; background-color: #40ff09">

        </form:form>
    </div>

















    <div id="updatePost">
        <form:form action="/admin/post/update" commandName="post" method="post" style="margin-left: 100px" role="form">
            Current Post Title:
            <select name="currentId">
                <c:forEach items="${posts}" var="post">
                    <option value="${post.id}">${post.title}</option>
                </c:forEach></select>
            <%--<input type="text" id="ctitle" name="ctitle" placeholder="Enter Title:"/>--%>
            <br><br>
            <label for="ntitle">New Post Title:</label>
            <input type="text" id="ntitle" name="title" placeholder="Enter Title:"/>
            <br><br>


            New post category name: &nbsp; <select name="categoryId">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}"> ${category.name}
                </option>
            </c:forEach>
        </select><br><br>


            <label for="description">New Post Description:</label>
            <input type="text" id="description" name="description" placeholder="Enter text:"/><br><br>

            <input type="submit" value="update post" style="color: red; background-color: #40ff09">

        </form:form>
    </div>


    <div id="removePost">
        <table>
            <tr>
                <th width="150px">Post title</th>&nbsp;&nbsp;&nbsp;

                <th>Remove Post</th>
            </tr
            <c:forEach items="${posts}" var="post">
                <tr >
                    <td  style="border-bottom: 1px dashed black">${post.title}</td>&nbsp;&nbsp;
                    <td><a href="/admin/post/remove/${post.id}">remove post</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>





