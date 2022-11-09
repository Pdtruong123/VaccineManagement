$(document).ready(function () {

    $("#registerForm").validate({
        rules: {
            id: {
                required: true,
                max: 999999,
                minLength: 6,
            },
            fullName: {
                required: true,
                maxLength: 100
            },
            dateOfBirth: {
                required: true
            },
            gender: {
                required: true,
            },
            identityCard: {
                required: true,
                maxLength: 10
            },
            address: {
                required: true,
                maxLength: 100
            },
            userName: {
                required: true,
                maxLength: 10
            },
            password: {
                required: true,
                minlength: 5,
                maxlength: 20,
            },
            rePassword: {
                required: true,
                maxlength: 20,
                equalTo: password
            },
            email: {
                required: true,
                maxlength: 25
            },
            phone: {
                required: true,
                maxlength: 11
            }
        },
        messages: {
            id: {},
            fullName:{},
            dateOfBirth:{},
            gender:{},
            identityCard:{},
            address:{},
            userName: {},
            email: {},
            phone:{},
            password: {},
            rePassword: {
                equalTo: "Password and password confirmation must be same."
            },
        },
    })


    

});

$("#delete-button").click(function (){
    $("#table-IC > tbody input:checked").each(function (){
        var id = $(this).val();
        var thisResult = $(this);
        alert(id);
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

function updateButton() {
    var count = 0;
    var id;
    $("#table-IC input").each(function () {
        if (this.checked) {
            count++;
            id = $(this).val();
        }
    })
    if (count == 0) {
        alert("No data to make inactive!");
        return false;
    }

    if (count > 1) {
        alert("Invalid data - Please recheck your selects!");
        return false;
    }
    if (count == 1) {
        alert(id);
        window.location.href = "/injectionCustomerList" + id;
        return false;
    }
}
