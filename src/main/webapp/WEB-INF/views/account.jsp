<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
	<title>Accounts</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>

<body>	
	<div class="jumbotron">
		<div class="container">
			<h1>Account</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/j_spring_security_logout" />">Log out</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<form action="<c:url value="/account/getStudentId" />" method="get">
	    	<button class="btn btn-success btn-lg btn-block">Fee Payment</button>
		</form>
	</div>	
	<br />
	
	<div class="container text-danger">
		<h1>There are ${count} new students.<h1></h1>
	</div>
	
	<div class="container">
		<table class="table table-bordered">
			<thead>
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last name </th>
				<th>Faculty </th>
				<th> </th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${newStudents}" var="student">
			<tr>
				<td>${student.getStudentId()}</td>
				<td>${student.getFirstName()}</td>
				<td>${student.getLastName()} </td>
				<td>${student.getFaculty()} </td>
				<td><a href="<c:url value="/account/addAccountData?studentId=${student.getStudentId()}" />">Add Account Data</a> </td>
			</tr>		
			</c:forEach>
			</tbody>
		</table>
		<br />
	</div>
	
</body>
</html>