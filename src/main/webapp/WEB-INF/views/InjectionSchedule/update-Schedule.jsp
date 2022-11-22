<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="card shadow">
    <div class="head-title card-header">
        <h1 class="h5 mt-3 text-center text-dark font-weight-bold mb-3">UPDATE INJECTION SCHEDULE</h1>
    </div>
    <form:form id="form-update" action="${pageContext.request.contextPath}/injectionSchedule/update" method="POST" modelAttribute="updateSchedule">
        <div class="card-body">
            <div class="mt-1 row">
                <form:input path="id" type="hidden"/>
                <form:input path="vaccine.id" type="hidden"/>
                <div class="col-sm-4">
                    <label class="font-weight-bold">Vaccine<span class="lbls text-danger"> (*)</span></label>
                    <form:input class="form-control" disabled="true" path="vaccine.vaccineName"/>
                </div>
                <div class="col-sm-4">
                    <label class="font-weight-bold">From<span class="lbls text-danger"> (*)</span></label>
                    <form:input path="startDate" type="date" class="form-control"/>
                    <form:errors path="startDate"/>
                </div>
                <div class="col-sm-4">
                    <label class="font-weight-bold">To<span class="lbls text-danger"> (*)</span></label>
                    <form:input path="endDate" type="date" class="form-control endDate"/>
                    <form:errors path="endDate"/>
                </div>
            </div>
            <div class="mt-2 row">
                <div class="col-sm-5">
                    <label class="font-weight-bold">Place<span class="lbls text-danger"> (*)</span></label>
                    <form:textarea path="place" class="form-control place"/>
                    <form:errors path="place"/>
                </div>
                <div class="col-sm-7">
                    <label class="font-weight-bold">Note:</label>
                    <form:textarea path="description" class="form-control note"/>
                    <form:errors path="description"/>
                </div>

            </div>
            <div class="pt-3">
                <button type="submit" id="btnSave" class="btn btn-primary">Save</button>
                <button type="reset" class="btn btn-danger ml-4">Reset</button>
                <button type="submit" class="btn btn-warning ml-4"><a href="${pageContext.request.contextPath}/injection-schedule/list">Cancle</a>
                </button>
            </div>
        </div>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/js/ValidatorInjectionSchedule.js"></script>