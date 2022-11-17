<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
            integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="../../asserts/css/style.css">
    <title>List</title>

</head>
<body>
<div class="container-fluid ">
            <div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">Injection Customer List</div>
            <div class="card mx-3">
                <div class="card-body">

                    <div class="mt-3">
                        <table class="table table-bordered" id="table-IC">
                            <thead>
                            <tr class="bg-info text-white text-center">
                                <td><input class="form-check mx-auto" type="checkbox" id="checkAll"></td>
                                <th>Full Name</th>
                                <th>Date of Birth</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>Identity Card</th>
                                <th>Phone</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${injectionCustomerList}" var="result">
                                <tr>
                                    <td><input class="form-check mx-auto" type="checkbox" value="${result.id}" name="id"></td>
                                    <td>${result.fullName}</td>
                                    <td>${result.dateOfBirth}</td>
                                    <td>
                                        <c:if test="${result.gender ==0}">
                                        Male</c:if>
                                        <c:if test="${result.gender ==1}">
                                        Female</c:if>
                                    </td>
                                    <td>${result.address}</td>
                                    <td>${result.identityCard}</td>
                                    <td>${result.phone}</td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="h5 text-right text-danger">${error}</div>

                    <div class="">
                        <button class="btn btn-success mr-1" type="submit"><a href="${pageContext.request.contextPath}/customer/registerCustomer" class="text-white text-decoration-none">Register</a></button>
                        <button class="btn btn-warning mr-1 text-white" type="submit" id="update-button">Update Customer</button>
                        <button class="btn btn-danger" type="submit" id="delete-button">Delete Customer</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../asserts/js/CustomerCreate.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
        integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>