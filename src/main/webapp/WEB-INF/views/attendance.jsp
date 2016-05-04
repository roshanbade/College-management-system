<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Attendance</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class=container>
			<h1>Attendance</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/" />">Log out</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<form action="<c:url value = "/instructor/newAttendance"/>" method="get">
			<button class="btn btn-danger btn-lg btn-block" name="addInstructor">New Attendance</button>
		</form>
		
		<br />
		<form action="<c:url value = "/instructor/getAttendance" />" method="get">
			<button class="btn btn-danger btn-lg btn-block" name="addInstructor">View Attendance</button>
		</form>
	</div>
	
</body>
</html>