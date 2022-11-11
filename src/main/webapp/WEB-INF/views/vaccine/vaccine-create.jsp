<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script src="../../asserts/js/loadFileName.js"></script>
<script src="../../asserts/js/previewImg.js"></script>
<link rel="stylesheet" href="../../asserts/css/style.css">
<title>Create</title>
<style type="text/css">
.a {
	width: 100%;
}
.eroor {
	color: red;
 }
</style>
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
									<a class="text-reset text-decoration-none"
										href="${pageContext.request.contextPath}/vaccine/list"> <span
										class="ml-2">Vaccine List</span>
									</a>
								</div>
								<div class="ml-4 mt-2 text-sub">
									<a class="text-reset text-decoration-none "
										href="${pageContext.request.contextPath}/vaccine/add"> <span
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
					class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">CREATE
					VACCINE</div>
					<%= request.getParameter("idUpdate")==null %>
				<div class="card mx-3">
					<div class="card-body">
					<c:if test="${request.getParameter('idUpdate')==null}">
						<form:form action="${pageContext.request.contextPath}/vaccine/add" method="post" modelAttribute="vaccineDto" id="formAdd" >
							<div class="form-row">
								<div class="form-group col-sm-8">
									<label class="font-weight-bold" for="vaccine-code">Vaccine
										Id <span class="text-danger">(*)</span>:
									</label>
									<form:input path="id" type="text" id="vaccine-id" placeholder="A123" class="form-control"/>
									<form:errors path="id" cssClass="error"/>
									<span class="error">${msgId}</span>

								</div>
								<div class="form-group col-sm-2 ml-2">
									<label class="font-weight-bold" for="vaccine-active">Active
										<span class="text-danger">(*)</span>:
									</label>
									<div class="form-inline mt-2">
										<i class="fa-solid fa-fill h5"></i>
										<form:checkbox path="status" class="form-check ml-4 checkbox-lg"
											id="vaccine-active" value="true" />
										
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="typecode">Vaccine
										Name <span class="text-danger">(*)</span>:
									</label>
									<form:input path="vaccineName" type="text" class="form-control"
										placeholder="Vaccine ABC" id="vaccine-name" />
									<form:errors path="vaccineName" cssClass="error">
									</form:errors>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="accine-type">Vaccine
										Type <span class="text-danger">(*)</span>:
									</label>
									<form:select class="form-control" id="vaccineType"
										path="vaccineType">
										<option label="--Select Vaccine Type" selected />
										<c:forEach items="${vaccineTypeList}" var="vaccineType">
											<option value="${vaccineType.id}"
												label="${vaccineType.vaccineTypeName}" />
										</c:forEach>
									</form:select>

								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold"
										for="vaccine-number-of-injection">Number of Injection:</label>
									<div class="form-inline">
										<form:input path="numberOfInjection" type="text" class="form-control"
											placeholder="Enter number" id="vaccine-number-of-injection"
											/>
											<form:errors path="numberOfInjection" cssClass="error"></form:errors>
									</div>
								</div>
							</div>
							<div class="form-row">

								<div class="form-group col-lg-4">
									<label class="font-weight-bold" for="vaccine-uasge">Usage:</label>
									<br>
									 <form:input path="usage" type="text" class="form-control-lg"
										placeholder="Mô tả sử dụng" id="vaccine-uasge" />
									<form:errors path="usage" cssClass="error"/>
								</div>
								<div class="form-group col-lg-4">
									<label class="font-weight-bold" for="vaccine-indication">Indication:</label>
									<br> <form:input path="indication" type="text" class="form-control-lg"
										placeholder="Mô tả chi tiết sử dụng" id="vaccine-indication"
										/>
								<form:errors path="indication" cssClass="error"/>
								</div>
								<div class="form-group col-lg-4">
									<label class="font-weight-bold" for="vaccine-contraindication">Contraindication
										</label> <br> 
										<form:input path="contraindication" type="text"
										class="form-control-lg"
										placeholder="Mô tả chi tiết chống định"
										id="vaccine-contraindication"/>
									<form:errors path="contraindication" cssClass="error"/>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-sm-4" id="col-time-begin">
									<label class="font-weight-bold"
										for="vaccine-time-next-injection">Time of beginning
										next injection:</label> <form:input path="timeBeginNextInjection" type="date" class="form-control"
										placeholder="01/01/2001" id="vaccine-time-next-injection"
										/>
										<form:errors path="timeBeginNextInjection" cssClass="error"/>
										<span class="error">${msgTime}</span>
										
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold"
										for="vaccine-time-end-injection">Time of endding next
										injection:</label> <form:input path="timeEndNextInjection" type="date" class="form-control"
										placeholder="Mô tả chi tiết sử dụng"
										id="vaccine-time-end-injection"/>
									<form:errors path="timeEndNextInjection" cssClass="error"/>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="typecode">Origin:</span>
										:
									</label> <form:input path="origin" type="text" class="form-control" placeholder="Vietnam"
										id="vaccine-origin"/>

								</div>
							</div>
							<div class="mt-5">
								<button type="submit" class="btn btn-sm btn-success" onclick="return submitValidate()">Submit</button>
								<button type="reset" class="btn btn-sm btn-primary ml-2">Reset</button>
								<a class="btn btn-sm btn-warning ml-2" href="${pageContext.request.contextPath}/vaccine/list">Cancel</a>
								<button type="button" class="btn btn-sm btn-primary ml-2" id="importVaccine">>Import Vaccine</button>
							</div>

						</form:form>
						<script src="${pageContext.request.contextPath}/js/CreateVaccine.js"></script>
						</c:if>
						
						<c:if test="${!request.getParameter('idUpdate').isEmpty() && request.getParameter('idUpdate')!=null}">
						<form:form action="${pageContext.request.contextPath}/vaccine/update" method="post" modelAttribute="vaccineDto" id="formAdd" >
							<div class="form-row">
								<div class="form-group col-sm-8">
									<label class="font-weight-bold" for="vaccine-code">Vaccine
										Id <span class="text-danger">(*)</span>:
									</label>
									<div>
									${vaccineDto.id}
									</div>
									<form:input path="id" id="vaccine-id" type="hidden" placeholder="123" class="form-control" onchange="onchangeId()"/>
									<form:errors path="id" cssClass="error"/>
									<span class="error">${msgId}</span>
								</div>
								<div class="form-group col-sm-2 ml-2">
									<label class="font-weight-bold" for="vaccine-active">Active
										<span class="text-danger">(*)</span>:
									</label>
									<div class="form-inline mt-2">
										<i class="fa-solid fa-fill h5"></i>
										<form:checkbox path="status" class="form-check ml-4 checkbox-lg"
											id="vaccine-active" value="true" />
										
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="typecode">Vaccine
										Name <span class="text-danger">(*)</span>:
									</label>
									<form:input path="vaccineName" type="text" class="form-control"
										placeholder="Vaccine ABC" id="vaccine-name" />
									<form:errors path="vaccineName" cssClass="error">
									</form:errors>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="accine-type">Vaccine
										Type <span class="text-danger">(*)</span>:
									</label>
									<form:select class="form-control" id="vaccineType"
										path="vaccineType">
										<option label="--Select Vaccine Type" selected />
										<c:forEach items="${vaccineTypeList}" var="vaccineType">
											<option value="${vaccineType.id}"
												label="${vaccineType.vaccineTypeName}" />
										</c:forEach>
									</form:select>

								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold"
										for="vaccine-number-of-injection">Number of Injection:</label>
									<div class="form-inline">
										<form:input path="numberOfInjection" type="text" class="form-control"
											placeholder="Enter number" id="vaccine-number-of-injection"
											/>
											<form:errors path="numberOfInjection" cssClass="error"></form:errors>
									</div>
								</div>
							</div>
							<div class="form-row">

								<div class="form-group col-lg-4">
									<label class="font-weight-bold" for="vaccine-uasge">Usage:</label>
									<br>
									 <form:input path="usage" type="text" class="form-control-lg"
										placeholder="Mô tả sử dụng" id="vaccine-uasge" />
									<form:errors path="usage" cssClass="error"/>
								</div>
								<div class="form-group col-lg-4">
									<label class="font-weight-bold" for="vaccine-indication">Indication:</label>
									<br> <form:input path="indication" type="text" class="form-control-lg"
										placeholder="Mô tả chi tiết sử dụng" id="vaccine-indication"
										/>
								<form:errors path="indication" cssClass="error"/>
								</div>
								<div class="form-group col-lg-4">
									<label class="font-weight-bold" for="vaccine-contraindication">Contraindication
										</label> <br> 
										<form:input path="contraindication" type="text"
										class="form-control-lg"
										placeholder="Mô tả chi tiết chống định"
										id="vaccine-contraindication"/>
									<form:errors path="contraindication" cssClass="error"/>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-sm-4" id = "col-time-begin">
									<label class="font-weight-bold"
										for="vaccine-time-next-injection">Time of beginning
										next injection:</label> <form:input path="timeBeginNextInjection" type="date" class="form-control"
										placeholder="01/01/2001" id="vaccine-time-next-injection"
										/>
										<form:errors path="timeBeginNextInjection" cssClass="error"/>
										<span class="error">${msgTime}</span>
										<span class="error">Time begin is before time end</span>
								</div>
								<div class="form-group col-sm-4" >
									<label class="font-weight-bold"
										for="vaccine-time-end-injection">Time of endding next
										injection:</label> <form:input path="timeEndNextInjection" type="date" class="form-control"
										placeholder="Mô tả chi tiết sử dụng"
										id="vaccine-time-end-injection"/>
									<form:errors path="timeEndNextInjection" cssClass="error"/>
								</div>
								<div class="form-group col-sm-4">
									<label class="font-weight-bold" for="typecode">Origin:</span>
										:
									</label> <form:input path="origin" type="text" class="form-control" placeholder="Vietnam"
										id="vaccine-origin"/>

								</div>
							</div>
							<div class="mt-5">
								<button type="submit" class="btn btn-sm btn-success" onclick="return submitValidate()">Submit</button>
								<button type="reset" class="btn btn-sm btn-primary ml-2">Reset</button>
								<a class="btn btn-sm btn-warning ml-2" href="#">Cancel</a>
							</div>

						</form:form>
					<script src="${pageContext.request.contextPath}/js/UpdateVaccine.js"></script>
					</c:if>
					</div>
				</div>
			</div>

		</div>
	</div>
	
	
	
		
</body>
</html>