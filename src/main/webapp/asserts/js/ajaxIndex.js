$(document).ready(function() {
    $(document).on("click", "#listSchedule", function () {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/lisst",
            success: function (res) {
                $("#mainIndex").html(res)
            },
            error: function (err) {
                console.log("Error");
                console.log(err);
            }
        })
    })
    $(document).on("click", "#createSchedule", function () {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/add/injectionSchedule",
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