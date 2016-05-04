<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception occurred</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<br />
	<div class="container">
		<div class="jumbotron" style="background-color:red">
			<c:if test="${origin eq 'department'}"> 	
				<h2>Exception occurred : Course with course code '${courseCode}' already exists. Please check your input.</h2>
			</c:if>
			
			<c:if test="${origin eq 'admin'}"> 	
				<h2>Exception occurred : Course with course code <em>'${courseCode}'</em> does not exist. Please check your input.</h2>
			</c:if>			
		</div>
	</div>
		
</body>
</html>