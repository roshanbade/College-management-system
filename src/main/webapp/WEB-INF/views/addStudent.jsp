<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html;
		charset=ISO-8859-1">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Students</title>
	</head>
	
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
				
					<h1> ${greeting} </h1>
					<p> ${tagline} </p>
				
				</div>
			</div>
			
			
			
			<form:form modelAttribute="newStudent" >
			<table>
				
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" type = "text"/></br></td><td>		</td><td><a href="<c:url value = "j_spring_security_logout" ></c:url>">Logout</a></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" type = "text"/></br></td>
			</tr>
			
			<tr>
				<td>Faculty</td>
				<td><form:input path="faculty" type = "text"/></br></td>
			</tr>
			
			<tr>
				<td>Joined Date</td>
				<td><form:input path="joinDate" type ="Date"/></br></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td><form:input path="gender" type = "text"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr> 
			
			</table>
			</form:form>
			
			<a href="<c:url value = "/admission/showAllStudents"></c:url>">Show all Students</a>
		</section>
	</body>
</html>