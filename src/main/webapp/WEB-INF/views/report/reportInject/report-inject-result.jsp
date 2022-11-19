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

<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">REPORT INJECTION RESULT</div>
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
                                    <option value="${vaccines.id}" label="${vaccines.vaccineName}"/>
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


        <div class="mt-4 report">
            <table class="table table-bordered table-striped" id="table-report">
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
                <c:forEach items="${injectionResultList}" var="injection" varStatus="loop">
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

    </div>
</div>

