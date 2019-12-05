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
<%--<input type="hidden" value="${requestScope.uuid}">--%>
<a href="${pageContext.request.contextPath}/orders/genOrder?uuid=${requestScope.uuid}" target="_blank">支付</a>
<a href="${pageContext.request.contextPath}/orders/dele?uuid=${requestScope.uuid}" target="_blank">取消订单</a>
<a href="${pageContext.request.contextPath}/orders/redis?uuid=${requestScope.uuid}" target="_blank">查看redis内的数据</a>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/js/jquery-3.3.1.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
<script>

</script>

