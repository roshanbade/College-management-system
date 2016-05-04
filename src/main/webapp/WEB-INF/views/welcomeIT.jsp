<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>IT Department</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Information Technology Department</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/" />">Log out</a>
			</div>
		</div>
	</div>
	
	<div class="container"> 
		<form action="<c:url value="IT/addCourse" />" method="get">
	    	<button class="btn btn-primary btn-lg btn-block" name = "addCourse">Add Course</button>
		</form>
		<br />
		<form action="<c:url value="IT/seeCourseInfo" /> " method="get">
	    	<button class="btn btn-primary btn-lg btn-block" name = "addCourse">See Course Info</button>
		</form>
		<br />
	
		<form action="<c:url value="IT/seeInstructorsByDepartment"/> " method="get">
	    	<button class="btn btn-primary btn-lg btn-block" name = "addCourse">Instructor Info</button>
		</form>
	</div>
</body>
</html>