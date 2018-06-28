<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-body">
        <a href="https://github.com/ovakhnenko/departments-spring" target="_blank" class="text-left">
            <img src="/resources/github.png" width="35">
        </a>
        <sec:authorize var="loggedIn" access="isAuthenticated()"/>
        <c:if test="${not loggedIn}">
            <button formaction="/login" style="float: right" type="submit" class="btn btn-info">Login</button>
        </c:if>
        <c:if test="${loggedIn}">
            <sec:authentication property="principal.username" />
            <button type="button" class="btn btn-outline-secondary disabled" style="float: right">${username}</button>
            <button formaction="/logout" style="float: right" type="submit" class="btn btn-danger">Logout</button>
        </c:if>
    </div>
</div>
<br>
</body>
</html>
