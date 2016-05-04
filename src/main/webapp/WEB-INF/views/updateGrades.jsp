<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Grades</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Update Grades</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/examSection/viewGrades?studentId=${studentId}" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class=container>
	<form:form class="form-horizontal" modelAttribute="examGrades" enc-type="form-data">
		<fieldset>
		<legend>Grdae Info</legend>
		<div class="form-group">
			<label for="instructorId" class="control-label col-md-2">First Term</label>
			<div class="col-md-10">
			 	<form:input id="firstTerm" path="firstTerm" type="text" /> <form:errors cssClass="text-danger" path="firstTerm"/>
			 </div>
		</div>
		
		<div class="form-group">
			<label for="firstName" class="control-label col-lg-2">Second Term</label>
			<div class="col-md-10">
				<form:input id="secondTerm" path="secondTerm" type="text" /> <form:errors cssClass="text-danger" path="secondTerm"/>
			 </div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-lg-2">Board Exam</label>
			<div class="col-md-10">
				<form:input id="boardExamGrade" path="boardExamGrade" type="text" /> <form:errors cssClass="text-danger" path="boardExamGrade"/>
			 </div>
		</div>
		
		
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input class="btn btn-primary" type="submit" value="Update Grades"/>
			</div>
		</div>
		</fieldset>
	</form:form>
	</div>
</body>
</html>