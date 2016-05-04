<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<title>New Student</title>
			<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">	
	</head>
	
	<body>
		<fmt:formatDate value="${editableUser.DOB}" pattern="yyyy-MM-dd" var="myDateVar"/>
		<div class="jumbotron">
		<div class="container">
			<h1>Add New Student</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/admission" />">Back</a>
			</div>
		</div>
		</div>
		
		<div class="container">
	
		<form:form class="form-horizontal" modelAttribute="student" enc-type="form-data">
			<fieldset>
			<legend>Student Info</legend>
			
			<div class="form-group">
				<label for="studentId" class="control-label col-md-2">Student Id</label>
				<div class="col-md-10">
				 	<form:input path="studentId" id="studentId" type="number" value="0"/> <form:errors cssClass="text-danger" path="studentId" />
				 </div>
			</div>
			
			<div class="form-group">
				<label for="firstName" class="control-label col-md-2">First Name</label>
				<div class="col-md-10">
				 	<form:input id="firstName" path="firstName" type="text" /> <form:errors cssClass="text-danger" path="firstName"/>
				 </div>
			</div>
			
			<div class="form-group">
				<label for="lastName" class="control-label col-lg-2">Last Name</label>
				<div class="col-md-10">
					<form:input id="lastName" path="lastName" type="text"/>
				 </div>
			</div>		
			
			<div class="form-group">
				<label for="faculty" class="control-label col-lg-2">Faculty</label>
				<div class="col-md-10">
					<form:input path="faculty" id="faculty" type="string"/> <form:errors cssClass="text-danger" path="faculty"/>
				 </div>
			</div>
			
			<div class="form-group">
				<label for="joinDate" class="control-label col-lg-2">Join Date(yyyy-mm-dd)</label>
				<div class="col-md-10">
					<form:input path="joinDate" id="joinDate" type="date"/> <form:errors cssClass="text-danger" path="joinDate"/>
				 </div>
			</div>		
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input class="btn btn-primary" type="submit" value="Add"/>
				</div>
			</div>
			</fieldset>
		</form:form>
		</div>
	</body>
</html>