$(document).ready(function () {
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
        $(".text-img").hide();
    });
    $(".delete-img").on("click", function() {
        $("#img-preview").hide();
        $(".custom-file-input_hidden").val("1");

    });
});
