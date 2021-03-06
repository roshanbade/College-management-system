<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Instructors By Department</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Instructor Info of IT</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/IT" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<table class="table table-bordered" border="1">
			<thead>
			<tr>
				<th>Instructor Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Courses</th>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${instructors}" var="instructor">
				<tr>
					<td>${instructor.getInstructorId()}</td>
					<td>${instructor.getFirstName()}</td>
					<td>${instructor.getLastName()}</td>
					<td>${instructor.getListOfCourseOffered()}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>