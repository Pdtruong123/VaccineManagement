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
          crossorigin="anonymous" referrerpolicy="no-referrer"
    />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
    <script src="../../asserts/js/loadFileName.js"></script>
    <script src="../../asserts/js/previewImg.js"></script>
    <link rel="stylesheet" href="../../../asserts/css/style.css">
    <link rel="stylesheet" href="employee.css">
    <script src="image.js"></script>
</head>

<body>
        <div>
            <div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3" style="color: black">CREATE EMPLOYEE
            </div>
            <div class="h4 text-success font-weight-bold ml-3">${success}</div>
            <div class="card mx-3">
                <div class="card-body">

                    <form:form action="${pageContext.request.contextPath}/employee/add" method="post"
                               modelAttribute="employee" id="employee-form">


                    <div class="form-row">
                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="id">Employee id<span
                                    class="text-danger">(*):</span></label>
                            <form:input class="form-control w-50" type="text" placeholder="00126192" id="id" value=""
                                        path="id"/>
                        </div>


                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="name">Employee name<span
                                    class="text-danger">(*):</span></label>
                            <form:input class="form-control" type="text" placeholder="Nguyen Van A" id="name"
                                        path="employeeName"/>
                        </div>


                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="gender">Gender </label>
                            <div class="form-inline">
                                <i class="fa-regular fa-face-meh-blank"></i>
                                <div class="gender d-flex justify-content-evenly border rounded">
                                    <div class="form-check form-check-inline">
                                        <form:radiobutton path="gender" id="gender" value="0"/>Male

                                    </div>
                                    <div class="form-check form-check-inline">
                                        <form:radiobutton path="gender" id="gender" value="1"/>Female
                                    </div>
                                </div>

                            </div>
                        </div>


                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="dateOfBirth">Date Of Birth<span class="text-danger">(*):</span></label>
                            <form:input class="form-control" type="date" placeholder="12/12/1999" id="dateOfBirth"
                                        path="dateOfBirth"/>
                        </div>

                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="phone">Phone<span
                                    class="text-danger">(*):</span></label>
                            <form:input class="form-control" type="phone" placeholder="0123456789" id="phone"
                                        path="phone"/>
                        </div>

                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="address">Address<span
                                    class="text-danger">(*):</span></label>
                            <form:input class="form-control" type="text" placeholder="17 Duy Tan" id="address"
                                        path="address"/>
                        </div>


                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="email">Email<span
                                    class="text-danger">(*):</span></label>
                            <form:input class="form-control" type="email" placeholder="" id="email" path="email"/>
                        </div>

                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="workingPlace">Working Palace:</label>
                            <form:input class="form-control" type="text" placeholder="Hong Ngoc" id="workingPlace"
                                        path="workingPlace"/>
                        </div>


                        <div class="form-group col-sm-4">
                            <label class="font-weight-bold" for="position">Position:</label>
                            <form:input class="form-control" type="text" id="position" path="position"
                                        placeholder="Doctor"/>
                        </div>
                    </div>
                </div>

                <div class="form-group col-sm-4">
                    <label class="font-weight-bold">Image :</label>
                    <div class="row">
                        <div class="col-sm-1">
                            <i class="fa-solid fa-image mt-2 h5"></i>
                        </div>
                        <div class="file-upload">
                            <div class="file-select">
                                <div class="file-select-button" id="fileName">Choose File</div>
                                <div class="file-select-name" id="noFile">No file chosen...</div>
                                <input type="file" name="chooseFile" id="chooseFile">
                            </div>
                        </div>
                    </div>

                </div>


                <div class="form-button mt-4">
                    <button class="btn btn-success mr-1" type="submit">Save</button>
                    <button class="btn btn-primary mr-1" type="reset">Reset</button>
                    <button class="btn btn-warning text-white" type="button"><a
                            href="${pageContext.request.contextPath}/employee/list"
                            class="text-white text-decoration-none">Cancel</a></button>

                    </form:form>
                </div>

            </div>
        </div>

        </body>

</html>