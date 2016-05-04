<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception Occured</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/myCSS.css"/>">
</head>
<body>
	<br />
	<div class="container">
		<div class="jumbotron" style="background-color:red">
			<c:if test="${origin eq 'admission'}">
				<h2>
					<p>
						There already exists a row with <b><em>id = ${invalidId}</em></b>.Please check the input.
					</p>
				</h2>
			</c:if>

			<c:if test="${origin eq 'examSection'}">
				<h2>
					There is no student with <em>id = ${invalidId}</em>.
				</h2>
			</c:if>

			<c:if test="${origin eq 'instructor'}">
				<h2>
					Instructor with <em>id '${invalidId}'</em> already exists. Please choose a different instructor id.
				</h2>
			</c:if>

			<c:if test="${origin eq 'admin'}">
				<h2>
					Faculty with <em>name = '${invalidId}'</em> does not exist. Please check your input
				</h2>
			</c:if>
		</div>
	</div>
</body>
</html>
