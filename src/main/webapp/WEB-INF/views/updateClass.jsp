<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Class</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Update Class</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/classroom/seeClassroomInfo" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<form:form class="form-horizontal" modelAttribute="classroom" enc-type="form-data">
		<fieldset>
		<legend>Class Info</legend>
		
		<div class="form-group">
			<label for="rows" class="control-label col-lg-2">New Number of rows</label>
			<div class="col-md-10">
				<form:input id="rows" path="rows" type="text" value="${classroom.rows}" /> <form:errors cssClass="text-danger" path="rows"/>
			 </div>
		</div>		
		
		<div class="form-group">
			<label for="columns" class="control-label col-lg-2">New Number of columns</label>
			<div class="col-md-10">
				<form:input id="columns" path="columns" type="text" value="${classroom.columns}" /> <form:errors cssClass="text-danger" path="columns"/>
			 </div>
		</div>		
		
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input class="btn btn-primary" type="submit" value="Update Class"/>
			</div>
		</div>
		</fieldset>
	</form:form>
	</div>

</body>
</html>