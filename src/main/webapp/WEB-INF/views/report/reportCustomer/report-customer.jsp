<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REPORT CUSTOMER</div>
<div class="card mx-3 shadow">
    <div class="card-body">
        <div class="border-bottom">
            <form class="mb-3" action="">
                <div class="form-row">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="">Display Type: </label>
                        <div class="mt-2">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                                       value="option1">
                                <label class="form-check-label" for="inlineRadio1">Report</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                                       value="option2">
                                <label class="form-check-label" for="inlineRadio2">Chart</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="font-weight-bold" for="">Date of Birth: </label>
                        <div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="inlineRadio1">From:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="inlineRadioOptions"
                                       id="inlineRadio1" value="option1">
                            </div>
                            <div class="form-check form-check-inline">
                                <label class="form-check-label" for="inlineRadio2">To:</label>
                                <input class="form-control form-check-input ml-2" type="date" name="inlineRadioOptions"
                                       id="inlineRadio2" value="option2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-row mt-2">
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="fullname">Full Name: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter name" id="fullname">
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
                        <label class="font-weight-bold" for="address">Address: </label>
                        <div class="form-inline">
                            <input type="text" class="form-control w-75" placeholder="Enter address" id="address">
                        </div>
                    </div>
                    <div class="form-group col-sm-3 ml-5">
                        <label class="font-weight-bold ml-2" for="">Action: </label>
                        <div class="form-inline">
                            <button type="reset" class="btn  btn-primary ml-2">Reset</button>
                            <button type="submit" class="btn  btn-primary ml-3">Filter</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>
        <div class="mt-4">
            <table class="table table-bordered table-striped">
                <thead>
                <tr class="bg-info text-white text-center">
                    <th>No</th>
                    <th>Full Name</th>
                    <th>Date of Birth</th>
                    <th>Address</th>
                    <th>Identity Card</th>
                    <th>Num of Inject</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>John</td>
                    <td>John</td>
                    <td>Doe</td>
                    <td>john@example.com</td>
                    <td>john@example.com</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>John</td>
                    <td>Mary</td>
                    <td>Moe</td>
                    <td>mary@example.com</td>
                    <td>john@example.com</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>John</td>
                    <td>July</td>
                    <td>Dooley</td>
                    <td>july@example.com</td>
                    <td>john@example.com</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3">
                <span>Showing 1 to 5 of 12 entities</span>
            </div>
            <div class="col-sm-6"></div>
            <div class="col-sm-3">
                <nav aria-label="Page">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link pagination-list" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link pagination-list" href="#">1</a></li>
                        <li class="page-item"><a class="page-link pagination-list" href="#">2</a></li>
                        <li class="page-item"><a class="page-link pagination-list" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link pagination-list" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
