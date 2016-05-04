<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administration</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class=container>
			<h1>Administration</h1>
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/j_spring_security_logout" />">Log out</a>
			</div>
		</div>
	</div>

	<div class=container>
		<div class="row">
			<div class="col-md-6">
				<form action="<c:url value="/instructor/addInstructor" />" method="get">
					<button class="btn btn-warning btn-lg btn-block">Add New Instructor</button>
				</form>
				<br />	
				<form action="<c:url value="/instructor/seeInstructorInfo" />" method="get">
					<button class="btn btn-warning btn-lg btn-block">See Instructor Info</button>
				</form>
				<br />
				<form action="<c:url value="/admin/addInstructorToFaculty" />" method="get">
					<button class="btn btn-warning btn-lg btn-block">Assign Instructor To
						Department</button>
				</form>
			</div>
			
			<div class="col-md-6">
				<form action="<c:url value="/admin/addFaculty" />" method="get">
					<button class="btn btn-warning btn-lg btn-block" >Create New Faculty</button>
				</form>
				<br />
				<form action="<c:url value="/classroom" />" method="get">
					<button class="btn btn-warning btn-lg btn-block">Manage Classrooms</button>
				</form>

			</div>
		</div>
	</div>
</body>
</html>