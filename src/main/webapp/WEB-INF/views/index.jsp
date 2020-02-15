<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
		isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="./resources/css/bootstrap.min.css" type="stylesheet" />
<!-- <link href="./resources/css/bootstrap.min.css" type="stylesheet"> -->
</head>
<body>
		<table >
				<form:form action="save" modelAttribute="student" method="POST">
						<tr>
						<form:hidden path="id" />
								<td>First Name:</td>
								<td><form:input path="firstName" /></td>
						</tr>
						<tr>
								<td>Last Name:</td>
								<td><form:input path="lastName" /></td>
						</tr>
						<tr>
								<td><input type="submit" value="Submit"></td>
						</tr>
				</form:form>
		</table>
		<table class="table" >
				<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Actions</th>
				</tr>
				<c:forEach items="${list}" var="s">
						<tr>
								<td>${s.firstName}</td>
								<td>${s.lastName}</td>
									<td><a href="edit?id=${s.id}">Edit</a>&nbsp&nbsp&nbsp<a href="delete?id=${s.id}">Delete</a></td>
						</tr>
				</c:forEach>
		</table>
</body>
</html>