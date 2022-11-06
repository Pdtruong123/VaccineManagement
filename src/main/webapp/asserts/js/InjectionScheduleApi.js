$(document).ready(function () {
    $.ajax({
        url: 'http://localhost:8080/schedule/api/list',
        type: 'GET',
        dataType: 'JSON',
        success: function (res) {
            const vaccineNameApi = res.map(item => {
                return "<tr><td><a href=\"\">" + item.vaccineName + "</a></td>\n" +
                    "                                    <td>From " + item.startDate + " to " + item.endDate + "</td>\n" +
                    "                                    <td>" + item.place + "</td>\n" +
                    "                                    <td>" + item.note + "</td>\n" +
                    "                                    <td>" + item.status + "</td>" +
                    "</tr>"
            })
            $("#bodyList").html(vaccineNameApi);
        },
        error: function (err) {
            console.log(err);
        }
    })
    $.ajax({
        url: 'http://localhost:8080/schedule/api/create',
        type: 'POST',
        dataType: 'JSON',
        data: {

        },
        success: function (res) {

        },
        error: function (err) {
            console.log(err);
        }
    })

})