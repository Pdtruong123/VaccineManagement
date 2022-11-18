$(document).ready(function () {
        $.validator.addMethod("greaterToday", function (value, element) {
            return new Date().setHours(0,0,0,0) <= Date.parse(value);
        }, "Please input Date of vaccination with value greater or equal the current date");

        $.validator.addMethod("endDate", function (value, element) {
            var startDate = $('#startDate').val();
            return Date.parse(startDate) < Date.parse(value) || value == "";
        }, "Please input Next date of vaccination with value greater than Date of vaccination");
    $('#form-injectionSchedule').validate({
        rules:{
            startDate:{
                required:true,
                greaterToday:true,
            },
            endDate:{
                required: true,
                endDate:true
            },
            place:{
                required:true
            },
            description:{
                required:true
            }
        }
    })
})


