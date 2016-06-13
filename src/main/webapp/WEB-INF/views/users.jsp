<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
</head>
<style>
    table {
        width:100%;
    }
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td {
        padding: 5px;
        text-align: left;
    }
    table#t01 tr:nth-child(even) {
        background-color: #eee;
    }
    table#t01 tr:nth-child(odd) {
        background-color:#fff;
    }
    table#t01 th {
        background-color: black;
        color: white;
    }
</style>
<body>
Data you've fetched:<br/><br/>
<table>
    <tr>
        <th>user_id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>nickName</th>
        <th>password</th>
        <th>email</th>
        <th>month_salary</th>
    </tr>
<c:forEach items="${users}" var="user">
        <tr>
            <td>${user.userId} </td>
            <td>${user.firstName} </td>
            <td>${user.lastName} </td>
            <td>${user.nickName} </td>
            <td>${user.password} </td>
            <td>${user.email} </td>
            <td>${user.month_salary} </td>
        </tr>
</c:forEach>
</table>

</body>

</html>