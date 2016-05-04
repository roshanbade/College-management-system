<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>View Grades</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Grades</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/examSection/inputFacultyAndSem"/> ">Home</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<table class="table table-bordered">
		<caption>Student id = ${studentId}</caption>
		<tr>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>First Term Grade</th>
			<th>Second Term Grade</th>
			<th>Board Exam Grade</th>
			<th> </th>
		</tr>
		<c:forEach items="${grades}" var="grade">
		<tr>
			<td>${grade.getCourseCode()}</td>
			<td>${grade.getCourseName()}
			<td>${grade.getFirstTerm()}</td>
			<td>${grade.getSecondTerm()}</td>
			<td>${grade.getBoardExamGrade()}</td>
			<td><a href="<c:url value = "/examSection/updateGrades?courseCode=${grade.getCourseCode()}&studentId=${studentId}" />">Update</a></td>			
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>
