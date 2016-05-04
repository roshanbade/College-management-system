<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
			<h1>Add New Book</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/library" />">Back</a>
			</div>
		</div>
	</div>
	
	<form:form modelAttribute="newBook" enctype="form-data" role = "form" class = "form-horizontal">
			<form:errors path="*"/>
			<fieldset>
				<div class = "form-group">
					<label class="control-label col-md-2 "><spring:message code = "addBooks.form.bookId.label"></spring:message></label>
					<div class = "col-md-10">
						<form:input path="bookId" />
						<form:errors path="bookId"/>
					</div>
				</div>
				
				<div class = "form-group">
					<label class = "control-label col-md-2">Name</label>
					<div class = "col-md-10">
						<form:input path="name" type = "text"/>
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
						<input class="btn btn-primary" type="submit" value="Add"/>
					</div>
				</div>
			</fieldset>	
			</form:form>

</body>
</html>