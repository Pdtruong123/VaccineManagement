$(document).ready(function () {
        $.validator.addMethod("greaterToday", function (value, element) {
            return Date.now() <= Date.parse(value);
        }, "Please input Date of vaccination with value greater or equal the current date");

        $.validator.addMethod("endDate", function (value, element) {
            var startDate = $('.startDate').val();
            return Date.parse(startDate) < Date.parse(value) || value == "";
        }, "Please input Next date of vaccination with value greater than Date of vaccination");
    $('#form-Schedule').validate({
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
            note:{
                required:true
            }
        }
    })
})


