$(document).ready(function() {
    $(document).on("click", "#listSchedule", function () {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/schedule/api/list",
            success: function (res) {
                $("#mainIndex").html(res)
            },
            error: function (err) {
                console.log("Error");
                console.log(err);
            }
        })
    })
})
