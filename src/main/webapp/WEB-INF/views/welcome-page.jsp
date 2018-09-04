<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <title>Front Page</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="text-center">
    <spring:url value="/users" var="urlShowUsers"/>
    <h1>Welcome</h1>
    <hr>
    <form action="${urlShowUsers}">
        <button class="btn-primary" type="submit">View all user's</button>
    </form>
    <hr>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
