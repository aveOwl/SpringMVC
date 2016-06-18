<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
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
User with ID=${user.userId}<br/><br/>
<table>
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>nickName</th>
        <th>password</th>
        <th>email</th>
        <th>month_salary</th>
    </tr>
        <tr>
            <td>${user.firstName} </td>
            <td>${user.lastName} </td>
            <td>${user.nickName} </td>
            <td>${user.password} </td>
            <td>${user.email} </td>
            <td>${user.month_salary} </td>
        </tr>
</table>
</body>
</html>
