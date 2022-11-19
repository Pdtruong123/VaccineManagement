<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<head>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
    <link rel="stylesheet" href="../../../asserts/css/style.css">
    <link rel="stylesheet" href="../../../asserts/css/DataTables.css">
</head>
<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">INJECTION SCHEDULE</div>
    <div class="card mx-3 shadow">
        <div class="card-body">
            <div class="mt-3">
                <table class="table table-bordered" id="table-TS">
                    <thead>
                    <tr class="bg-info text-white text-center">
                        <th>Vaccine</th>
                        <th>Time</th>
                        <th>Place</th>
                        <th>Status</th>
                        <th>Note</th>
                    </tr>
                    </thead>
                   <tbody>
                   <c:forEach items="${listSchedule}" var="schedule">
                       <tr>
                           <td><a href="${pageContext.request.contextPath}/injectionSchedule/update?id=${schedule.id}">${schedule.vaccine.vaccineName}</a></td>
                           <td>From ${schedule.startDate} to ${schedule.endDate}</td>
                           <td>${schedule.place}</td>
                           <td>${schedule.status}</td>
                           <td>${schedule.description}</td>
                       </tr>
                   </c:forEach>
                </tbody>
                </table>
            </div>
             <security:authorize access="hasAuthority('ADMIN')">
            <div class="">
                <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/injectionSchedule/add">New Injection Schedule</a>
            </div>
            </security:authorize>
        </div>
    </div>
<%--<script src="${pageContext.request.contextPath}/js/InjectionScheduleApi.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
