<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Get Attendance Data</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	
	<div class="jumbotron">
		<div class=container>
			<h1>Input Data</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/instructor/attendanceHome" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class=container>
	<form:form class="form-horizontal" modelAttribute="attendance" enc-type="form-data">
		<fieldset>
		<legend>Input</legend>
		<div class="form-group">
			<label for="instructorId" class="control-label col-md-2">Course Id</label>
			<div class="col-md-10">
			 	<form:input id="courseId" path="attendanceId.courseId" type="text" />
			 </div>
		</div>
		
		<div class="form-group">
			<label for="firstName" class="control-label col-lg-2">Faculty</label>
			<div class="col-md-10">
				<form:input id="faculty" path="attendanceId.faculty" type="text" />
			 </div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-lg-2">Semester</label>
			<div class="col-md-10">
				<form:input id="semester" path="attendanceId.semester" type="text" />
			 </div>
		</div>
		
		
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input class="btn btn-primary" type="submit" value="Show Students"/>
			</div>
		</div>
		</fieldset>
	</form:form>
	</div>

</body>
</html>