<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="card shadow">
    <div class="head-title card-header">
        <h4 class="text-center">CREATE INJECTION SCHEDULE</h4>
    </div>
    <form:form id="form-update" action="${pageContext.request.contextPath}/update/injectionSchedule" method="POST" modelAttribute="updateSchedule">
        <div class="card-body">
            <div class="mt-1 row">
                <form:input path="id" type="hidden"/>
                <form:input path="vaccine.id" type="hidden"/>
                <div class="col-sm-4">
                    <label>Vaccine</label><label class="lbls">(*)</label>
                    <form:input class="form-control" disabled="true" path="vaccine.vaccineName"/>
                </div>
                <div class="col-sm-4">
                    <label>From</label><label class="lbls">(*)</label>
                    <form:input path="startDate" type="date" class="form-control"/>
                    <form:errors path="startDate"/>
                </div>
                <div class="col-sm-4">
                    <label>To</label><label class="lbls">(*)</label>
                    <form:input path="endDate" type="date" class="form-control endDate"/>
                    <form:errors path="endDate"/>
                </div>
            </div>
            <div class="mt-2 row">
                <div class="col-sm-5">
                    <label>Place</label><label class="lbls">(*)</label>
                    <form:textarea path="place" class="form-control place"/>
                    <form:errors path="place"/>
                </div>
                <div class="col-sm-7">
                    <label>Note:</label>
                    <form:textarea path="description" class="form-control note"/>
                    <form:errors path="description"/>
                </div>

            </div>
            <div class="pt-3">
                <button type="submit" id="btnSave" class="btn btn-primary">Save</button>
                <button type="reset" class="btn btn-danger ml-4">Reset</button>
                <button type="submit" class="btn btn-warning ml-4"><a href="${pageContext.request.contextPath}/lisst">Cancle</a>
                </button>
            </div>
        </div>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/js/ValidatorInjectionSchedule.js"></script>