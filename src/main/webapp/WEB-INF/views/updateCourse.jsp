<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Update Course</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Update Course</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/IT/seeCourseInfo" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<form:form class="form-horizontal" modelAttribute="course" enc-type="form-data">
		<fieldset>
		<legend>Faculty Info</legend>
		<div class="form-group">
			<label for="courseCredit" class="control-label col-md-2">New Course Credit</label>
			<div class="col-md-10">
			 	<form:input id="courseCredit" path="credit" type="text" value="${courseInfo.credit}" />  <form:errors cssClass="text-danger" path="credit"/>
			 </div>
		</div>
		
		<div class="form-group">
			<label for="semester" class="control-label col-lg-2">New Semester</label>
			<div class="col-md-10">
				<form:input id="semester" path="semester" type="text" value="${courseOffered.semester}" /> <form:errors cssClass="text-danger" path="semester"/>
			 </div>
		</div>		
			
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input class="btn btn-primary" type="submit" value="Update Course"/>
			</div>
		</div>
		</fieldset>
	</form:form>
	</div>
	
</body>
</html>