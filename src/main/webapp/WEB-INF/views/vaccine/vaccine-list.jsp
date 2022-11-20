<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Vaccine List</title>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/DataTables.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/VaccineList.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">



</head>
<body>
	<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">LIST
		VACCINE</div>
	<span class="msg">${msg}</span>
	<div class="card mx-3">
		<div class="card-body">
			<div class="mt-3">
				<table class="table table-striped table-bordered text-center"
					id="table-VC">
					<thead class="table-thead">
						<tr class="bg-info text-white text-center">
							<th><input type="checkbox" id="checkAll"></th>
							<th>Vaccine Id</th>
							<th>Vaccine Name</th>
							<th>Vaccine Type</th>
							<th>Number of Injection</th>
							<th>Origin</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vaccineList}" var="result">
							<tr>
								<td><input type="checkbox" value="${result.id}" name="id"></td>
								<td><a
									href="${pageContext.request.contextPath}/vaccine/update/?idUpdate=${result.id}">${result.id}</td>
								<td>${result.vaccineName}</td>
								<td>${result.vaccineType.vaccineTypeName}</td>
								<td>${result.numberOfInjection}</td>
								<td>${result.origin}</td>
								<%-- <c:if test="${result.status=='true'}">
									<td id="status" class="status" >Active</td>
									</c:if> --%>
								<%-- <c:if test="${result.status=='false'}">
									<td id="status" class="status" >In-Active</td>
									</c:if> --%>
								<td id="status" class="status"><c:if
										test="${result.status == 'true'}">
									Active
									</c:if> <c:if test="${result.status == 'false'}">
									In-Active
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="list-button">
				<button class="btn btn-success" type="submit">
					<a href="${pageContext.request.contextPath}/vaccine/add"
						class="text-white">Create Vaccine</a>
				</button>
				<button class="btn btn-warning" type="submit"
					onclick="updateButton()">Update Vaccine</button>
				<button class="btn btn-danger" type="submit"
					id="make-in-active-button">Make In-Active</button>
			</div>


		</div>
	</div>


	<script src="${pageContext.request.contextPath}/js/ListVaccine.js"></script>
	<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
</body>
</html>