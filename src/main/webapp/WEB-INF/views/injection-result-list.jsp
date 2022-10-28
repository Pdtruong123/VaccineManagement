<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Injection Result List</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/reseter.css/1.0.8/reseter.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/InjectionResultList.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>

<h1 class="text-center">Injection Result List</h1>
<div class="dropdown">

    <button type="button" data-toggle="dropdown">
        show
    </button>
    <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
    </div>
</div>
<table class="table table-striped table-bordered text-center" id="table-IR">
    <thead class="table-thead">
    <tr>
        <th><input type="checkbox" id="checkAll"></th>
        <th>Customer</th>
        <th>Vaccine Name</th>
        <th>Prevention</th>
        <th>Injection</th>
        <th>Date of inject</th>
        <th>Next inject date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${injectionResultList.content}" var="result">
    <tr>
        <td><input type="checkbox" value="${result.id}" name="id"></td>
        <td>${result.id}</td>
        <td>${result.vaccine.vaccineName}</td>
        <td>${result.prevention}</td>
        <td>${result.numberOfInjection}</td>
        <td>${result.injectionDate}</td>
        <td>${result.nextInjectionDate}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example" class="navbar-pagination">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="/injection-result-list?p=${injectionResultList.number - 1}" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
        </a></li>
        <li class="page-item"><a class="page-link" href="/injection-result-list?p=0">1</a></li>
        <li class="page-item"><a class="page-link" href="/injection-result-list?p=1">2</a></li>
        <li class="page-item"><a class="page-link" href="/injection-result-list?p=${injectionResultList.number + 1}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
        </a></li>
    </ul>
</nav>
<div class="list-button">
    <button class="btn btn-success" type="submit"><a href="${pageContext.request.contextPath}/add/injection-result" class="text-white">Create Injection Result</a></button>
    <button class="btn btn-warning" type="submit" ><a href="${pageContext.request.contextPath}/update/injection-result" class="text-white">Update Injection Result</a></button>
    <button class="btn btn-danger" type="submit" id="delete-button">Delete Injection Result</button>
</div>
<script src="${pageContext.request.contextPath}/js/DeleteInjectionResult.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>