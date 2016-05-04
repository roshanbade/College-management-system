<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student Info</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Student Info</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/examSection/inputFacultyAndSem" />">Back</a>
			</div>
		</div>
	</div>

	<div class="container">
	<table class="table table-bordered">
		<thead>
		<tr>
			<th>Student Id</th>
			<th>First Name</th>
			<th>Second Name</th>
			<th>Faculty</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.getStudentId()}</td>
				<td>${student.getFirstName()}</td>
				<td>${student.getLastName()}</td>
				<td>${student.getFaculty()}</td>
				<td><a href="<c:url value = "/examSection/viewGrades?studentId=${student.getStudentId()}" />">View Grades</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>