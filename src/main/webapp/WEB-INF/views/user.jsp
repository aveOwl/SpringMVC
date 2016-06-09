<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <table>
        <tr>
            <td>ID</td>
            <td>${user.userId}</td>
        </tr>
        <tr>
            <td>UserName</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
    </table>
</body>
</html>