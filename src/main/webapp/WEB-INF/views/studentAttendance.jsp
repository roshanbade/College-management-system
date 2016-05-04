<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Attendance Data</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>

<body>
	<div class="jumbotron">
		<div class=container>
			<h1>Attendance</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/" />">Back</a>
			</div>
		</div>
	</div>

	<div class="container">
	<div class="row text-info">
		<div class="col-md-6">
		<h3>Attendance of : <br /><br />
		Year : ${attendance.getAttendanceId().getYear()}<br/><br/>
		Faculty : ${attendance.getAttendanceId().getFaculty()}</h3>
		</div>
		<div class="col-md-6">
		<br /><br />
		<h3>Course Id : ${attendance.getAttendanceId().getCourseId()} <br/><br />
		Semester : ${attendance.getAttendanceId().getSemester()}</h3>
		</div>
	</div>
	<br />
	
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>Student Id</th>
				<th>Attendance</th>
			</tr>
				<c:forEach items="${attendance.getListOfStudents()}" var="attend">
			<tr>
				<td>${attend.key}</td>
				<%-- <td>${attend.value}</td> --%>
				<c:if test="${attend.value eq true}"> <td>Present</td> </c:if>
				<c:if test="${attend.value eq false}"> <td>Absent</td> </c:if>			
			</tr>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>