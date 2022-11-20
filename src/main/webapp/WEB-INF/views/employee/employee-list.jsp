<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<script src="${pageContext.request.contextPath}/js/VaccineType.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/DataTables.css">
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">EMPLOYEE LIST</div>
<div class="text-success font-weight-bold ml-3">${success}</div>
<div class="card mx-3 shadow">
    <div class="card-body">
                    <div class="mt-3">
                        <table class="table table-bordered" id="employee-tb">
                            <thead>
                            <tr class="bg-info text-white text-center ">
                                <th><input type="checkbox" id="checkAll"></th>
                                <th>Employee ID</th>
                                <th>Employee Name</th>
                                <th>Date Of Birth</th>
                                <th>Gender</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Image</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${employeeList}" var="result">
                                <tr>
                                    <td><input type="checkbox" value="${result.id}" name="id"></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/employee/update/${result.id}">${result.id}</a>
                                    </td>
                                    <td>${result.employeeName}</td>
                                    <td>${result.dateOfBirth}</td>

                                    <td>
                                        <c:if test="${result.gender ==0}">
                                            <p>Male</p></c:if>
                                        <c:if test="${result.gender ==1}">
                                            <p>Female</p></c:if>
                                    </td>


                                    <td>${result.phone}</td>
                                    <td>${result.address}</td>
                                    <td>
                                    <img id="img-employee"
                             				src="${pageContext.request.contextPath}/img/imgemployee/${result.imageUrl}"/>
                             </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="h5 text-right text-danger">${error}</div>
                    </div>
                    <div class="mb-4 ml-4">
                        <button class="btn btn-success mr-1" type="submit"><a
                                href="${pageContext.request.contextPath}/employee/add"
                                class="text-white text-decoration-none">New Employee</a></button>
                        <button class="btn btn-warning mr-1 text-white" type="submit" id="update-button">Update
                            Employee
                        </button>
                        <button class="btn btn-danger" type="submit" id="delete-button">Delete Employee</button>
                    </div>
                </div>
<script src="${pageContext.request.contextPath}/js/DeleteEmployee.js"></script>
