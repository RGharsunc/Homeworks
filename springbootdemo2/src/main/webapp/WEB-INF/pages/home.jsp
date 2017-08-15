<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <link rel="stylesheet" href=
    <c:url value="/css/style.css"/>>
    <script type="text/javascript" <c:url value="/js/jquery.min.js"/> ></script>
    <link rel="stylesheet" href=
    <c:url value="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"/>>

    <title>Home</title>
</head>
<body>
<div id="main">


    <div id="top_img">
        <img src="<c:url value="/img/hello.jpg"/>" width="900px"/>
    </div>

    <div id="content">
        <div id="posts">
            <c:forEach items="${posts}" var="post">
                <div id="every-post">
                    <img src="/getImage?filename=${post.postPic}"/>
                   <a href="/post/${post.id}"><div><h3><strong>${post.title}</strong></h3></div></a>
                    <p>${post.timeStamp}</p>

                    <%--<p>${post.description}</p>--%>

                </div>
            </c:forEach>


        </div>
        <div id="post-categorys">
            <c:forEach items="${categories}" var="category">
                <a href="/home/categories/show/${category.id}" style="text-decoration-line: none;font-style: italic">
                    <h4>${category.name}
                    </h4></a>
            </c:forEach> <br> <br> <br>

            <div style="width: 90%;border-bottom: 2px dashed black"></div>
            <a href="/admin" style="text-decoration-line: none;
    padding-top: 10px; color: blue"><h4>ADMIN PANEL</h4></a>
        </div>
    </div>
</div>


</body>
</html>
