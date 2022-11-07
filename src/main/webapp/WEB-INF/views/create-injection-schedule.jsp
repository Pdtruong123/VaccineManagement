<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <div class="card">
                <div class="head-title card-header">
                    <h4 class="text-center">CREATE INJECTION SCHEDULE</h4>
                </div>
                <form id="form-injectionSchedule">
                    <div class="card-body">
                        <div class="mt-1 row">
                            <div class="col-sm-4">
                                <label>Vaccine</label><label class="lbls">(*)</label>
                                <select id="vaccineID" class="form-control">
                                    <c:forEach items="${listVaccine}" var="listvaccine">
                                        <option name="vaccineID" value="${listvaccine.id}">${listvaccine.vaccineName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-4">
                                <label>From</label><label class="lbls">(*)</label>
                                <input type="date" name="startDate" class="form-control"/>
                            </div>
                            <div class="col-sm-4">
                                <label>To</label><label class="lbls">(*)</label>
                                <input type="date" name="endDate" class="form-control"/>
                            </div>
                        </div>
                        <div class="mt-2 row">
                            <div class="col-sm-5">
                                <label>Place</label><label class="lbls">(*)</label>
                                <textarea name="place" class="form-control"></textarea>
                            </div>
                            <div class="col-sm-7">
                                <label>Note:</label>
                                <textarea name="note" class="form-control"></textarea>
                            </div>

                        </div>
                        <div class="pt-3">
                            <button id="btnSave" class="btn btn-primary">Save</button>
                            <button type="submit" class="btn btn-danger ml-4">Reset</button>
                            <button type="reset" class="btn btn-warning ml-4">Cancle</button>
                        </div>
                    </div>
                </form>
            </div>
<script src="${pageContext.request.contextPath}/js/ValidatorInjectionSchedule.js"></script>
<script src="${pageContext.request.contextPath}/js/InjectionScheduleApi.js"></script>
