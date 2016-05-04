<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Fee Payment</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" 	href="<c:url value="/resource/css/myCSS.css"/>">

</head>
<body>	
	<div class="jumbotron">
		<div class="container">
			<h1>Student Data</h1>			
			<div style="padding-top: 20px">
				<a class="btn btn-danger" href="<c:url value="/account/getStudentId" />">Back</a>
			</div>
		</div>
	</div>
	
	<div class="container">
	<table class="table table-bordered">
		<caption>Student Info</caption>
		<thead>
		<tr>
			<th>Student Id</th>
			<th>First Name</th>
			<th>Second Name</th>
			<th>Faculty</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>${studentFee.getStudentId()}</td>
			<td>${studentFee.getFirstName()}</td>
			<td>${studentFee.getLastName()}</td>
			<td>${studentFee.getFaculty()}</td>
		</tr>
		</tbody>
	</table>
	
	<table class="table table-bordered">
		<caption>Fee Structure</caption>
		<thead>
		<tr>
			<th>Total Cost</th>
			<th>Scholarship</th>
			<th>First Sem</th>
			<th>Second Sem</th>
			<th>Third Sem</th>
			<th>Fourth Sem</th>
			<th>Fifth Sem</th>
			<th>Sixth Sem</th>
			<th>Seventh Sem</th>
			<th>Eight Sem</th>
		</tr>
		</thead>
		
		<tbody>
		<tr>
			<td>${fee.getTotalCost()}</td>
			<td>${fee.getScholarship()}%</td>
			<td>${fee.getFirst()}</td>
			<td>${fee.getSecond()}</td>
			<td>${fee.getThird()}</td>
			<td>${fee.getFourth()}</td>
			<td>${fee.getFifth()}</td>
			<td>${fee.getSixth()}</td>
			<td>${fee.getSeventh()}</td>
			<td>${fee.getEighth()}</td>
		</tr>
		</tbody>
	</table>
	<div class="text-info">
		<h3 >Total due : ${dueFee}</h3>
		<p>Current Semester : ${currentSemester}</p>
	</div>
	
	<br />
	
	<c:url value="/account/processFeePayment?studentId=${studentFee.getStudentId()}" var="myURL"/> 
	
	
	<div class="container">
		<form:form action="${myURL}" modelAttribute="feePayment" class="form-horizontal" enc-type="form-data">
			<fieldset>
				<legend>Input paid Amount</legend>
				<div class="form-group">			
					 <form:input type="number" path="amountPaid" /> <form:errors path="amountPaid" />
				</div>
				<div class="form-group">
					<input class="btn btn-primary" type="submit" value="Add Amount" />			
				</div>
			</fieldset>
		</form:form>
	</div>
	</div>
</body>
</html>
