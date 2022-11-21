$(document).ready(function () {
    $.validator.addMethod("email", function (value, element, params) {
        let regex = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
        return regex.test(value) === params;
    }, "Wrong email format");
    $.validator.addMethod("phone", function (value, element, params) {
        let regex = new RegExp("^[0]{1}\\d{9}$");
        return regex.test(value) === params;
    }, "Wrong phone number format");
    $.validator.addMethod("validateBirthday", function (value,element,params){
        var today = new Date();
        var birthDay = new Date(value);
        if((today.getFullYear() - birthDay.getFullYear()) <18){
            return false;
        }
        if((today.getFullYear() - birthDay.getFullYear()) == 18){
            if(today.getMonth() < birthDay.getMonth()){
                return false;
            }else{
                if (today.getDay() < birthDay.getDay()){
                    return false;
                }
            }
        }
        return true;
    }, "The age is smaller 18 or no valid, please check date of birth!")
    $("#employee-form").validate({
        rules: {
            employeeName: {
                required: true
            },

            dateOfBirth: {
                required: true,
                validateBirthday: true
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
            employeeName: {
                required: "Please input your Employee Name"
            },
            dateOfBirth: {
                required: "Please input your birthday",
            },
            gender: {
                required: "Please choose your gender",
            },

            address: {
                required: "Please input your address",
                maxlength: "Address too long"
            },
            phone: {
                required: "Please input your phone number",

            },
            email: {
                required: "Please input your email",

            },

            workingPlace: {
                required: "Please input your working place",
                minlength: "workingPlace have at least 5 characters ",
                maxlength: "workingPlace can't more than 20 characters"
            },
            position: {
                required: "Please input your position",
                equalTo: "position have at least 5 characters",
                maxlength: "position can't more than 25 characters"
            },

        },
    })
});
