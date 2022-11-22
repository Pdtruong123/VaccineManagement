$(document).ready(function () {
    $("#form-vaccine-type").validate({
        rules: {
            vaccineTypeName: {
                required: true,
                maxlength: 50,
            },
            description: {
                required: true,
                maxlength: 200
            },
        },
        messages: {
            vaccineTypeName: {},
            description: {},
        },

    })
})