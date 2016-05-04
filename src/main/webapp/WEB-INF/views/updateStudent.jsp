<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
</head>
<body>
		<h1>Update Student ${student.getId() }</h1>
		
		<form:form modelAttribute="student" enctype="form-data">
			First Name	:	<form:input path="firstName" placeholder = "First Name"/> <br />
			Last Name	:	<form:input path="lastName" value = "${student.getLastName() }"/>	<br />
			Faculty		:	<form:input path="faculty" value = "${student.getFaculty() }"/>		<br />
			Joined Date	:	<form:input path="joinDate" value = "${student.getJoinDate() }"/>	<br />
			Gender		:	<form:input path="gender" value = "${student.getGender() }"/>		<br />
			
			<input type = "submit" value = "Update">
		</form:form>
</body>
</html>