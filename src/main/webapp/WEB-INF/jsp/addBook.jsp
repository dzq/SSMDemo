<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <form  action="${pageContext.request.contextPath}/book/addBook" method="post">
                    <fieldset>
                        <label>书籍名称：<input type="text" name="bookName" /></label>
                        <span class="help-block">书籍的名称.</span>
                        <label>书籍数量：<input type="text" name="bookCounts" /></label>
                        <span class="help-block">数据的数量.</span>
                        <label>书籍详情：<input type="text" name="detail" /></label>
                        <span class="help-block">书籍的详细介绍.</span>
                        <button type="submit" class="btn btn-primary">添加</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>

