<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Java EE, Spring (MVC, Security, JPA), Hibernate">
    <meta name="author" content="vakhnenko.com">

    <!-- Open Graph -->
    <meta property="og:title" content="Departments">
    <meta property="og:site_name" content="Departments">
    <meta property="og:url" content="http://app.departments.pp.ua">
    <meta property="og:description" content="Java EE, Spring (MVC, Security, JPA), Hibernate">
    <meta property="og:image" content="http://vakhnenko.com/spring.png">

    <title>Employees</title>

    <!-- Bootstrap core CSS -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/resources/favicon.ico">
</head>

<body>
<div class="container">
    <h1>Departments</h1>

    <!-- Header -->
    <form:form method="get" commandName="department" action="/login">
        <jsp:include page="header.jsp"/>
    </form:form>

    <!-- Table of context -->
    <div class="panel panel-primary">
        <div class="panel-heading">List of Employees</div>
        <div class="panel-body">
            <div class="alert alert-info" role="alert">Top of employees</div>
            <form:form method="POST" commandName="employee" action="/report/top/form">

                Result: ${topEmployees}<br><br>
                <label for="typeInput">Employee type:</label>

                <form:select path="type" id="typeInput">
                    <form:option value="NONE" label="--- Select ---"/>
                    <form:options items="${typeEmployee}"/>
                </form:select>
                <br><br>

                <button type="submit" class="btn btn-info">Generate report</button>
                <button formaction="/departments" type="submit" class="btn btn-info">Departments</button>

                <c:if test="${not empty actionMessage}">
                    <div class="alert alert-success">
                        <strong>Success!</strong> ${actionMessage}
                    </div>
                </c:if>
                <c:if test="${not empty actionError}">
                    <div class="alert alert-danger">
                        <strong>Error!</strong> ${actionError}
                    </div>
                </c:if>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
