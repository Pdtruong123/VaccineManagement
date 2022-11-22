$(document).ready(function (){
    $("#news-form").validate({
        rules: {
            title: {
                required: true
            },
            preview: {
                required: true
            },
            content: {
                required: true
            }
        }

    });

})