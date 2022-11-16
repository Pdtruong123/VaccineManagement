<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
    <div class="list-group list-group-flush">
    <div class="list-group-item text-white profile">
        <div><img class="img-admin" src="../../../asserts/img/admin.png"></div>
        <div class="mt-1">Admin</div>
        <div class="mt-1">admin@fsoft.com.vn</div>
    </div>
    <div class="menu">
        <div class="list-group-item text font-weight-bold act ">
            <a class='text-decoration-none text-dark ' href="${pageContext.request.contextPath}/">Home</a>
            </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#employee">
                <div class="col-sm-10 font-weight-bold ">Employee Management</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="employee" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/employee-list">
                        <span class="ml-2">Employee List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/add/employee">
                        <span class="ml-2">Create Employee</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#customer">
                <div class="col-sm-10 font-weight-bold ">Customer Management</div>
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
                <div class="col-sm-10 font-weight-bold ">Vaccine Type Management</div>
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
                <div class="col-sm-10 font-weight-bold ">Vaccine Management</div>
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
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#inject">
                <div class="col-sm-10 font-weight-bold ">Injection Schedule</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="inject" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/lisst">
                        <span class="ml-2">Injection Schedule List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/add/injectionSchedule">
                        <span class="ml-2">Create Injection Schedule</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#injectResult">
                <div class="col-sm-10 font-weight-bold ">Injection Result</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="injectResult" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none" href="${pageContext.request.contextPath}/injection-result-list">
                        <span class="ml-2">Injection Result List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/add/injection-result">
                        <span class="ml-2">Create Injection Result</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#news">
                <div class="col-sm-10 font-weight-bold ">News</div>
                <div class="col-sm-2"><i class="fa-solid fa-plus"></i></div>
            </div>
            <div class="mt-3 collapse" id="news" data-parent="#accordion">
                <div class="ml-4 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/news-list">
                        <span class="ml-2">News List</span>
                    </a>
                </div>
                <div class="ml-4 mt-2 text-sub">
                    <a class="text-reset text-decoration-none " href="${pageContext.request.contextPath}/add/news">
                        <span class="ml-2">Create News</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="list-group-item">
            <div class="row text act" data-toggle="collapse" data-target="#report">
                <div class="col-sm-10 font-weight-bold ">Report</div>
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
    </div>
</div>



