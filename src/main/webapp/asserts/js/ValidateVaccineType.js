$(document).ready(function (){
    $("#form-vaccine-type").validate({
        rules: {
            typename: {
                required: true,
                maxLength: 50,
            },
            description: {
                required: true,
                maxLength: 200
            },
        },
        messages: {
            typename: {
               
            },
            description:{

            },
        },

    })
})