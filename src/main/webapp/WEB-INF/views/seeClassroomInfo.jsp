<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Classroom Info</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>	
	<div class="jumbotron">
		<div class="container">
			<h1>Classrooms</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/classroom" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Classname</th>
					<th>Number of rows</th>
					<th>Number of cloumns</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classrooms}" var="classroom">
					<tr>
						<td>${classroom.getClassName()}</td>
						<td>${classroom.getRows()}</td>
						<td>${classroom.getColumns()}</td>
						<td><a href="<c:url value="/classroom/updateClass?className=${classroom.getClassName()}" />" > Update </a></td>			
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>	

</body>
</html>