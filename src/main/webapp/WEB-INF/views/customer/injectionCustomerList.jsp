<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<link rel="stylesheet" href="../../../asserts/css/DataTables.css">
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Customer.css">
    <div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">INJECTION CUSTOMER LIST</div>
    <div class="card mx-3 shadow">
    <span class="msg ml-2 mt-2">${msg}</span>
        <div class="card-body m-3">
            <div class="mt-3">
                <table class="table table-bordered table-striped" id="table-IC">
                    <thead>
                    <tr class="bg-info text-white text-center">
                        <td><input class="form-check mx-auto" type="checkbox" id="checkAll"></td>
                        <th>Full Name</th>
                        <th>Date of Birth</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Identity Card</th>
                        <th>Phone</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${injectionCustomerList}" var="result">
                        <tr>
                            <td><input class="form-check mx-auto" type="checkbox" value="${result.id}" name="id"></td>
                            <td>${result.fullName}</td>
                            <td>${result.dateOfBirth}</td>
                            <td>
                                <c:if test="${result.gender ==0}">Male</c:if>
                                <c:if test="${result.gender ==1}">Female</c:if>
                            </td>
                            <td>${result.address}</td>
                            <td>${result.identityCard}</td>
                            <td>${result.phone}</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="h5 text-right text-danger">${error}</div>

            <div class="">
                <button class="btn btn-success mr-1" type="submit"><a href="${pageContext.request.contextPath}/customer/add" class="text-white text-decoration-none">Register</a></button>
                <button class="btn btn-warning mr-1 text-white" type="submit" id="update-button">Update Customer</button>
                <button class="btn btn-danger" type="submit" id="delete-button">Delete Customer</button>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/js/CustomerCreate.js"></script>
<script src="${pageContext.request.contextPath}/js/DataTable.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
        integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>