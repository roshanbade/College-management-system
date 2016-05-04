<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Data</title>
</head>
<body>
	<form:form modelAttribute="instructor" >
			<table>
				
			<tr>
				<td>Instructor Id</td>
				<td><form:input path="instructorId" type = "text"/></td>
				<td><input type="submit" value="Submit" /> </td>
			</tr>
			
			</table>
	</form:form>
			
</body>
</html>