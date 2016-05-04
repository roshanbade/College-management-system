<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Book By Id</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	
	<div class="jumbotron">
		<div class="container">
			<h1>Book ${bookById.bookId }(${bookById.name })</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/library/show" />">Back</a>
			</div>
		</div>
	</div>
		
	
			<table border="2px" class = "table table-bordered" >
			
			
			
			<tr>
				<td>Book Id</td>
				<td>${bookById.bookId }</br></td>	
			</tr>
			
			<tr>
				<td>Name</td>
				<td>${bookById.name }</br></td>
			</tr>
			
			<tr>
				<td>Author</td>
				<td>${bookById.author }</br></td>
			</tr>
			
			<tr>
				<td>Faculty</td>
				<td>${bookById.faculty }</br></td>
			</tr>
			
			<tr>
				<td>Semester</td>
				<td>${bookById.semester }</br></td>
			</tr>
			
			<tr>
				<td>Publication Name</td>
				<td>${bookById.publisher }</td>
			</tr>
			
			
			
			</table>
			
			
</body>
</html>