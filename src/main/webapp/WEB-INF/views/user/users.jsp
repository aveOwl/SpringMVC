<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Users List</title>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"/>
    <link href="${bootstrapCSS}" rel="stylesheet"/>
</head>
<body>
<h2>
    Data you've fetched:
</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>user_id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>nickName</th>
        <th>password</th>
        <th>email</th>
        <th>month_salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <spring:url value="/user/${user.userId}" var="urlUser"/>
        <tr>
            <th scope="row"><a href="${urlUser}">${user.userId}</a></th>
            <td>${user.firstName} </td>
            <td>${user.lastName} </td>
            <td>${user.nickName} </td>
            <td>${user.password} </td>
            <td>${user.email} </td>
            <td>${user.month_salary} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>