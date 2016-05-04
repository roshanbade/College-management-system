<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Issued Books</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	
	
	<div class="jumbotron">
			<div class="container">
				<h1>Issued Books to student ${student.getStudentId() }</h1>			
				<div style="padding-top: 20px">
					<a class="btn btn-danger" href="<c:url value="/library" />">Back</a>
				</div>
				<div class = "col-md-12" style = "padding-top: 20px">
					<a href="<c:url value = "/library"></c:url>" class = "btn btn-primary">Library Home</a>
				</div>
			</div>
		</div>
	
		<table class="table table-bordered" >
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Author</th>
					<th>Faculty</th>
					<th>Semester</th>
					<th>Publisher</th>
					
				</tr>
			
				
			</thead>
			
			<tbody>
			
				<tr>
					<td>${book2.getBookId() }</td>
					<td>${book2.getName() }</td>
					<td>${book2.getAuthor() }</td>
					<td>${book2.getFaculty() }</td>
					<td>${book2.getSemester() }</td>
					<td>${book2.getPublisher() }</td>
				</tr>
			
			
			</tbody>			
					
			
		
		</table>
		<%-- 
		<c:url var = "back" value="/library/test?studentId=${student.getStudentId()"></c:url>
		
		<form:form action="${back }" method="post" enctype="form-data">
			<input type = "sumbit" class = "btn btn-primary" value = "Back"/>
		</form:form> --%>
		
</body>
</html>