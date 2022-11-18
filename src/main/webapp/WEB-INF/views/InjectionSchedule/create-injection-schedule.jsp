<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <h1 class="text-center">CREATE INJECTION SCHEDULE</h1>
    <div class="h4 text-success font-weight-bold ml-3">${successAdd}</div>
<div class="card mx-3 shadow">
    <div class="card-body">
    <form:form id="form-injectionSchedule" action="${pageContext.request.contextPath}/injectionSchedule/add" method="POST" modelAttribute="injection">
        <div class="card-body">
            <div class="mt-1 row">
                <div class="col-sm-4">
                    <label>Vaccine</label><label class="lbls">(*)</label>
                    <form:select path="vaccineID" class="form-control">
                        <c:forEach items="${listVaccine}" var="listvaccine">
                            <option id="vaccineID" name="vaccineID"
                                    value="${listvaccine.id}">${listvaccine.vaccineName}</option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="col-sm-4">
                    <label>From</label><label class="lbls">(*)</label>
                    <form:input path="startDate" type="date" id="startDate" class="form-control"/>
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
                <button type="button" class="btn btn-warning ml-4"><a href="${pageContext.request.contextPath}/injection-schedule/list">Cancle</a>
                </button>
            </div>
        </div>
    </form:form>
</div>
</div>
<script src="${pageContext.request.contextPath}/js/ValidatorInjectionSchedule.js"></script>
