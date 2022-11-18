<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/DataTables.css">
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<script src="${pageContext.request.contextPath}/js/Report.js"></script>

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
                                       id="beginDate" value=${param.timeBeginNextInjection}>
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
                        <label class="font-weight-bold" for="origin">Origin: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter origin" id="origin"
                                   name="origin" value="${param.origin}"/>
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">Vaccine Type: </label>
                        <div>
                            <select class="form-control" id="" name="vaccineType">
                                <option label="--Select Vaccine Type" value="" selected/>
                                <c:forEach items="${vaccineTypeList}" var="vaccineType">
                                    <option value="${vaccineType.id}" label="${vaccineType.vaccineTypeName}"/>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 ml-5">
                        <label class="font-weight-bold ml-2" for="">Action: </label>
                        <div class="form-inline">
                            <button type="reset"  class="btn btn-primary ml-2">Reset</button>
                            <button type="submit" class="btn btn-primary ml-3">Filter</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>

        <div class="mt-4 report" >
            <table class="table table-bordered table-striped" id="table-report">
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
                <c:forEach items="${vaccineList}" var="result" varStatus="loop">
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

    </div>
</div>

