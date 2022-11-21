<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/VaccineType.js"></script>


            <div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">CREATE VACCINE TYPE</div>
            <div class="card mx-3 shadow mb-3">
                <div class="card-body">
                    <div class="h5 text-danger">${message}</div>
                    <c:if test="${empty vaccineType.id}">
                        <form:form action="${pageContext.request.contextPath}/vaccineType/add"
                                   modelAttribute="vaccineType" id="form-vaccine-type" enctype="multipart/form-data">
                            <div class="form-row">
                                <div class="form-group col-sm-6">
                                    <label class="font-weight-bold" for="typename">Vaccine Type Name <span
                                            class="text-danger">(*)</span> :</label>
                                    <div class="form-inline">
                                        <i class="fa-solid fa-fill h5 mr-4"></i>
                                        <input type="text" class="form-control ml-5 w-75" placeholder="Enter name"
                                               name="vaccineTypeName" id="typename" required>
                                    </div>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label class="font-weight-bold" for="typeactive">Active <span class="text-danger">(*)</span>
                                        :</label>
                                    <div class="form-inline">
                                        <i class="fa-solid fa-fill h5"></i>
                                        <input class="form-check ml-4 checkbox-lg" type="checkbox"
                                               name="vaccineTypeStatus" id="typeactive" checked disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-2">
                                <label class="font-weight-bold" for="description">Description :</label>
                                <div class="row">
                                    <div class="col-sm-1 d-flex align-self-center">
                                        <i class="fa-solid fa-file-prescription h5 "></i>
                                    </div>
                                    <div class="col-sm-11">
                                        <textarea class="form-control" rows="3" name="description"
                                                  id="description"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-2">
                                <label class="font-weight-bold">Image :</label>
                                <div class="row">
                                    <div class="col-sm-1">
                                        <i class="fa-solid fa-image mt-2 h5"></i>
                                    </div>
                                    <div class="custom-file mb-3 ml-3 col-sm-5">
                                        <input type="file" class="custom-file-input" name="imageFile" accept="image/*"
                                               id="file-input">
                                        <label class="custom-file-label" for="customFile">Choose file</label>
                                    </div>
                                </div>
                                <div class="img-upload">
                                    <img id="img-preview" src="${pageContext.request.contextPath}/img/admin.png"/>
                                </div>
                            </div>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-sm btn-success">Submit</button>
                                <button type="reset" class="btn btn-sm btn-primary ml-2">Reset</button>
                                <a class="btn btn-sm btn-warning ml-2" id="back" href="#">Cancel</a>
                            </div>

                        </form:form>
                    </c:if>

                    <c:if test="${not empty vaccineType.id}">
                        <form:form action="${pageContext.request.contextPath}/vaccineType/update"
                                   modelAttribute="vaccineType" id="form-vaccine-type" enctype="multipart/form-data">
                            <div class="form-row">
                                <input type="hidden" class="form-control ml-2" placeholder="Enter code"
                                       value="${vaccineType.id}" name="id" id="typecode">
                                <div class="form-group col-sm-6">
                                    <label class="font-weight-bold" for="typename">Vaccine Type Name <span
                                            class="text-danger">(*)</span> :</label>
                                    <div class="form-inline">
                                        <i class="fa-solid fa-fill h5 mr-4"></i>
                                        <input type="text" class="form-control ml-5 w-75" placeholder="Enter name"
                                               value="${vaccineType.vaccineTypeName}" name="vaccineTypeName"
                                               id="typename" required>
                                    </div>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label class="font-weight-bold" for="typeactive">Active <span class="text-danger">(*)</span>
                                        :</label>
                                    <div class="form-inline">
                                        <i class="fa-solid fa-fill h5"></i>
                                        <c:choose>
                                            <c:when test="${vaccineType.vaccineTypeStatus}">
                                                <input class="form-check ml-4 checkbox-lg check-status" type="checkbox"
                                                       name="vaccineTypeStatus" id="typeactive" checked value="active">
                                            </c:when>
                                            <c:otherwise>
                                                <input class="form-check ml-4 checkbox-lg check-status" type="checkbox"
                                                       name="vaccineTypeStatus" id="typeactive" value="active">
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-2">
                                <label class="font-weight-bold" for="description">Description :</label>
                                <div class="row">
                                    <div class="col-sm-1 d-flex align-self-center">
                                        <i class="fa-solid fa-file-prescription h5 "></i>
                                    </div>
                                    <div class="col-sm-11">
                                        <textarea class="form-control" rows="3" name="description"
                                                  id="description">${vaccineType.description}</textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-2">
                                <label class="font-weight-bold">Image :</label>
                                <div class="row">
                                    <div class="col-sm-1">
                                        <i class="fa-solid fa-image mt-2 h5"></i>
                                    </div>
                                    <div class="custom-file mb-3 ml-3 col-sm-5">
                                        <input type="file" class="custom-file-input" name="imageFile" accept="image/*"
                                               id="file-input">
                                        <input type="hidden" class="custom-file-input_hidden"
                                               name="customFileInputHidden">
                                        <label class="custom-file-label" for="customFile">Choose file</label>
                                    </div>
                                </div>
                                <div class="img-upload">
                                    <c:if test="${empty vaccineType.imageUrl}">
                                        <span class="ml-5 text-danger text-img font-weight-bold">Not image founded !!!</span>
                                    </c:if>
                                    <img id="img-preview"
                                         src="${pageContext.request.contextPath}/img/imgvaccine/${vaccineType.imageUrl}"/>
                                    <c:if test="${not empty vaccineType.imageUrl}">
                                        <a class="btn btn-sm btn-danger ml-5 delete-img text-white">Delete</a>
                                    </c:if>
                                </div>
                            </div>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-sm btn-success">Submit</button>
                                <button type="reset" class="btn btn-sm btn-primary ml-2">Reset</button>
                                <a class="btn btn-sm btn-warning ml-2" id="back" href="" >Cancel</a>
                            </div>

                        </form:form>
                    </c:if>

                </div>
            </div>

<script src="${pageContext.request.contextPath}/js/ValidateVaccineType.js"></script>

