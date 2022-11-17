<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
    <link rel="stylesheet" href="../../../asserts/css/style.css">
    <link rel="stylesheet" href="../../../asserts/css/DataTables.css">
</head>
<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">Injection Result List</div>
<div class="h4 text-success font-weight-bold ml-3">${success}</div>
<div class="card mx-3 shadow">
    <div class="card-body">
        <div class="mt-3">
            <table class="table table-bordered" id="table-IR">
                <thead>
                <tr class="bg-info text-white text-center">
                    <td><input class="form-check mx-auto" type="checkbox" id="checkAll"></td>
                    <th>Customer</th>
                    <th>Vaccine Name</th>
                    <th>Prevention</th>
                    <th>Injection</th>
                    <th>Date Of Injection</th>
                    <th>Next Injection Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${injectionResultList}" var="result">
                    <tr>
                        <td><input class="form-check mx-auto" type="checkbox" value="${result.id}" name="id"></td>
                        <td>${result.id}-${result.customer.fullName}-${result.customer.dateOfBirth}</td>
                        <td>${result.vaccine.vaccineName}</td>
                        <td>${result.prevention}</td>
                        <td>${result.numberOfInjection}</td>
                        <td>${result.injectionDate}</td>
                        <td>${result.nextInjectionDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="h5 text-right text-danger">${error}</div>
        <div class="">
            <button class="btn btn-success mr-1" type="submit"><a
                    href="${pageContext.request.contextPath}/injection-result/add"
                    class="text-white text-decoration-none">Create Injection Result</a></button>
            <button class="btn btn-warning mr-1 text-white" type="submit" id="update-button">Update Injection Result
            </button>
            <button class="btn btn-danger" type="submit" id="delete-button">Delete Injection Result</button>
        </div>
    </div>
</div>
</div>
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<script src="${pageContext.request.contextPath}/js/DeleteInjectionResult.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
