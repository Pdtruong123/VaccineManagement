<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
            integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="../../../asserts/css/style.css">
    <title>List</title>

</head>
<body>
<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">Injection Result List</div>
<div class="h4 text-success font-weight-bold ml-3">${success}</div>
<div class="card mx-3">
    <div class="card-body">
        <div class="row">
            <div class="col-sm-3 form-inline">
                <span>Show</span>
                <select class="form-select mx-2 border-right-0 border-top-0 border-left-0" id="inlineFormCustomSelect"
                        name="showNumberList" onchange="location = this.value;this.option = selected">
                    <option selected></option>
                    <option value="${pageContext.request.contextPath}/injection-result-list?size=5&search=${keyword}">
                        5
                    </option>
                    <option value="${pageContext.request.contextPath}/injection-result-list?size=10&search=${keyword}">
                        10
                    </option>
                    <option value="${pageContext.request.contextPath}/injection-result-list?size=15&search=${keyword}">
                        15
                    </option>
                </select>
                <span>entities</span>
            </div>
            <div class="col-sm-6"></div>
            <div class="col-sm-3">
                <form action="${pageContext.request.contextPath}/search/injection-result" method="post">
                    <div class="input-group ">
                        <input id="searchInput" type="search"
                               class="form-control border-right-0 border-top-0 border-left-0 form-select"
                               placeholder="Search" aria-label="Search" aria-describedby="search-addon"
                               name="searchInjectionResult"/>
                        <button type="submit" class="input-group-text border-0 bg-white" id="search-addon">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
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
                <c:forEach items="${injectionResultList.content}" var="result">
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
        <div class="row mt-4">
            <div class="col-sm-3">
                <span>Showing ${firstElement} to ${lastElement} of ${injectionResultList.totalElements} entities</span>
            </div>
            <div class="col-sm-6"></div>
            <div class="col-sm-3">
                <nav aria-label="Page">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link pagination-list"
                               href="/injection-result-list?p=${injectionResultList.number -1}&search=${keyword}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="/injection-result-list?p=0&search=${keyword}">1</a></li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="/injection-result-list?p=1&search=${keyword}">2</a></li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="/injection-result-list?p=2&search=${keyword}">3</a></li>
                        <li class="page-item">
                            <a class="page-link pagination-list"
                               href="/injection-result-list?p=${injectionResultList.number +1}&search=${keyword}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="">
            <button class="btn btn-success mr-1" type="submit"><a
                    href="${pageContext.request.contextPath}/add/injection-result"
                    class="text-white text-decoration-none">Create Injection Result</a></button>
            <button class="btn btn-warning mr-1 text-white" type="submit" id="update-button">Update Injection Result
            </button>
            <button class="btn btn-danger" type="submit" id="delete-button">Delete Injection Result</button>
        </div>
    </div>
</div>
</div>

<script src="${pageContext.request.contextPath}/js/DeleteInjectionResult.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>