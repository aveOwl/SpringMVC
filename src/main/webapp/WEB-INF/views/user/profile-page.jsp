<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Profile</title>
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
    <h1>User Detail</h1>
    <br />
    <div class="row">
        <label class="col-sm-2">FirstName</label>
        <div class="col-sm-10">${user.firstName}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">LastName</label>
        <div class="col-sm-10">${user.lastName}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">NickName</label>
        <div class="col-sm-10">${user.nickName}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Email</label>
        <div class="col-sm-10">${user.email}</div>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
