<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
    <title>Front Page</title>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"/>
    <link href="${bootstrapCSS}" rel="stylesheet" />
</head>
<body>
    <div class="text-center">
        <spring:url value="/users" var="urlShowAll"/>
        <h1>Welcome</h1>
        <hr>
        <a href="${urlShowAll}">view all user's</a>
        <hr>
    </div>
</body>
</html>