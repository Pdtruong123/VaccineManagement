<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<script src="${pageContext.request.contextPath}/js/VaccineType.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/DataTables.css">
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>

<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">VACCINE TYPE LIST</div>
<div class="card mx-3 shadow">
    <div class="card-body">
        <div class="mt-3">
            <table class="table table-bordered table-striped" id="table-IR">
                <thead>
                <tr class="bg-info text-white text-center">
                    <th><input class="form-check mx-auto" type="checkbox" id="checkAll"></th>
                    <th>Code</th>
                    <th>Vaccine Type Name</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                            <c:forEach items="${vaccineTypeList}" var="element" varStatus="status">
                            <tr>
                                <td><input class="form-check mx-auto" type="checkbox" name="ids" value="${element.id}"></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/vaccineType/update/${element.id}">${element.id}</a>

                                </td>
                                <td>${element.vaccineTypeName}</td>
                                <td >${element.description}</td>
								<c:choose>
									<c:when test="${element.vaccineTypeStatus}">
										<td>Active</td>
									</c:when>
									<c:otherwise>
										<td>In-Active</td>
									</c:otherwise>
								</c:choose>
                            </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="">
                        <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/vaccineType/add">New Vaccine Type</a>
                        <a class="btn btn-sm btn-warning ml-2" id="in-active" >Make In-Active</a>
                    </div>
                </div>
            </div>




