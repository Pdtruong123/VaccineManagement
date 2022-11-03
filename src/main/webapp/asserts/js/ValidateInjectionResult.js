$(document).ready(function () {
    $.validator.addMethod("greaterThanToday", function (value, element) {
        var now = new Date();
        if (!/Invalid|NaN/.test(new Date(value))) {
            return new Date(value) >= now;
        }
        return isNaN(value) || (parseFloat(value) >= now);
    }, "Please input Date of vaccination with value greater or equal the current date");
    $.validator.addMethod("endDate", function (value, element) {
        var startDate = $('#dateOfInjection').val();
        return Date.parse(startDate) < Date.parse(value) || value == "";
    }, "Please input Next date of vaccination with value greater than Date of vaccination");

    $.validator.addMethod("checkSelect", function (value) {
        return (value != "");
    }, "Please select value")

    $("#IR-form").validate({
        rules: {
            id: {
                required: true,
                maxLength: 36
            },
            prevention: {
                required: true
            },
            vaccine: {
                required: true
            },
            numberOfInjection: {
                required: true,
                maxLength: 100
            },
            injectionDate: {
                required: true,
                greaterThanToday: true
            },
            nextInjectionDate: {
                required: true,
                endDate: true
            },
            injectionPlace: {
                required: true,
                maxLength: 255
            },
            prevention: {
                checkSelect: true
            },
            vaccine: {
                checkSelect: true
            }
        }
    })
})