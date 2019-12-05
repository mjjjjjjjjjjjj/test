<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会议室预定</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <style>
        form,table{
            margin-top: 20px;
        }
        body{
            background: url("${pageContext.request.contextPath}/img/img1.jpg");
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/orders/judge">
    <select id="option" name="mid">
        <option value="1001">至尊会议室</option>
        <option value="1002">奢华会议室</option>
        <option value="1003">普通会议室</option>
    </select>
    <input type="text" name="startTime">
    <input type="text" name="endTime">
    <%--<input type="button" value="检查能否预定" id="btn">--%>
    <input type="submit" value="预定">
</form>

<a href="${pageContext.request.contextPath}/test/new">test</a>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/js/jquery-3.3.1.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
<script>
    <%--$(function () {--%>
        <%--$("#btn").click(function () {--%>
            <%--$("#yuding").ajaxSubmit({--%>
                <%--url:"${pageContext.request.contextPath}/orders/judge",--%>
                <%--type:"POST",--%>
                <%--success:function (data) {--%>
                    <%--alert(data);--%>
                <%--}--%>
            <%--})--%>
        <%--})--%>
    <%--})--%>
</script>