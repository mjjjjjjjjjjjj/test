
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>result</title>
    <style>
        body{
            background: url("${pageContext.request.contextPath}/img/img6.jpg")no-repeat;
            background-height: 100%;
        }
    </style>
</head>
<body>
<c:if test="${requestScope.result.result}">
    <h1>${requestScope.result.message}</h1>
</c:if>
<c:if test="${!requestScope.result.result}">
    <h1>${requestScope.result.message}</h1>
</c:if>
</body>
</html>

