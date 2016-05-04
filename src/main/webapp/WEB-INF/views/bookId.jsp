<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show Book By Id</title>
		<title>Book By Id</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
	</head>

	<body>
	
		<div class="jumbotron">
			<div class="container">
				<h1>Show Book by Id</h1>			
				<div style="padding-top: 20px">
					<a class="btn btn-danger" href="<c:url value="/j_spring_security_logout" />">Log out</a>
				</div>
			</div>
		</div>
		
		<form:form modelAttribute="showBookById" role = "form" class = "form-horizontal">
			<div class="form-group">
				<label class = "control-label col-md-2">Book ID</label>
				<div class="col-md-10">
					<form:input path="bookId"/>
				</div>
			</div>
			
			<div class = "form-group">
				<div class = "col-lg-offset-2 col-md-2">
					<input type="submit" class="btn btn-primary" value = "Show Book">
				</div>
			</div>
			
		</form:form>
	
	</body>
</html>