<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/DataTables.css">
<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Customer.css">

<body>
<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REGISTER
    CUSTOMER INFORMATION
</div>
<div class="card-body shadow">
    <form:form
            action="${pageContext.request.contextPath}/customer/registerCustomer"
            method="post" modelAttribute="customer" id="registerForm">
        <div class="card mx-3">
            <div class="card-body">
                <div class="fs-20 font-weight-bold">Personal Information</div>
                <div class="form-row pt-15">
                    <div><form:input path="id" type="hidden"
                                     class="form-control ml-2" value="${customer.id}"
                                     id="id"/></div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="fullName">Full
                            Name <span class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-id-badge"></i>
                            <form:input path="fullName" type="text"
                                        class="form-control ml-2" value="${customer.fullName}"
                                        id="fullName"/>
                        </div>

                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="DOB">Date of Birth
                            <span class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-regular fa-calendar"></i>
                            <form:input path="dateOfBirth" type="date"
                                        class="form-control ml-2" value="${customer.dateOfBirth}"
                                        id="DOB"/>
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label class="font-weight-bold">Gender </label>
                        <div class="form-inline">
                            <i class="fa-regular fa-face-meh-blank"></i>
                            <div class="gender d-flex justify-content-evenly border rounded">
                                <div class="form-check form-check-inline">
                                    <form:radiobutton path="gender" id="genderMale" value="0"/>Male
                                </div>
                                <div class="form-check form-check-inline">
                                    <form:radiobutton path="gender" id="genderFemale" value="1"/>Female
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="idCard">Identity
                            Card <span class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-regular fa-credit-card"></i>
                            <form:input type="text" path="identityCard"
                                        class="form-control ml-2" value="${customer.identityCard}"
                                        id="idCard"/>
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="address">Address <span
                                class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-location-dot"></i>
                            <form:input type="text" path="address"
                                        class="form-control ml-2" value="${customer.address}"
                                        id="address"/>
                        </div>
                    </div>

                </div>

            </div>
        </div>
        <div class="card m-3">
            <div class="card-body">

                <div class="fs-20 font-weight-bold ">Account Information</div>
                <div class="form-row pt-15">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="userName">Username
                            <span class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-circle-user"></i>
                            <form:input type="text" path="userName"
                                        class="form-control ml-2" value="${customer.userName}"
                                        id="userName"/>
                        </div>

                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="password">Password
                            <span class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-lock"></i>
                            <form:input type="password" path="password"
                                        class="form-control ml-2"
                                        id="password"/>
                        </div>
                    </div>

                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="rePassword">Password
                            Confirm <span class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-lock"></i>
                            <form:input type="password" path="confirmPassword"
                                        class="form-control ml-2" id="rePassword"/>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="email">Email <span
                                class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-envelope"></i>
                            <form:input type="email" path="email"
                                        class="form-control ml-2" value="${customer.email}"
                                        id="email"/>
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="phone">Phone <span
                                class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-square-phone"></i>
                            <form:input type="text" path="phone" class="form-control ml-2"
                                        value="${customer.phone}" id="phone"/>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="captcha">Captcha <span
                                class="text-danger">(*)</span> :
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-lock"></i>
                            <form:input type="text" path="captcha" maxlength="5" spellcheck="false"
                                        class="form-control ml-2 inputCaptcha"
                                        id="captcha"/>
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold">Code
                        </label>
                        <div class="form-inline">
                            <i class="fa-solid fa-building-lock"></i>
                            <div class="captcha rounded d-flex align-items-center" id="captchaCode"></div>
                            <button class="refresh-btn" type="button" onclick="getCaptcha()"><i
                                    class="fa-solid fa-rotate-right reload-btn"></i></button>
                                <%-- refresh button--%>

                        </div>
                    </div>
                </div>
                <div class="status-txt"></div>
                <div class="p-btn mt-5">
                    <button type="submit" class="btn btn-sm btn-success" onclick="return submitValidate()">
                        Save
                    </button>
                    <button type="reset" class="btn btn-sm btn-primary ml-2">Reset</button>
                    <a class="btn btn-sm btn-warning ml-2" href="${pageContext.request.contextPath}/">Cancel</a>
                </div>

            </div>
        </div>
    </form:form>
</div>
</div>
<script src="${pageContext.request.contextPath}/js/CustomerCreate.js"></script>
<script src="${pageContext.request.contextPath}/js/Captcha.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
        integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>