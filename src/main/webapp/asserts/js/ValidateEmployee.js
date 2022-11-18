$(document).ready(function () {

    $("#employee-form").validate({
        rules: {
            id: {
                required: true,
                minlength: 3,
                maxlength: 25
            },
            employeeName: {
                required: true,
                maxlength: 3,
                minlength: 25
            },

            dateOfBirth: {
                required: true
            },
            gender: {
                required: true,
            },

            address: {
                required: true,
                maxlength: 100
            },
            phone: {
                required: true,
                maxlength: 12
            },
            workingPlace: {
                required: true,
                minlength: 5,
                maxlength: 20,
            },
            position: {
                required: true,
                minlength: 5,
                maxlength: 20,

            },
            email: {
                required: true,
                maxlength: 25
            },


        },
        messages: {
            id: {
                required: "Please input your employee ID",
                minlength: "Full name only accept 3-25 characters",
                maxlength: "Full name only accept 3-25 characters"
            },
            employeeName:{
                required: "Please input your Employee Name",
                minlength: "Identity card must be 3-25 numbers",
                maxlength: "Identity card must be 3-25 numbers"
            },
            dateOfBirth:{
                required: "Please input your birthday",
            },
            gender:{
                required: "Please choose your gender",
            },

            address:{
                required: "Please input your address",
                maxlength: "Address too long"
            },
            phone: {
                required: "Please input your phone number",
                maxlength: "Phone too long. Can't accept more than 12 characters"
            },
            email: {
                required: "Please input your email",
                maxlength: "Email too long. Can't accept more than 25 characters"
            },

            workingPlace: {
                required: "Please input your workingPlace",
                minlength: "workingPlace have at least 5 characters ",
                maxlength: "workingPlace can't more than 20 characters"
            },
            position: {
                required: "Please input your position" ,
                equalTo: "position have at least 5 characters",
                maxlength: "position can't more than 25 characters"
            },

        },
    })

});

$.validator.addMethod("emailValidate", function(value, element, params){
    let regex = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    return regex.test(value) === params;
}, "Please input your right email");
$.validator.addMethod("phoneValidate", function(value, element, params){
    let regex = new RegExp("^[0]{1}\\d{9}$");
    return regex.test(value) === params;
}, "Not valid phone number format");