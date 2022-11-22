<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Open+Sans|Sofia|Trirong">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
            integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="../../../asserts/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/InjectionResult.css">
</head>
<body>
<h1 class="h5 mt-3 text-center text-dark font-weight-bold mb-3">UPDATE INJECTION RESULT</h1>
<div class="card mx-3 shadow">
    <div class="card-body">
        <form:form action="${pageContext.request.contextPath}/injection-result/update" method="post"
                   modelAttribute="injectionResultUpdate">
            <form:input type="hidden" id="id" path="id" value="${injectionResultUpdate.id}"/>
            <div class="row m-4">
                <div class="col form-group">
                    <label for="customer">Customer:</label>
                    <form:select path="customer" id="customer" class="form-control">
                        <option label="${injectionResultUpdate.customer.fullName}-${injectionResultUpdate.customer.dateOfBirth}"
                                selected value="${injectionResultUpdate.customer.id}"/>
                        <c:forEach items="${customer}" var="cus">
                            <option value="${cus.id}" label="${cus.fullName}-${cus.dateOfBirth}"/>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="col form-group">
                    <label for="prevention">Prevention:</label>
                    <select name="prevention" id="prevention" class="form-control">
                        <option label="${injectionResultUpdate.prevention}" selected value="${injectionResultUpdate.prevention}"/>
                        <c:forEach items="${preventionList}" var="pre">
                            <option value="${pre}" label="${pre}"/>
                        </c:forEach>
                    </select>
                    <form:errors path="prevention" cssClass="error"></form:errors>
                </div>

                <div class="col form-group">
                    <label for="vaccineT">Vaccine type:</label>
                    <select class="form-control" id="vaccineT" name="vaccine">
                        <option label="${injectionResultUpdate.vaccine.vaccineName}" selected
                                value="${injectionResultUpdate.vaccine.id}"/>
                        <c:forEach items="${vaccineList}" var="vaccines">
                            <option value="${vaccines.id}" label="${vaccines.vaccineName}"/>
                        </c:forEach>
                    </select>
                </div>
                <form:errors path="vaccine" cssClass="error"></form:errors>
            </div>
            <div class="row m-4">
                <div class="col form-group">
                    <label for="injection">Injection:</label>
                    <form:input type="text" class="form-control" placeholder="" id="injection"
                                path="numberOfInjection"/>
                    <form:errors path="numberOfInjection"></form:errors>
                    <form:errors path="numberOfInjection" cssClass="error"></form:errors>
                </div>
                <div class="col form-group">
                    <label for="dateOfInjection">Date of injection:</label>
                    <form:input type="date" class="form-control" placeholder="" id="dateOfInjection"
                                path="injectionDate"/>
                    <form:errors path="injectionDate"></form:errors>
                    <form:errors path="injectionDate" cssClass="error"></form:errors>
                </div>
                <div class="col form-group">
                    <label for="nextOfInjection">Next injection appoinment:</label>
                    <form:input type="date" class="form-control" placeholder="" id="nextOfInjection"
                                path="nextInjectionDate"/>
                    <form:errors path="nextInjectionDate"></form:errors>
                </div>
            </div>
            <div class="row m-4">
                <div class="col form-group">
                    <label for="placeOfinjection">Place of injection:</label>
                    <form:select path="injectionPlace" id="placeOfinjection" class="form-control">
                        <option label="${injectionResultUpdate.injectionPlace}" selected
                                value="${injectionResultUpdate.injectionPlace}"/>
                        <c:forEach items="${placeOfInjectionList}" var="place">
                            <option value="${place}" label="${place}"/>
                        </c:forEach>
                    </form:select>
                    <form:errors path="injectionPlace" cssClass="error"></form:errors>
                </div>
                <div class="col"></div>
                <div class="col"></div>
            </div>
            <div class="form-button ml-4">
                <button class="btn btn-success ml-3 mr-1" type="submit">Save</button>
                <button class="btn btn-primary mr-1" type="reset">Reset</button>
                <button class="btn btn-warning" type="submit"><a
                        href="${pageContext.request.contextPath}/injection-result/list"
                        class="text-white text-decoration-none">Cancel</a></button>
            </div>
        </form:form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/ValidateInjectionResult.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
        integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>