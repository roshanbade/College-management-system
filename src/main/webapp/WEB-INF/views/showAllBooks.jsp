<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>All books</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
	<body>

		<div class="jumbotron">
			<div class="container">
				<h1>All Books</h1>			
				<div style="padding-top: 20px">
					<a class="btn btn-danger" href="<c:url value="/library" />">Back</a>
				</div>
			</div>
		</div>
	
		<div class="container">
			<table border="2px" cellpadding="2px" cellspacing="2px" class="table table-bordered">
		
			
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
					<c:forEach var = "books" items="${listOfBooks }">
					<tr>
						<td>${books.bookId }</td>
						<td>${books.name }</td>
						<td>${books.author }</td>
						<td>${books.faculty }</td>
						<td>${books.semester }</td>
						<td>${books.publisher }</td>
						<td><a href = "<c:url value = "/library/update?bookId="/>${books.getBookId() }">Update</a>
						<td><a href = "<c:url value = "/library/delete?bookId="/>${books.getBookId() }">Delete</a>
					</tr>
				</c:forEach>
				</tbody>
			
			</table>
		</div>
	

	</body>
</html>