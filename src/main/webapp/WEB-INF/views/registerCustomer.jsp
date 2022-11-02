<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans|Sofia|Trirong">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
	integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="../../asserts/js/loadFileName.js"></script>
<script src="../../asserts/js/previewImg.js"></script>
<link rel="stylesheet" href="../../asserts/css/style.css">
<title>Register Customer Information</title>
</head>
<body>
	<div class="container-fluid ">
		<nav class="row topnavbar py-1">
			<a href="index.html" class="navbar-brand ml-3 mr-auto"><img
				class="img" src="../../asserts/img/logo.png"></a>
		</nav>
		<div class="row">
			<div class="col-sm-3 border-right left" id="accordion">
				<div class="list-group list-group-flush">
					<div class="list-group-item text-white profile">
						<div>
							<img class="img-admin" src="../../asserts/img/admin.png">
						</div>
						<div class="mt-1">Admin</div>
						<div class="mt-1">admin@fsoft.com.vn</div>
					</div>
					<div class="menu">
						<div class="list-group-item text font-weight-bold act">Home</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#employee">
								<div class="col-sm-10 font-weight-bold ">Employee
									Management</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="employee" data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Employee List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Create Employee</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#customer">
								<div class="col-sm-10 font-weight-bold ">Customer
									Management</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="customer" data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Customer List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Create Customer</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#vaccineType">
								<div class="col-sm-10 font-weight-bold ">Vaccine Type
									Management</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="vaccineType"
								data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none" href="#"> <span
										class="ml-2">Vaccine Type List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none" href="#"> <span
										class="ml-2">Vaccine Type Employee</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#vaccine">
								<div class="col-sm-10 font-weight-bold ">Vaccine
									Management</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="vaccine" data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none" href="#"> <span
										class="ml-2">Vaccine List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Create Vaccine</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#inject">
								<div class="col-sm-10 font-weight-bold ">Injection
									Schedule</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="inject" data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Injection Schedule List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Create Injection Schedule</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#injectResult">
								<div class="col-sm-10 font-weight-bold ">Injection Result</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="injectResult"
								data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none" href="#"> <span
										class="ml-2">Injection Result List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Create Injection Result</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#news">
								<div class="col-sm-10 font-weight-bold ">News</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="news" data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">News List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Create News</span>
									</a>
								</div>
							</div>
						</div>
						<div class="list-group-item">
							<div class="row text act" data-toggle="collapse"
								data-target="#report">
								<div class="col-sm-10 font-weight-bold ">Report</div>
								<div class="col-sm-2">
									<i class="fa-solid fa-plus"></i>
								</div>
							</div>
							<div class="mt-3 collapse" id="report" data-parent="#accordion">
								<div class="ml-4 text-sub">
									<a class="text-reset text-decoration-none " href="#"> <span
										class="ml-2">Report Customer</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none" href="#"> <span
										class="ml-2">Report Vaccine</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9 bg-light right">
				<div
					class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REGISTER
					CUSTOMER INFORMATION</div>
				<form:form action="${pageContext.request.contextPath}/registerCustomer"
							method="post" modelAttribute="customer" id="registerForm">
					<div class="card mx-3">
						<div class="card-body">
							<div class="font-weight-bold my-2">Personal Information</div>
							<div class="form-row">
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="fullName">Full
										Name <span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2" value="${customer.id}"
											id="fullName" name="fullName" required>
									</div>

								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="DOB">Date Of
										Birth <span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="date"
											class="form-control ml-2" value="${customer.dateOfBirth}"
											id="DOB" name="dateOfBirth" required>
									</div>
								</div>
								<div class="form-group col-sm-3">
									<label class="font-weight-bold" for="gender">Gender

									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="gender" id="gender" value="${customer.gender}">
											<label class="form-check-label" for="inlineRadio1">Male</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="gender" id="gender" value="${customer.gender}">
											<label class="form-check-label" for="inlineRadio2">Female</label>
										</div>
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="idCard">Identity
										Card <span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2" value="${customer.identityCard}"
											id="idCard" name="identityCard" required>
									</div>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="address">Address
										<span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2" value="${customer.address}"
											id="address" name="address" required>
									</div>
								</div>

							</div>

						</div>
					</div>
					<div class="card m-3">
						<div class="card-body">

							<div class="font-weight-bold my-2">Account Information</div>
							<div class="form-row">
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="userName">Username
										<span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2" value="${customer.userName}"
											id="userName" name="userName" required>
									</div>

								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="password">Password
										<span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2" value="${customer.password}"
											id="typename" name="password" required>
									</div>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="rePassword">Password
										Confirm <span class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2"
											id="rePassword" name="rePassword" >
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="email">Email <span
										class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="email"
											class="form-control ml-2" value="${customer.email}"
											id="email" name="email" required>
									</div>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="phone">Phone <span
										class="text-danger">(*)</span> :
									</label>
									<div class="form-inline">
										<i class="fa-solid fa-fill h5"></i> <input type="text"
											class="form-control ml-2" value="${customer.phone}"
											id="phone" name="phone" required>
									</div>
								</div>


							</div>

							<div class="mt-5">
								<button type="submit" class="btn btn-sm btn-success" > Save </button>
								<button type="reset" class="btn btn-sm btn-primary ml-2">Reset</button>
								<a class="btn btn-sm btn-warning ml-2" href="#">Cancel</a>
							</div>
							<p>${messSave}</p>
						</div>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</body>
</html>