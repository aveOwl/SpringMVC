<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Profile</title>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"/>
    <link href="${bootstrapCSS}" rel="stylesheet"/>
</head>
<body>
<h2>
    User with ID=${user.userId}
</h2>
<br/>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>nickName</th>
        <th>password</th>
        <th>email</th>
        <th>month_salary</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${user.firstName} </td>
            <td>${user.lastName} </td>
            <td>${user.nickName} </td>
            <td>${user.password} </td>
            <td>${user.email} </td>
            <td>${user.month_salary} </td>
        </tr>
    </tbody>
</table>
</body>
</html>
