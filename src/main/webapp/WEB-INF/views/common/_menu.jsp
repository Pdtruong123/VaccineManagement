<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <div class="list-group list-group-flush">
    <div class="list-group-item text-white profile">
        <div><img class="img-admin" src="../../../asserts/img/admin.png"></div>
        <div class="mt-1"><Strong><%= request.getUserPrincipal().getName() %></Strong></div>
        <div class="mt-1"><%= request.getSession().getAttribute("emailLogin") %></div>
    </div>
    <div class="menu">
        <div class="list-group-item text font-weight-bold act ">
            <a class='text-decoration-none text-dark ' id="design1" href="${pageContext.request.contextPath}/home">Home</a>
            </div>
            <security:authorize access="hasAuthority('ADMIN')">
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#employee">
                <div class="col-sm-10 font-weight-bold " id="design2">Employee Management</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="employee" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/employee/list">
                        <span class="ml-2">Employee List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/employee/add">
                        <span class="ml-2">Create Employee</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#customer">
                <div class="col-sm-10 font-weight-bold " id="design3">Customer Management</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="customer" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="#">
                        <span class="ml-2">Customer List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="#">
                        <span class="ml-2">Create Customer</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#vaccineType1">
                <div class="col-sm-10 font-weight-bold " id="design4">Vaccine Type Management</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="vaccineType1" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none"
                       href="${pageContext.request.contextPath}/vaccineType/list">
                        <span class="ml-2">Vaccine Type List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none"
                       href="${pageContext.request.contextPath}/vaccineType/add">
                        <span class="ml-2">Create Vaccine Type</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#vaccine">
                <div class="col-sm-10 font-weight-bold " id="design5">Vaccine Management</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="vaccine" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none" href="${pageContext.request.contextPath}/vaccine/list">
                        <span class="ml-2">Vaccine List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/vaccine/add">
                        <span class="ml-2">Create Vaccine</span>
                    </a>
                </div>
            </div>
        </div>
        </security:authorize>

        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#inject">
                <div class="col-sm-10 font-weight-bold " id="design6">Injection Schedule</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="inject" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/injection-schedule/list">
                        <span class="ml-2">Injection Schedule List</span>
                    </a>
                </div>
                <security:authorize access="hasAuthority('ADMIN')">
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/injection-schedule/add">
                        <span class="ml-2">Create Injection Schedule</span>
                    </a>
                </div>
                </security:authorize>
            </div>
        </div>

        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#injectResult">
                <div class="col-sm-10 font-weight-bold " id="design7">Injection Result</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="injectResult" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none" href="${pageContext.request.contextPath}/injection-result/list">
                        <span class="ml-2">Injection Result List</span>
                    </a>
                </div>
                <security:authorize access="hasAuthority('ADMIN')">
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/injection-result/add">
                        <span class="ml-2">Create Injection Result</span>
                    </a>
                </div>
                </security:authorize>
            </div>
        </div>
        <security:authorize access="hasAuthority('ADMIN')">
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#news">
                <div class="col-sm-10 font-weight-bold " id="design8">News</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="news" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/news/list">
                        <span class="ml-2">News List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/news/add">
                        <span class="ml-2">Create News</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#report">
                <div class="col-sm-10 font-weight-bold " id="design9">Report</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="report" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/report/customer">
                        <span class="ml-2">Report Customer</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none" href="${pageContext.request.contextPath}/report/vaccine">
                        <span class="ml-2">Report Vaccine</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none" href="${pageContext.request.contextPath}/report/injection-result">
                        <span class="ml-2">Report Injection Result</span>
                    </a>
                </div>
            </div>
        </div>
        </security:authorize>
    </div>

</div>



