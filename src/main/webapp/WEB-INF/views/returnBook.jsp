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

	<c:url  value = "library/returnBook" var="location"/>

<%-- 	<form:form action="<c:url value = "library/returnBook" />" modelAttribute="student" enctype="form-data">
 --%>	
	<form:form action="${location }" modelAttribute="student" enctype="form-data">
	
	
		<h1>Respective book removed for student ${student.getStudentId() }</h1>
	
	</form:form>
	
</body>
</html>