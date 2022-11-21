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
                required: "Please input your ID",
                minlength: "ID only accept 1-10 characters",
                maxlength: "ID only accept 1-10 characters"
            },
            employeeName: {
                required: "Please input your Name",
                minlength: "Name must be 1-25 numbers",
                maxlength: "Name must be 1-25 numbers"
            },
            dateOfBirth: {
                required: "Please input your birthday",
            },


            address: {
                required: "Please input your address",

            },
            phone: {
                required: "Please input your phone number",

            },
            email: {
                required: "Please input your email",

            },

            workingPlace: {
                required: "Please input your workingPlace",

            },
            position: {
                required: "Please input your position",

            },

        },
    })

});

$.validator.addMethod("email", function (value, element, params) {
    let regex = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    return regex.test(value) === params;
}, "Wrong email");
// $.validator.addMethod("phone", function (value, element, params) {
//     let regex = new RegExp("^[0]{1}\\d{12}$");
//     return regex.test(value) === params;
// }, "Wrong phone number");

$.validator.addMethod('phone',function (value, element, params) {
        return (
            this.optional(element) ||
            /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/.test(value)
        );
    }
);
$validator.addMethod("dateOfBirth", function (value, element, params){
    ("#dateOfBirth").datepicker({
        changeMonth: true,
        changeYear: true,
        showOn: 'button',
        buttonImageOnly: true,
        buttonImage: 'images/calendar.gif',
        dateFormat: 'dd/mm/yy',
        yearRange: '1900:+0',
        onSelect: function (dateString, dateOfBirth) {
            ValidateDOB(dateString);
        }
    });
});
function ValidateDOB(dateString) {
    var lblError = $("#lblError");
    var parts = dateString.split("/");
    var dtDOB = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
    var dtCurrent = new Date();
    lblError.html("Eligibility 18 years ONLY.")
    if (dtCurrent.getFullYear() - dtDOB.getFullYear() < 18) {
        return false;
    }

    if (dtCurrent.getFullYear() - dtDOB.getFullYear() == 18) {

        //CD: 11/06/2018 and DB: 15/07/2000. Will turned 18 on 15/07/2018.
        if (dtCurrent.getMonth() < dtDOB.getMonth()) {
            return false;
        }
        if (dtCurrent.getMonth() == dtDOB.getMonth()) {
            //CD: 11/06/2018 and DB: 15/06/2000. Will turned 18 on 15/06/2018.
            if (dtCurrent.getDate() < dtDOB.getDate()) {
                return false;
            }
        }
    }
    lblError.html("");
    return true;
}