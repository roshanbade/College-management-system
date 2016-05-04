<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Grade</title>
</head>
<body>
	<h1>Choose Method</h1>
	
	<form action="http://localhost:8080/college/examSection/inputFacultyAndSemGrade" method="get">
		<button name="foo" value="upvote">Input Grades By Faculty</button>
	</form>
	<br />
	
	<form action="http://localhost:8080/college/examSection/individualGrade" method="get">
		<button name="foo" value="upvote">Input Grades By StudentId</button>
	</form>
	<br />

</body>
</html>