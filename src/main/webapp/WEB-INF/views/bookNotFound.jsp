<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Book</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
	</head>
	<body>
	
		<div class="jumbotron">
			<div class="container">
				<h1>The book with given id is already borrowed!</h1>
				<h3>OR</h3>
				<h2> ${invalidBookId }</h2> 
				
				<p>${url }</p>
				<p>${exception }</p>
		
				
				<div style="padding-top: 20px">
					<a class="btn btn-danger" href="<c:url value="/library" />">Back</a>
				</div>
			</div>
		</div>
		
		
	</body>
</html>