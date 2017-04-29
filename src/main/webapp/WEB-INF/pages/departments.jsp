<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Departments</title>

    <style type="text/css">
        label {
            display: block;
            width: 100px;
        }
    </style>

    <!-- Bootstrap core CSS -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${bootstrap}" rel="stylesheet"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="alert alert-info" role="alert">List of Departments</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty listDepartments}">
        <tr>
            <td>&lt;empty&gt;</td>
        </tr>
    </c:if>
    <c:if test="${!empty listDepartments}">
        <c:forEach items="${listDepartments}" var="department">
            <tr>
                <td><a href="/department/${department.getDepartment_id()}">${department.getName()}</a></td>
                <td><a href="<c:url value='/department/edit/${department.getDepartment_id()}'/>"><span
                        class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="<c:url value='/department/remove/${department.getDepartment_id()}'/>"><span
                        class="glyphicon glyphicon-remove-sign"></span></a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>

<c:if test="${department.getDepartment_id() == 0}">
    <div class="alert alert-info" role="alert">New Department</div>
</c:if>
<c:if test="${department.getDepartment_id() > 0}">
    <div class="alert alert-info" role="alert">Edit Department</div>
</c:if>

<table>
    <form:form method="POST" commandName="department" action="/department/add">
        <c:if test="${department.getDepartment_id() > 0}">
            <tr>
                <td>
                    <label for="idInput">id:</label>
                    <form:input path="department_id" id="idInput" readonly="true" disabled="true"></form:input>
                    <form:hidden path="department_id"/>
                </td>
            </tr>
            <tr>
        </c:if>
        <tr>
            <td>
                <label for="nameInput">Name:</label>
                <form:input path="name" id="nameInput"></form:input>
            </td>
            <td><form:errors path="name" cssStyle="color: #ff0000;" element="div"></form:errors></td>
        </tr>
        <tr>
            <td>
                <c:if test="${department.getDepartment_id() == 0}">
                    <button type="submit" class="btn btn-info">Add department</button>
                    <button formaction="/demonstration" type="submit" class="btn btn-info">Demonstration data</button>
                    <button formaction="/delete/all" type="submit" class="btn btn-info">Delete all data</button>
                </c:if>
                <c:if test="${department.getDepartment_id() > 0}">
                    <button type="submit" class="btn btn-info">Update</button>
                    <button formaction="/department/cancel" type="submit" class="btn btn-info">Cancel</button>
                </c:if>
            </td>
        </tr>
        <c:if test="${not empty actionMessage}">
            <div class="alert alert-success">
                <strong>Success!</strong> ${actionMessage}
            </div>
        </c:if>
    </form:form>
</table>
</body>
</html>
