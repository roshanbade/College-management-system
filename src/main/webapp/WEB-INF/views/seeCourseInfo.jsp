<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Course Info by Department</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Course Info</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/IT" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<table class="table table-bordered">
		<caption>IT department</caption>
		<thead>
		<tr>
			<th>Semester</th>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>Credit</th>
			<th> </th>
			<th> </th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${firstSemCourse}" var="course">
		<tr class="info">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			
			
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />"> Update </a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />"> Delete </a></td>			
		</tr>
		</c:forEach>
		
		<c:forEach items="${secondSemCourse}" var="course">
		<tr class="danger">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />"> Update </a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />"> Delete </a></td>			
		</tr>
		</c:forEach>
		
		<c:forEach items="${thirdSemCourse}" var="course">
		<tr class="info">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />">Update</a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />">Delete</a></td>			
		</tr>
		</c:forEach>
		<c:forEach items="${fourthSemCourse}" var="course">
		<tr class="danger">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />">Update</a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />">Delete</a></td>			
		</tr>
		</c:forEach>
				<c:forEach items="${fifthSemCourse}" var="course">
		<tr class="info">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />">Update</a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />">Delete</a></td>			
		</tr>
		</c:forEach>
				<c:forEach items="${sixthSemCourse}" var="course">
		<tr class="danger">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />">Update</a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />">Delete</a></td>			
		</tr>
		</c:forEach>
		<c:forEach items="${seventhSemCourse}" var="course">
		<tr class="info">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />">Update</a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />">Delete</a></td>			
		</tr>
		</c:forEach>
		<c:forEach items="${eighthSemCourse}" var="course">
		<tr class="danger">
			<td>${course.getSemester()}</td>
			<td>${course.getCourseId()}</td>
			<td>${course.getCourseName()}</td>
			<td>${course.getCredit()}</td>
			<td><a href="<c:url value = "/IT/updateCourse?courseId=${course.getCourseId()}" />">Update</a></td>
			<td><a href="<c:url value = "/IT/deleteCourse?courseId=${course.getCourseId()}" />">Delete</a></td>			
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<br />
	</div>
</body>
</html>