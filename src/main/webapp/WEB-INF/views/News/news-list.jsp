<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<head>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
    <link rel="stylesheet" href="../../../asserts/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/news.css">
    <link rel="stylesheet" href="../../../asserts/css/DataTables.css">
</head>
<body>
<div class="h5 mt-3 text-center text-dark font-weight-bold mb-3">NEWS LIST</div>
<div class="h4 text-success font-weight-bold ml-3">${success}</div>
<div class="card mx-3 shadow">
    <div class="card-body">
        <div class="mt-3">
            <table class="table table-bordered table-striped" id="news-tb">
                <thead>
                <tr class="bg-info text-white text-center">
                    <td><input class="form-check mx-auto" type="checkbox" id="checkAll"></td>
                    <th>Title</th>
                    <th>Content</th>
                    <th hidden>Content</th>
                    <th>Post date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${newsList}" var="result">
                    <tr>
                        <td><input class="form-check mx-auto" type="checkbox" value="${result.id}" name="id"></td>
                        <td class="title-row"><a class="link-col" href="#" data-toggle="modal" data-target="#exampleModalCenter">${result.title}</a></td>
                        <td hidden class="content-row"><input type="hidden">${result.content}</td>
                        <td class="preview-row">${result.preview}</td>
                        <td class="postdate-row">${result.postDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="h5 text-right text-danger">${error}</div>
        <security:authorize access="hasAuthority('ADMIN')">
        <div class="">
            <button class="btn btn-success mr-1" type="submit"><a href="${pageContext.request.contextPath}/news/add"
                                                                  class="text-white text-decoration-none">Create
                News</a></button>
            <button class="btn btn-warning mr-1 text-white" type="submit" id="update-button">Update News</button>
            <button class="btn btn-danger" type="submit" id="delete-button">Delete News</button>
        </div>
        </security:authorize>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Detail News</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="content-news">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/DataTables.js"></script>
<script src="${pageContext.request.contextPath}/js/DeleteNews.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
</body>
