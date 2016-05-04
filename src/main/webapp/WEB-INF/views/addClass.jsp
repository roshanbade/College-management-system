<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Class</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>	
	<div class="jumbotron">
		<div class="container">
			<h1>Add Class</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/classroom" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<form:form class="form-horizontal" modelAttribute="classroom" enc-type="form-data">
		<fieldset>
		<legend>Class Info</legend>
		<div class="form-group">
			<label for="className" class="control-label col-md-2">Class Name</label>
			<div class="col-md-10">
			 	<form:input id="className" path="className" type="text" /> <form:errors cssClass="text-danger" path="className"/>
			 </div>
		</div>
		
		<div class="form-group">
			<label for="rows" class="control-label col-lg-2">Number of rows</label>
			<div class="col-md-10">
				<form:input id="rows" path="rows" type="number" /> <form:errors cssClass="text-danger" path="rows"/>
			 </div>
		</div>		
		
		<div class="form-group">
			<label for="columns" class="control-label col-lg-2">Number of cloumns</label>
			<div class="col-md-10">
				<form:input id="columns" path="columns" type="number" /> <form:errors cssClass="text-danger" path="columns"/>
			 </div>
		</div>		
		
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input class="btn btn-primary" type="submit" value="Add Class"/>
			</div>
		</div>
		</fieldset>
	</form:form>
	</div>
</body>
</html>
