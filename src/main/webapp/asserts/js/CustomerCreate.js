$(document).ready(function () {

    $("#registerForm").validate({
        rules: {
            fullName: {
                required: true,
                minlength: 3,
                maxlength: 25
            },
            dateOfBirth: {
                required: true
            },
            gender: {
                required: true,
            },
            identityCard: {
                required: true,
                maxlength: 10,
                minlength: 10
            },
            address: {
                required: true,
                maxlength: 100
            },
            userName: {
                required: true,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 5,
                maxlength: 20,
            },
            confirmPassword: {
                required: true,
                maxlength: 20,
                equalTo: "#password"
            },
            email: {
                required: true,
                maxlength: 25
            },
            phone: {
                required: true,
                maxlength: 11
            },
            captcha:{
                required: true,
                maxlength: 5,
            }
        },
        messages: {
            fullName: {
                required: "Please input your full name",
                minlength: "Full name only accept 3-25 characters",
                maxlength: "Full name only accept 3-25 characters"
            },
            dateOfBirth:{
                required: "Please input your birthday",
            },
            gender:{
                required: "Please choose your gender",
            },
            identityCard:{
                required: "Please input your identity number",
                minlength: "Identity card must be 10 numbers",
                maxlength: "Identity card must be 10 numbers"
            },
            address:{
                required: "Please input your address",
                maxlength: "Address too long"
            },
            userName: {
                required: "Please input your username",
                maxlength: "Username too long. Can't accept more than 10 characters"
            },
            email: {
                required: "Please input your email",
                maxlength: "Email too long. Can't accept more than 25 characters"
            },
            phone:{
                required: "Please input your phone number",
                maxlength: "Phone number can't more than 11 numbers"
            },
            password: {
                required: "Please input your password",
                minlength: "Password have at least 5 characters ",
                maxlength: "Password can't more than 20 characters"
            },
            rePassword: {
                required: "Please input your confirm password" ,
                equalTo: "Password and Password Confirm not matched",
                maxlength: "Password can't more than 20 characters"
            },
            captcha: {
                required: "Please identity the captcha",
                maxlength: "Captcha wrong. Please try again",
            },
        },
    })




});

$("#delete-button").click(function (){
    $("#table-IC > tbody input:checked").each(function (){
        var id = $(this).val();
        var thisResult = $(this);
        var c = confirm('Are you sure to delete?');

        if(c) {
            $.ajax({
                type: "POST",
                url: "/delete/customer?id=" + id,
                success: function (){
                    thisResult.closest("tr").remove();
                    alert("Delete Successfully!")
                },
                error: function (){
                    alert("Something wrong, can not delete!")
                }
            })
        }
    })
})
$("#checkAll").change(function (){
    if(this.checked){
        $("#table-IC input").each(function (){
            $(this).attr("checked", true)
        })
    } else{
        $("#table-IC input").each(function (){
            $(this).attr("checked", false)
        })
    }
})

$("#update-button").click(function (){
    var count=0;
    var id;
    $("#table-IC input").each(function (){
        if(this.checked) {
            count ++;
            id = $(this).val();
        }
    })
    if(count==0){
        alert("No injection result be chosen!");
        return false;
    }

    if(count>1){
        alert("Invalid data - Please recheck your selects!");
        return false;
    }
    if(count==1){
        window.location.href="/update/injectionCustomerList/"+id;
        return false;
    }
})
function submitValidate() {

    let captcha = document.querySelector("#captchaCode");
    let inputField = document.querySelector(".inputCaptcha");
    let statusTxt = document.querySelector(".status-txt");
    let inputVal = inputField.value;
    let captchaVal = $("#captchaCode").text();


    if ($("#registerForm").valid()) {
        if(inputVal == captchaVal){
            statusTxt.style.color = "#4db2ec";
            statusTxt.innerText = "Register Successfully";
            return true;
        }else{
            statusTxt.style.color = "#ff0000";
            statusTxt.innerText = "Captcha not matched. Please try again!";
            return false;
        }
    } else {
        return false;
    }
}


