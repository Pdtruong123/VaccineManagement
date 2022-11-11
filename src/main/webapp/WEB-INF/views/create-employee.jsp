<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="../../asserts/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/employee.css">
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
                                <a class="text-reset text-decoration-none"
                                   href="${pageContext.request.contextPath}/injection-result-list">
                                    <span class="ml-2">Injection Result List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none "
                                   href="${pageContext.request.contextPath}/add/injection-result">
                                    <span class="ml-2">Create Injection Result</span>
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
        <body>
        <div class="h4 text-success font-weight-bold ml-3">${success}</div>

        <h1 class="text-center">CREATE EMPLOYEE</h1>
        <form:form action="${pageContext.request.contextPath}/add/employee"
                   method="post" modelAttribute="employee" id="employee-form">

        <div class="row m-4">

            <div class="col form-group">
                <i class="fa-solid fa-user"></i> <label for="id"><strong>Employee
                id:</strong></label>
                <form:input type="text" class="form-control"
                            placeholder="00126192" id="id" path="id" value="${Employee.id}" />
            </div>

            <div class="col form-group">
                <label for="name"><strong>Employee name:</strong></label>
                <form:input type="text" class="form-control"
                            placeholder="Nguyen Van A" id="name" path="employeeName"
                            value="${Employee.name}" />
            </div>

            <div class="col form-group">
                <label class="form-label"><strong>Gender:</strong></label> <br>
                <div class="form-check form-check-inline">
                    <input type="radio" class="form-check-input" name="gender" checked>
                    <label class="form-check-label">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" class="form-check-input" name="gender">
                    <label class="form-check-label">Female</label>
                </div>

            </div>

        </div>
        <div class="row m-4">
            <div class="col form-group">
                <label for="DoB"><strong>Date of Birth:</strong></label>
                <form:input type="date" class="form-control"
                            placeholder="12/12/1999" id="DoB" path="dateOfBirth"
                            value="${Employee.DoB}" />
            </div>
            <div class="col form-group">
                <label for="phone"><strong>Phone:</strong></label>
                <form:input type="phone" class="form-control"
                            placeholder="Doctor" id="phone" path="phone"
                            value="${Employee.phone}" />
            </div>

            <div class="col form-group">
                <label for="id"><strong>Address:</strong></label>
                <form:input type="text" class="form-control"
                            placeholder="17 Duy Tan" id="address" path="address"
                            value="${Employee.address}" />
            </div>
        </div>

        <div class="row m-4">

            <div class="col form-group">
                <label for="email"><strong>Email:</strong></label>
                <form:input type="email" class="form-control"
                            placeholder="nguyena@email.com" id="email" path="email"
                            value="${Employee.email}" />
            </div>

            <div class="col form-group">
                <label for="place"><strong>Working Place:</strong></label>
                <form:input type="text" class="form-control"
                            placeholder="Hong Ngoc" id="place" path="workingPlace"
                            value="${Employee.workingPlace}" />
            </div>

            <div class="col form-group">
                <label for="position"><strong>Position:</strong></label>
                <form:input type="text" class="form-control" placeholder="Doctor"
                            id="position" path="position" value="${Employee.position}" />
            </div>

        </div>
        <div class="col form-group">
            <label class="font-weight-bold">Image :</label>
            <div class="file-upload">
                <div class="file-select">

                    <input type="file" name="chooseFile" id="chooseFile">
                </div>
            </div>
        </div>
        <div class="img-upload">
            <img id="img-preview" src="../../asserts/img/admin.png" />
        </div>
    </div>
</div>
<div class="form-button">
    <button class="btn btn-success" type="submit">Save</button>
    <button class="btn btn-primary" type="reset">Reset</button>
    <button class="btn btn-warning text-white" type="submit">
        <a href="${pageContext.request.contextPath}/employee-list"
           class="text-white text-decoration-none">Cancel</a>
    </button>
</div>
</form:form>


</body>
</html>