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
                maxlength: 20
            },
            rePassword: {
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
            }
        }
    })
    
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
})