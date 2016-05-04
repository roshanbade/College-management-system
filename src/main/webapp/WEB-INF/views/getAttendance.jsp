<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Attendance</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
		
	<div class="jumbotron">
		<div class=container>
			<h1>Attendance</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/instructor/newAttendance" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<div class="row text-info">
		<div class="col-md-6">
		<h3>Date : ${attendance.getAttendanceId().getYear()}/${attendance.getMonth()}/${attendance.getDate()}<br/><br/>
		Faculty : ${attendance.getAttendanceId().getFaculty()}</h3>
		</div>
		<div class="col-md-6">
		<h3>Course Id : ${attendance.getAttendanceId().getCourseId()} <br/><br />
		Semester : ${attendance.getAttendanceId().getSemester()}</h3>
		</div>
	</div>
	<br />
	
	<table class="table table-bordered">
		<tr>
			<th>Student Id</th>
			<th>Attendance</th>
		</tr>
		<form:form action="http://localhost:8080/college/instructor/addAttendance?faculty=${attendance.getAttendanceId().getFaculty()}&courseId=${attendance.getAttendanceId().getCourseId()}&semester=${attendance.getAttendanceId().getSemester()}&year=${attendance.getAttendanceId().getYear()}&month=${attendance.getMonth()}&date=${attendance.getDate()}" modelAttribute="tempAttendance" enctype="form-data">
		<c:forEach items="${tempAttendance.getListOfStudents()}" var="student">
			<tr>
				<td>${student.key}</td>
				<td><form:checkbox path="listOfStudents['${student.key}']" value="false" /> </td>
			</tr>
		</c:forEach>
		
	</table>
		
		<input class="btn btn-primary " type="submit" value="Submit Data" />
		</form:form>
	</div>

</body>
</html>