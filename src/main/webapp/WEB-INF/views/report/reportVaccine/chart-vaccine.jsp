<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<script src="${pageContext.request.contextPath}/js/chart.js"></script>
<script src="${pageContext.request.contextPath}/js/Report.js"></script>


<div class="h5 mt-3 text-center text-secondary font-weight-bold mb-3">REPORT VACCINE</div>
<div class="card mx-3 shadow">
    <div class="card-body">
        <div class="">
            <div class="form-row">
                <div class="form-group col-sm-3">
                    <label class="font-weight-bold" for="">Display Type: </label>
                    <div class="mt-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3"
                                   value="option1">
                            <label class="form-check-label" for="inlineRadio1">Report</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4"
                                   value="option2" checked>
                            <label class="form-check-label" for="inlineRadio2">Chart</label>
                        </div>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <label class="font-weight-bold" for="">Select Year: </label>
                    <div>
                        <select class="form-control" aria-label="Default select example">
                            <option selected value="1">2019</option>
                            <option value="1">2020</option>
                            <option value="2">2021</option>
                            <option value="3">2022</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="card mx-3 mt-4 shadow">
    <div class="font-weight-bold h6 mt-3 ml-3">REPORT VACCINE CHART</div>
    <div class="mx-3 border-top">
        <canvas class="mt-3" id="myChart"></canvas>
    </div>

</div>




