<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Issue Books</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
	</head>
	<body>
		<div class="jumbotron">
			<div class="container">
				<h1>Issue/Return books to student ${student.getStudentId() }</h1>			
				<div style="padding-top: 20px">
					<a class="btn btn-danger" href="<c:url value="/library" />">Back</a>
				</div>
				<div class = "col-md-12" style = "padding-top: 20px">
					<a href="<c:url value = "/library"></c:url>" class = "btn btn-primary">Library Home</a>
				</div>
			</div>
		</div>
		
		
		<table border="2px" cellpadding="2px" cellspacing="2px" class = "table table-bordered">
			<caption><h1>Student Information</h1></caption>
			<tr>
				
				<th>First Name</th>
				<th>Last Name</th>
				<th>Faculty</th>
				<th>Gender</th>
			</tr>
		
			<tr>
				
				<td>${student.getFirstName() }</td>
				<td>${student.getLastName() }</td>
				<td>${student.getFaculty() }</td>
				<%-- <td>${student.getGender() }</td> --%>
			</tr>
		
		</table>
			
			
			<table  class = "table table bordered" border="2px" cellspacing="2px" cellpadding="2px">
				<caption><h1>Issued Books</h1></caption>
				
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
				
				<c:forEach var = "books" items="${bookData }">
					<tbody>
						<tr>
							<td>${books.getBookId() }</td>
							<td>${books.getName() }</td>
							<td>${books.getAuthor() }</td>
							<td>${books.getFaculty() }</td>
							<td>${books.getSemester() }</td>
							<td>${books.getPublisher() }</td>
							<td><a href = "<c:url value = "/library/deleteStudentBook?bookId=${books.getBookId() }&studentId=${student.getStudentId()}"  />">Return</a></td>
						</tr>
					</tbody>
				</c:forEach>
				
			
			</table>
			
			<c:url var = "issued" value = "/library/issued?studentId=${student.getStudentId() }"></c:url>
			
			<form:form action = "${issued}" modelAttribute="books" enctype="form-data" class = "form-horizontal">
				
				<div class = "form-group">					
					<label class = "col-md-2 control-label">Enter Book Id:</label>
					<div class = "col-md-10">
						<form:input path="bookId" />
						
					</div>
					<div class = " col-md-10">
						<input type = "submit" class = "btn btn-primary" value="Issue" />
					</div>
				</div>
				
				
			</form:form>
	</body>
</html>