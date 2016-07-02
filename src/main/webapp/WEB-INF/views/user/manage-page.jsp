<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Users List</title>
</head>
<body>
<jsp:include page="../fragments/header.jsp" />
<div class="container">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Users List</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>user_id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>nickName</th>
            <th>email</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.nickName}</td>
                <td>${user.email}</td>
                <td>
                    <spring:url value="/user/${user.userId}" var="userUrl" />
                    <spring:url value="/user/${user.userId}/update" var="updateUrl" />
                    <spring:url value="/user/${user.userId}/delete" var="deleteUrl" />

                    <button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
