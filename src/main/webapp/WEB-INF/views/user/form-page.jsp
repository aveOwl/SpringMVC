<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>SpringMVC</title>
</head>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${userForm['new']}">
            <h1>Add User</h1>
        </c:when>
        <c:otherwise>
            <h1>Update User</h1>
        </c:otherwise>
    </c:choose>
    <br/>
    <spring:url value="/users" var="urlShowUsers"/>

    <form:form class="form-horizontal" modelAttribute="userForm" action="${urlShowUsers}" method="post">

        <form:hidden path="userId"/>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">FirstName</label>
                <div class="col-sm-10">
                    <form:input path="firstName" type="text" class="form-control " id="firstName"
                                placeholder="FirstName"/>
                    <form:errors path="firstName" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">LastName</label>
                <div class="col-sm-10">
                    <form:input path="lastName" type="text" class="form-control " id="lastName" placeholder="LastName"/>
                    <form:errors path="lastName" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="nickName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">NickName</label>
                <div class="col-sm-10">
                    <form:input path="nickName" type="text" class="form-control " id="nickName" placeholder="NickName"/>
                    <form:errors path="nickName" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <form:input path="email" class="form-control" id="email" placeholder="Email"/>
                    <form:errors path="email" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <form:password path="password" class="form-control" id="password" placeholder="Password"/>
                    <form:errors path="password" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Confirm Password</label>
                <div class="col-sm-10">
                    <form:password path="confirmPassword" class="form-control" id="confirmPassword"
                                   placeholder="ConfirmPassword"/>
                    <form:errors path="confirmPassword" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${userForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
