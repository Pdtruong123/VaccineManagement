<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REPORT INJECTION RESULT</div>
<div class="card mx-3">
    <div class="card-body shadow">
        <div class="border-bottom">
            <form class="mb-3" action="${pageContext.request.contextPath}/search/report/injection-result" method="post">
                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">Display Type: </label>
                        <div class="mt-2">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                                       value="option1" checked>
                                <label class="form-check-label" for="inlineRadio1">Report</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                                       value="option2">
                                <label class="form-check-label" for="inlineRadio2">Chart</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="font-weight-bold" for="">Inject Date: </label>
                        <div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="inlineRadio1">From:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="startDate"
                                       id="startDate" value="option1">
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="inlineRadio2">To:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="endDate"
                                       id="endDate" value="option2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-row mt-2">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="prevention">Prevention: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter prevention" id="prevention"
                                   name="prevention" value="${param.prevention}"/>
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">VaccineType: </label>
                        <div>
                            <select class="form-control" id="vaccineName" name="vaccine">
                                <option label="--Select Vaccine Type" value="" selected/>
                                <c:forEach items="${vaccineList}" var="vaccines">
                                    <option value="${vaccines.vaccineName}" label="${vaccines.vaccineName}"/>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 ml-5">
                        <label class="font-weight-bold ml-2" for="">Action: </label>
                        <div class="form-inline">
                            <button type="reset" class="btn btn-primary ml-2">Reset</button>
                            <button type="submit" class="btn btn-primary ml-3">Filter</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>


        <div class="mt-4">
            <table class="table table-bordered table-striped">
                <thead>
                <tr class="bg-info text-white text-center">
                    <th>No.</th>
                    <th>Vaccine</th>
                    <th>Prevention</th>
                    <th>Customer Name</th>
                    <th>Date of Inject</th>
                    <th>Num of Inject</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${injectionResultList.content}" var="injection" varStatus="loop">
                    <%! int count = 1; %>
                    <tr>
                        <td>${loop.count}</td>
                        <td>${injection.vaccine.vaccineName}</td>
                        <td>${injection.prevention}</td>
                        <td>${injection.customer.fullName}</td>
                        <td>${injection.injectionDate}</td>
                        <td>${injection.numberOfInjection}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3">
                <span>Showing ${firstElement} to ${lastElement} of ${injectionResultList.totalElements} entities</span>
            </div>
            <div class="col-sm-6"></div>
            <div class="col-sm-3">
                <nav aria-label="Page">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link pagination-list" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/injection-result?p=0">1</a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/injection-result?p=1">2</a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/injection-result?p=2">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link pagination-list" href="#" aria-label="Next">
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

<script src="${pageContext.request.contextPath}/js/ChartConvertReport.js"></script>
