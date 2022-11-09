<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/reseter.css/1.0.8/reseter.min.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

    <script type="text/javascript"
            src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" href="../../asserts/css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>

<body>
<div>${success}</div>
<h1 class="text-center">CREATE EMPLOYEE</h1>
<form:form action="${pageContext.request.contextPath}/add/employee"
           method="post" modelAttribute="employee" id="employee-form">

    <div class="row m-4">

        <div class="col form-group">
            <i class="fa-solid fa-user"></i> <label for="id"><strong>Employee
            id:</strong></label>
            <form:input type="text" class="form-control" placeholder="00126192"
                        id="id" path="id" value="${Employee.id}" />
        </div>

        <div class="col form-group">
            <label for="name"><strong>Employee name:</strong></label>
            <form:input type="text" class="form-control"
                        placeholder="Nguyen Van A" id="name" path="name"
                        value="${Employee.name}" />
        </div>

        <div class="col form-group">
            <label class="form-label"><strong>Gender:</strong></label> <br>
            <div class="form-check form-check-inline">
                <input type="radio" class="form-check-input" name="rdo" checked>
                <label class="form-check-label">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" class="form-check-input" name="rdo"> <label
                    class="form-check-label">Female</label>
            </div>

        </div>

    </div>
    <div class="row m-4">
        <div class="col form-group">
            <label for="DoB"><strong>Date of Birth:</strong></label>
            <form:input type="date" class="form-control"
                        placeholder="12/12/1999" id="DoB" path="DoB"
                        value="${Employee.DoB}" />
        </div>
        <div class="col form-group">
            <label for="phone"><strong>Phone:</strong></label>
            <form:input type="phone" class="form-control" placeholder="Doctor"
                        id="phone" path="phone" value="${Employee.phone}" />
        </div>

        <div class="col form-group">
            <label for="id"><strong>Address:</strong></label>
            <form:input type="text" class="form-control"
                        placeholder="17 Duy Tan" id="address" path="address"
                        value="${Employee.address}" />
        </div>
    </div>

    <div class="row m-4">

        <div class="col form-group">
            <label for="email"><strong>Email:</strong></label>
            <form:input type="email" class="form-control"
                        placeholder="nguyena@email.com" id="email" path="email"
                        value="${Employee.email}" />
        </div>

        <div class="col form-group">
            <label for="place"><strong>Working Place:</strong></label>
            <form:input type="text" class="form-control" placeholder="Hong Ngoc"
                        id="place" path="place" value="${Employee.workingPlace}" />
        </div>

        <div class="col form-group">
            <label for="position"><strong>Position:</strong></label>
            <form:input type="text" class="form-control" placeholder="Doctor"
                        id="position" path="position" value="${Employee.position}" />
        </div>

    </div>
    <div class="col form-group">
        <label class="font-weight-bold">Image :</label>
        <div class="file-upload">
            <div class="file-select">

                <input type="file" name="chooseFile" id="chooseFile">
            </div>
        </div>
    </div>
    <div class="img-upload">
        <img id="img-preview" src="../../asserts/img/admin.png" />
    </div>
    </div>
    </div>
    <div class="form-button">
        <button class="btn btn-success" type="submit">Save</button>
        <button class="btn btn-primary" type="reset">Reset</button>
        <button class="btn btn-warning text-white" type="submit">
            <a href="${pageContext.request.contextPath}/employee-list"
               class="text-white text-decoration-none">Cancel</a></button>
    </div>
</form:form>
</body>

</html>