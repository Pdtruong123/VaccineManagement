<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REPORT VACCINE</div>
<div class="card mx-3">
    <div class="card-body shadow">
        <div class="border-bottom">
            <form class="mb-3" action="${pageContext.request.contextPath}/search/report/vaccine" method="post">
                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">Display Type: </label>
                        <div class="mt-2">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3"
                                       value="option1" checked>
                                <label class="form-check-label" for="inlineRadio3">Report</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4"
                                       value="option2">
                                <label class="form-check-label" for="inlineRadio4">Chart</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="font-weight-bold" for="">Next Injection Date: </label>
                        <div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="beginDate">Begin:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="timeBeginNextInjection"
                                       id="beginDate" value="option1">
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="endDate">End:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="timeEndNextInjection"
                                       id="endDate" value="option2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-row mt-2">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">VaccineType: </label>
                        <div>
                            <select class="form-control" id="" name="vaccineType">
                                <option label="--Select Vaccine Type" value="" selected/>
                                <c:forEach items="${vaccineTypeList}" var="vaccineType">
                                    <option value="${vaccineType.id}" label="${vaccineType.vaccineTypeName}"/>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="origin">Origin: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter origin" id="origin"
                                   name="origin" value="${param.origin}"/>
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
                    <th>Vaccine Name</th>
                    <th>Vaccine Type</th>
                    <th>Num of Inject</th>
                    <th>Begin Next Inject Date</th>
                    <th>End Next Inject Date</th>
                    <th>Origin</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vaccineList.content}" var="result" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${result.vaccineName}</td>
                        <td>${result.vaccineType.vaccineTypeName}</td>
                        <td>${result.numberOfInjection}</td>
                        <td>${result.timeBeginNextInjection}</td>
                        <td>${result.timeEndNextInjection}</td>
                        <td>${result.origin}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3">
                <span>Showing ${firstElement} to ${lastElement} of ${vaccineList.totalElements} entities</span>
            </div>
            <div class="col-sm-6"></div>
            <div class="col-sm-3">
                <nav aria-label="Page">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link pagination-list" href="${pageContext.request.contextPath}/report/vaccine/list?p=${vaccineList.number - 1}&size=${vaccineList.size}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/vaccine?p=0">1</a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/vaccine?p=1">2</a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list"
                                                 href="${pageContext.request.contextPath}/report/vaccine?p=2">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link pagination-list" href="${pageContext.request.contextPath}/report/vaccine/list?p=${vaccineList.number + 1}&size=${vaccineList.size}" aria-label="Next">
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
