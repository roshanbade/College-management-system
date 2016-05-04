<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value = "/resource/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value = "/resource/css/myCSS.css" />">

 
<title>Welcome</title>

</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>College Management System</h1>
			</div>
			<div style="padding-right: 30px">
			<a class="btn btn-info pull-right" href="<c:url value="/setSampleData" /> ">Sample Data</a>
			</div>
		</div>		
	</section>

	<div class="container">
		

		<div class="row">
			<div class="col-md-6">
				<form action="<c:url value="/admin" />" method="get">
					<button class="btn btn-warning btn-lg btn-block" >Administration</button>
				</form>

				<form action="<c:url value="/admission" />" method="get">
					<button class="btn btn-danger btn-lg btn-block" >Admission</button>
				</form>

				<form action="<c:url value="/account" />" method="get">
					<button class="btn btn-success btn-lg btn-block">Account</button>
				</form>		
				
				<form action="<c:url value="/faculty" />" method="get">
					<button class="btn btn-primary btn-lg btn-block">Faculty</button>
				</form>
			</div>
			
			<div class="col-md-6">
				<form action="<c:url value="/examSection" />" method="get">
					<button class="btn btn-warning btn-lg btn-block">Exam Section</button>
				</form>

				<form action="<c:url value="/instructor/attendanceHome" />" method="get">
					<button class="btn btn-danger btn-lg btn-block">Attendance</button>
				</form>

				<form action="<c:url value="/library" />" method="get">
					<button class="btn btn-success btn-lg btn-block">Library</button>
				</form>
				<br />
			</div>
		</div>
	</div>
</body>
</html>