<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Injection Result</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/reseter.css/1.0.8/reseter.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/InjectionResult.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div>${success}</div>
<h1 class="text-center">CREATE INJECTION RESULT</h1>
<form:form action="${pageContext.request.contextPath}/add/injection-result" method="post" modelAttribute="injectionResult">

    <div class="row m-4">
        <div class="col form-group">
            <label for="customer">Customer:</label>
            <form:input type="text" class="form-control" placeholder="--Select Customer" id="customer" path="id" value="${injectionResult.id}"/>
            <form:errors path="id"></form:errors>
        </div>
        <div class="col form-group">
            <label for="prevention">Prevention:</label>
            <form:select path="prevention" id="prevention" class="form-control">
                <option label="--Select Prevention" selected value=""/>
                <c:forEach items="${preventionList}" var="pre">
                    <option value="${pre}" label="${pre}" />
                </c:forEach>
            </form:select>
            <form:errors path="prevention"></form:errors>
        </div>
        <div class="col form-group">
            <label for="vaccineType">Vaccine type:</label>
            <form:select class="form-control" id="vaccineType" path="vaccine">
                <option label="--Select Vaccine Type" selected/>
                <c:forEach items="${vaccineList}" var="vaccines">
                    <option value="${vaccines.id}" label="${vaccines.vaccineName}" />
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="row m-4">
        <div class="col form-group">
            <label for="injection">Injection:</label>
            <form:input type="text" class="form-control" placeholder="" id="injection" path="numberOfInjection" value="${injectionResult.numberOfInjection}"/>
            <form:errors path="numberOfInjection"></form:errors>
        </div>
        <div class="col form-group">
            <label for="dateOfInjection">Date of injection:</label>
            <form:input type="date" class="form-control" placeholder="" id="dateOfInjection" path="injectionDate" value="${injectionResult.injectionDate}"/>
            <form:errors path="injectionDate"></form:errors>
        </div>
        <div class="col form-group">
            <label for="nextOfInjection">Next injection appoinment:</label>
            <form:input type="date" class="form-control" placeholder="" id="nextOfInjection" path="nextInjectionDate" value="${injectionResult.nextInjectionDate}"/>
            <form:errors path="nextInjectionDate"></form:errors>
        </div>
    </div>
    <div class="row m-4">
        <div class="col form-group">
            <label for="placeOfinjection">Place of injection:</label>
            <form:input type="text" class="form-control" placeholder="--Select place of injection--" id="placeOfinjection" path="injectionPlace" value="${injectionResult.injectionPlace}"/>
            <form:errors path="injectionPlace"></form:errors>
        </div>
        <div class="col"></div>
        <div class="col"></div>
    </div>
    <div class="form-button">
        <button class="btn btn-success" type="submit">Save</button>
        <button class="btn btn-primary" type="reset">Reset</button>
        <button class="btn btn-warning" type="submit">Cancel</button>
    </div>
</form:form>

<%--&lt;%&ndash;Sua voi RequestController&ndash;%&gt;
<form action="${pageContext.request.contextPath}/add/injection-result" method="post" id="add-form">

    <div class="row m-4">
        <div class="col form-group">
            <label for="customer">Customer:</label>
            <input type="text" class="form-control" placeholder="--Select Customer" id="customer" path="id" value="${injectionResult.id}"/>

        </div>
        <div class="col form-group">
            <label for="prevention">Prevention:</label>
            <select path="prevention" id="prevention" class="form-control">
                <option label="--Select Prevention" selected value=""/>
                <c:forEach items="${preventionList}" var="pre">
                    <option value="${pre}" label="${pre}" />
                </c:forEach>
            </select>

        </div>
        <div class="col form-group">
            <label for="vaccineType">Vaccine type:</label>
            <select class="form-control" id="vaccineType" path="vaccine">
                <option label="--Select Vaccine Type" selected/>
                <c:forEach items="${vaccineList}" var="vaccines">
                    <option value="${vaccines.id}" label="${vaccines.vaccineName}" />
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row m-4">
        <div class="col form-group">
            <label for="injection">Injection:</label>
            <input type="text" class="form-control" placeholder="" id="injection" path="numberOfInjection" value="${injectionResult.numberOfInjection}"/>

        </div>
        <div class="col form-group">
            <label for="dateOfInjection">Date of injection:</label>
            <input type="date" class="form-control" placeholder="" id="dateOfInjection" path="injectionDate" value="${injectionResult.injectionDate}"/>

        </div>
        <div class="col form-group">
            <label for="nextOfInjection">Next injection appoinment:</label>
            <input type="date" class="form-control" placeholder="" id="nextOfInjection" path="nextInjectionDate" value="${injectionResult.nextInjectionDate}"/>

        </div>
    </div>
    <div class="row m-4">
        <div class="col form-group">
            <label for="placeOfinjection">Place of injection:</label>
            <input type="text" class="form-control" placeholder="--Select place of injection--" id="placeOfinjection" path="injectionPlace" value="${injectionResult.injectionPlace}"/>

        </div>
        <div class="col"></div>
        <div class="col"></div>
    </div>
    <div class="form-button">
        <button class="btn btn-success" type="submit" id="add-button">Save</button>
        <button class="btn btn-primary" type="reset">Reset</button>
        <button class="btn btn-warning" type="submit">Cancel</button>
    </div>
</form>--%>
</body>
</html>