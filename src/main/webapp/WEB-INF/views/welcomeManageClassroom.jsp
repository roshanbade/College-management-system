<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Manage Classroom</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>" > 
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>" >
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Manage Classrooms</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/admin" />" >Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
				<div class="col-md-6">
					<form action="<c:url value="/classroom/addClass" />" method="get">
						<button class="btn btn-warning btn-lg btn-block">Add class</button>
					</form>
				</div>
				
				<div class="col-md-6">
					<form action="<c:url value="/classroom/seeClassroomInfo" />" method="get">
						<button class="btn btn-warning btn-lg btn-block">See Class Info</button>
					</form>
				</div>
		</div>
	</div>	
</body>
</html>