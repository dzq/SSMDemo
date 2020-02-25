<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h2>Hello Spring!</h2>
            <h3><a href="${pageContext.request.contextPath}/swagger-ui.html">swagger-ui.html</a></h3>
            <h3><a href="${pageContext.request.contextPath}/doc.html">API文档.html</a></h3>
            <h3><a href="${pageContext.request.contextPath}/book/allBook">书籍目录</a></h3>
            <h3><a href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a></h3>
            <h3><a href="${pageContext.request.contextPath}/book/list">BookList API</a></h3>
        </div>
    </div>
</div>

</body>
</html>
