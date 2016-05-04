<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Get Student Id</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<c:if test="${origin eq 'account'}">
	<div class="jumbotron">
		<div class="container">
			<h1>Fee Payment</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/account" />">Back</a>
			</div>
		</div>
	</div>
	</c:if>
	
	
	<c:if test="${origin eq 'examSection'}">
	<div class="jumbotron">
		<div class="container">
			<h1>View Grades</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/examSection/manageGrades" />">Back</a>
			</div>
		</div>
	</div>
	</c:if>
	
	<div class="container">
		<form:form class="form-horizontal" modelAttribute="student" enc-type="form-data">
			<fieldset>
			<legend>Input Student Id</legend>
				<div class="form-group">
					<form:input class="form-control" placeholder="Student Id" type="text" id="studentId" path="studentId" /><br />
				</div>
				
				<div class="form-group">
					<input class="btn btn-primary" type="submit" value="Check info" />
				</div>
				
			</fieldset>
		</form:form>
	</div>
</body>
</html>