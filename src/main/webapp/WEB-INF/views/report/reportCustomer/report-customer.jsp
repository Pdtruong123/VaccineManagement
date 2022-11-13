<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${pageContext.request.contextPath}/js/Report.js"></script>


<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REPORT CUSTOMER</div>
<div class="card mx-3 shadow">
    <div class="card-body">
        <div class="border-bottom">
            <form class="mb-3" action="${pageContext.request.contextPath}/search/report/customer" method="post">
                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">Display Type: </label>
                        <div class="mt-2">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio5"
                                       value="option1" checked>
                                <label class="form-check-label" for="inlineRadio1">Report</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio6"
                                       value="option2">
                                <label class="form-check-label" for="inlineRadio2">Chart</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="font-weight-bold" for="">Date of Birth: </label>
                        <div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="inlineRadio1">From:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="dOBFrom"
                                       id="inlineRadio1" value="option1">
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="inlineRadio2">To:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="dOBTo"
                                       id="inlineRadio2" value="option2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-row mt-2">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="fullName">Full Name: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter name" name="fullName" id="fullName">
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="address">Address: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter address" name="address" id="address">
                        </div>
                    </div>
                    <div class="form-group col-sm-3 ml-5">
                        <label class="font-weight-bold ml-2" for="">Action: </label>
                        <div class="form-inline">
                            <button type="reset" class="btn  btn-primary ml-2">Reset</button>
                            <button type="submit" class="btn  btn-primary ml-3">Filter</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>
        <div class="mt-4">
            <table class="table table-bordered table-striped">
                <thead>
                <tr class="bg-info text-white text-center">
                    <th>No</th>
                    <th>Full Name</th>
                    <th>Date of Birth</th>
                    <th>Address</th>
                    <th>Identity Card</th>
                    <th>Num of Inject</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customerList.content}" var="result" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${result.fullName}</td>
                        <td>${result.dateOfBirth}</td>
                        <td>${result.address}</td>
                        <td>${result.identityCard}</td>
                        <td>${result.injectionResults.numberOfInjection}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3">
                <span>Showing ${firstElement} to ${lastElement} of ${customerList.totalElements} entities</span>
            </div>
            <div class="col-sm-6"></div>
            <div class="col-sm-3">
                <nav aria-label="Page">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link pagination-list" href="${pageContext.request.contextPath}/report/customer?p=${customerList.number - 1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/customer?p=0">1</a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/customer?p=1">2</a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/customer?p=2">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link pagination-list" href="${pageContext.request.contextPath}/report/customer?p=${customerList.number + 1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
