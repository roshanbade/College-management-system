<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Grades</title>
</head>
<body>
	<h1>Add Grades</h1>
	<form:form modelAttribute="course" enc-type="form-data">
		Course Code : <form:input id="courseCode" path="courseCode" type="text" />
		<br />
		First Term  : <form:input id="firstTerm" path="firstTerm" type="text" />
		<br />
		Second Term : <form:input id="secondTerm" path="secondTerm" type="text" />
		<br />
		Board Exam  : <form:input id="boardExamGrade" path="boardExamGrade" type="text" />
		
		<input type="submit" value="Add Course" />
	</form:form>
</body>
</html>
