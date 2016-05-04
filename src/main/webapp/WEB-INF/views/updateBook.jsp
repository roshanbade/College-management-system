<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Book</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>

	<div class="jumbotron">
		<div class="container">
			<h1>Update Book ${book.getBookId() }</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/library/showAll" />">Back</a>
			</div>
		</div>
	</div>

	
	
	<form:form modelAttribute="book" enctype="form-data" role= "form" class = "form-horizontal">
	
			<div class = "form-group">
					<label class = "control-label col-md-2">Name</label>
					<div class = "col-md-10">
						<form:input path="name" type = "text" placeholder = "Name"/>
						<form:errors path="name"/>
					</div>
				</div>
				
				<div class = "form-group">
					<label class="control-label col-md-2">Author</label>
					<div class = "col-md-10">
						<form:input path="author" type = "text"/>
						<form:errors path="author"/>
					</div>
				</div>
				
				
				<div class = "form-group">
					<label class="control-label col-md-2">Faculty</label>
					<div class = "col-md-10">
						<form:input path="faculty" type = "text"/>
						<form:errors path="faculty"/>
					</div>
				</div>
				
				
				<div class = "form-group">
					<label class="control-label col-md-2">semester</label>
					<div class = "col-md-10">
						<form:input path="semester" type = "text"/>
						<form:errors path="semester"/>
					</div>
				</div>
				
				<div class = "form-group">
					<label class="control-label col-md-2">Publication Name</label>
					<div class = "col-md-10">
						<form:input path="publisher" type = "text"/>
						<form:errors path="publisher"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input class="btn btn-primary" type="submit" value="Update"/>
					</div>
				</div>
			</fieldset>	
			</form:form>
		<%-- Name:		<form:input path="name" value = "${book.getName() }"/><br />
		Author:		<form:input path="author" value = "${book.getAuthor() }"/><br />
		Faculty:	<form:input path="faculty" value = "${book.getFaculty() }"/><br />
		Semester:	<form:input path="semester" value = "${book.getSemester() }"/><br />
		Publisher:	<form:input path="publisher" value = "${book.getPublisher() }"/><br />
		
		<input type = "submit" value="Update"> --%>
	
</body>
</html>