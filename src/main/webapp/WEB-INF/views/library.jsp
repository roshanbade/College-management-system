<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title>Library</title>
	<meta http-equiv="Content-Type" content="text/html;
	charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="<c:url value = "/resource/css/bootstrap.min.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value = "/resource/css/myCSS.css" />">
</head>

<body>

	<div class="jumbotron">
		<div class="container">
			<h1>Library</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/j_spring_security_logout" />">Log out</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		

		<div class="row">
			<div class="col-md-6">

				<form action="<c:url value = "/library/add"/>">
					<button class = "btn btn-warning btn-lg btn-block">Add Books</button>
				</form>
				
				<form action="<c:url value = "/library/show"/>">
					<button class="btn btn-success btn-lg btn-block">Show Book by ID</button>
				</form>
				
			</div>
			
			<div class="col-md-6">
			
				<form action="<c:url value = "/library/showAll"/>">
					<button class="btn btn-danger btn-lg btn-block">Show all books</button>
				</form>
	
				<form action="<c:url value = "/library/test"/>">
					<button class="btn btn-success btn-lg btn-block">Issue/Return Books</button>
				</form>
			
			</div>
		</div>
	
	
	
	
	
	
	
	
	<%-- <form action="<c:url value = "/library/return"/>">
		<input type = "submit" value="Return Books" />
	</form>	 --%>
	
	<%-- <form action="<c:url value="/j_spring_security_logout"></c:url>" method="get">
		<input type="submit" value="Logout"> 
	</form>
	 --%>
	
</body>
</html>