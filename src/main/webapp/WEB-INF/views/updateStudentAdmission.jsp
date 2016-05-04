<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Update Student Information</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Update Student (${student.getStudentId()})</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/admission" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<form:form class="form-horizontal" modelAttribute="student" enc-type="form-data">
		<fieldset>
		<legend>Faculty Info</legend>
		<div class="form-group">
			<label for="firstName" class="control-label col-md-2">First Name</label>
			<div class="col-md-10">
			 	<form:input id="firstName" path="firstName" type="text" value="${student.getFirstName()}" /> <form:errors cssClass="text-danger" path="firstName"/>
			 </div>
		</div>
		
		<div class="form-group">
			<label for="lastName" class="control-label col-lg-2">Last Name</label>
			<div class="col-md-10">
				<form:input id="lastName" path="lastName" type="text" value="${student.getLastName()}"/>
			 </div>
		</div>		
		
		<div class="form-group">
			<label for="faculty" class="control-label col-lg-2">Faculty</label>
			<div class="col-md-10">
				<form:input path="faculty" id="faculty" type="string" value="${student.getFaculty()}"/> <form:errors cssClass="text-danger" path="faculty"/>
			 </div>
		</div>
		
		<div class="form-group">
			<label for="joinDate" class="control-label col-lg-2">Join Date(yyyy-mm-dd)</label>
			<div class="col-md-10">
				<form:input path="joinDate" id="joinDate" type="date" value="${student.getJoinDate()}"/> <form:errors cssClass="text-danger" path="joinDate"/>
			 </div>
		</div>		
		
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input class="btn btn-primary" type="submit" value="Update"/>
			</div>
		</div>
		</fieldset>
	</form:form>
	</div>

</body>
</html>