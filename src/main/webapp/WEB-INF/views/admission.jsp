<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title>New Student</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Admission</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/j_spring_security_logout" />">Log out</a>
			</div>
		</div>
	</div>

	<div class="container">
	<form action="<c:url value="/admission/newStudent"/> " method="get">
		<button class="btn btn-danger btn-lg btn-block">Add New Student</button>
	</form>
	</div>
	
	<div class="container">
	<table class="table table-bordered">
		<caption>Total Students</caption>
		<thead>
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last name </th>
				<th>Faculty</th>
				<th>Join Date </th>
				<th> </th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${allStudents}" var="student">
			<tr>
				<td>${student.getStudentId()}</td>
				<td>${student.getFirstName()}</td>
				<td>${student.getLastName()} </td>
				<td>${student.getFaculty()} </td>
				<td>${student.getJoinDate()} </td>
				<td><a href="<c:url value = "/admission/updateStudent?studentId=${student.getStudentId()}" />">Update</a>
			</tr>		
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>