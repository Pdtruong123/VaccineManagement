<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Injection ADD</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans|Sofia|Trirong">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
            integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="../../asserts/css/style.css">
</head>
<body>
<div class="container-fluid ">
    <nav class="row topnavbar py-1">
        <a href="index.html" class="navbar-brand ml-3 mr-auto"><img class="img" src="../../asserts/img/logo.png"></a>
    </nav>
    <div class="row">
        <div class="col-sm-3 border-right left" id="accordion">
            <div class="list-group list-group-flush">
                <div class="list-group-item text-white profile">
                    <div><img class="img-admin" src="../../asserts/img/admin.png"></div>
                    <div class="mt-1">Admin</div>
                    <div class="mt-1">admin@fsoft.com.vn</div>
                </div>
                <div class="menu">
                    <div class="list-group-item text font-weight-bold act">Home</div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#employee">
                            <div class="col-sm-10 font-weight-bold ">Employee Management</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="employee" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Employee List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Create Employee</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#customer">
                            <div class="col-sm-10 font-weight-bold ">Customer Management</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="customer" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Customer List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Create Customer</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#vaccineType">
                            <div class="col-sm-10 font-weight-bold ">Vaccine Type Management</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="vaccineType" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none" href="#">
                                    <span class="ml-2">Vaccine Type List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none" href="#">
                                    <span class="ml-2">Vaccine Type Employee</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#vaccine">
                            <div class="col-sm-10 font-weight-bold ">Vaccine Management</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="vaccine" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none" href="#">
                                    <span class="ml-2">Vaccine List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Create Vaccine</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#inject">
                            <div class="col-sm-10 font-weight-bold ">Injection Schedule</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="inject" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Injection Schedule List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Create Injection Schedule</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#injectResult">
                            <div class="col-sm-10 font-weight-bold ">Injection Result</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="injectResult" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none" href="#">
                                    <span class="ml-2">Injection Result List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Create Injection Result</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#news">
                            <div class="col-sm-10 font-weight-bold ">News</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="news" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">News List</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Create News</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item">
                        <div class="row text act" data-toggle="collapse" data-target="#report">
                            <div class="col-sm-10 font-weight-bold ">Report</div>
                            <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
                        </div>
                        <div class="mt-3 collapse" id="report" data-parent="#accordion">
                            <div class="ml-4 text-sub">
                                <a class="text-reset text-decoration-none " href="#">
                                    <span class="ml-2">Report Customer</span>
                                </a>
                            </div>
                            <div class="ml-4 mt-2 text-sub">
                                <a class="text-reset text-decoration-none" href="#">
                                    <span class="ml-2">Report Vaccine</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

        </div>
        <div class="col-sm-9 bg-light right">
            <div class="card">
                <div class="head-title card-header">
                    <h4 class="text-center">CREATE INJECTION SCHEDULE</h4>
                </div>
                <form:form modelAttribute="injection" action="${pageContext.request.contextPath}/injection" method="post">
                    <div class="card-body">
                        <div class="mt-1 row">
                            <div class="col-sm-4">
                                <label>Vaccine</label><label class="lbls">(*)</label>
                                <select name="vaccineID" class="form-control">
                                    <c:forEach items="${listVaccine}" var="listvaccine">
                                        <option value="${listvaccine.id}">${listvaccine.vaccineName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-4">
                                <label>From</label><label class="lbls">(*)</label>
                                <form:input path="startDate" type="date" class="form-control"/>
                            </div>
                            <div class="col-sm-4">
                                <label>To</label><label class="lbls">(*)</label>
                                <form:input path="endDate" type="date" class="form-control"/>
                            </div>
                        </div>
                        <div class="mt-2 row">
                            <div class="col-sm-5">
                                <label>Place</label><label class="lbls">(*)</label>
                                <form:textarea path="place" class="form-control"></form:textarea>
                            </div>
                            <div class="col-sm-7">
                                <label>Note:</label>
                                <form:textarea path="note" class="form-control"></form:textarea>
                            </div>

                        </div>
                        <div class="pt-3">
                            <button type="submit" id="btnSubmit" class="btn btn-primary">Save</button>
                            <button type="submit" class="btn btn-danger ml-4">Reset</button>
                            <button type="reset" class="btn btn-warning ml-4">Cancle</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>

    </div>

</div>
</div>
</body>
</html>