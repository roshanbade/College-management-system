
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2px" cellpadding="2px" cellspacing="2px">
	
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Faculty</th>
			<th>Joined Date</th>
			<th>Gender</th>
		</tr>
	
		<c:forEach var = "students" items="${showAllStudents }">
		
			<tr>
				
				<td>${students.id }</td>
				<td>${students.firstName }</td>
				<td>${students.lastName }</td>
				<td>${students.faculty }</td>
				<td>${students.joinDate }</td>
				<td>${students.gender }</td>
				<td><a href = "<c:url value = "/admission/updateStudent?id=" />${students.getId() }">Update</a></td>
				<td><a href = "<c:url value = "/admission/deleteStudent?id=" />${students.getId() }">Delete</a></td>
				
			</tr>
		
		</c:forEach>
		
		
	
	</table>
	
	<a href="<c:url value = "/admission"></c:url>">Add New Student</a>
	
</body>
</html>