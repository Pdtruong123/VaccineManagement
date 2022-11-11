<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<script src="${pageContext.request.contextPath}/js/VaccineType-JQerry.js"></script>

            <div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">VACCINE TYPE LIST</div>
            <div class="card mx-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-3 form-inline" >
                            <span>Show</span>
                            <select class="form-select mx-2 border-right-0 border-top-0 border-left-0" id="inlineFormCustomSelect"
                                    name="showNumberList" onchange="location = this.value;">
                                <option value="${pageContext.request.contextPath}/vaccineType/list?size=5&search=${nameSearch}" ${param.size == '5' ? 'selected' : ''}>5</option>
                                <option value="${pageContext.request.contextPath}/vaccineType/list?size=10&search=${nameSearch}" ${param.size == '10' ? 'selected' : ''}>10</option>
                                <option value="${pageContext.request.contextPath}/vaccineType/list?size=15&search=${nameSearch}" ${param.size == '15' ? 'selected' : ''}>15</option>
                            </select>
                            <span>entities</span>
                        </div>
                        <div class="col-sm-6"></div>
                        <div class="col-sm-3">
                            <form action="${pageContext.request.contextPath}/vaccineType/search", method="post">
                                <div class="input-group ">
                                    <input type="search" class="form-control border-right-0 border-top-0 border-left-0 form-select"
                                           placeholder="Search" aria-label="Search" value="${nameSearch}" aria-describedby="search-addon" name="searchVaccineType" />
                                    <button type="submit" class="input-group-text border-0 bg-white" id="search-addon">
                                          <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="mt-3">
                        <table class="table table-bordered" id="table-IR">
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
                            <c:forEach items="${vaccineTypeList.content}" var="element" varStatus="status">
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
                    <div><span class="text-danger">${msg}</span></div>
                    <div class="row mt-4">
                        <div class="col-sm-3">
                            <span>Showing ${firstElement} to ${lastElement} of ${vaccineTypeList.totalElements} entities</span>
                        </div>
                        <div class="col-sm-6"></div>
                        <div class="col-sm-3">
                            <nav aria-label="Page">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link pagination-list"
                                           href="/vaccineType/list?p=${vaccineTypeList.number - 1}&size=${vaccineTypeList.size}&search=${nameSearch}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                    </li>
                                    <li class="page-item"><a class="page-link pagination-list" href="/vaccineType/list?p=0&size=${vaccineTypeList.size}&search=${nameSearch}">1</a></li>
                                    <li class="page-item"><a class="page-link pagination-list" href="/vaccineType/list?p=1&size=${vaccineTypeList.size}&search=${nameSearch}">2</a></li>
                                    <li class="page-item"><a class="page-link pagination-list" href="/vaccineType/list?p=2&size=${vaccineTypeList.size}&search=${nameSearch}">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link pagination-list" href="/vaccineType/list?p=${vaccineTypeList.number + 1}&size=${vaccineTypeList.size}&search=${nameSearch}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="">
                        <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/vaccineType/add">New Vaccine Type</a>
                        <a class="btn btn-sm btn-warning ml-2" id="in-active" >Make In-Active</a>
                    </div>
                </div>
            </div>
