$(document).ready(function () {
    Pageging();
    create();
 })


function Pageging() {
    $.ajax({
        url: 'http://localhost:8080/schedule/api/list?paging=',
        type: 'GET',
        dataType: 'JSON',
        success: function (res) {
            const vaccineNameApi = res.map(item => {
                return "<tr><td><a href=\"#\">" + item.vaccineName + "</a></td>\n" +
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
    var pageeeee=0;
    var page=$('.page-item');
    var curruentPage=1;
    for (let i=0;i<page.length;i++){
        page[i].onclick=function () {
            var pageing=$(this).text();
            curruentPage=pageing;
            $.ajax({
                url: 'http://localhost:8080/schedule/api/list?paging='+pageing,
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
        }
    }
    $(document).on("click",".page-item-next",function () {
        curruentPage++;
        $.ajax({
            url: 'http://localhost:8080/schedule/api/list?paging='+curruentPage,
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
    })
}
function create() {
    $("#btnSave").on("click", function () {
        var vaccineId = $("#vaccineID").val();
        var startDate = $(".startDate").val();
        var endDate = $(".endDate").val();
        var place = $(".place").val();
        var note = $(".note").val();
        $.ajax({
            url: 'http://localhost:8080/schedule/api/create',
            type: 'POST',
            dataType: 'JSON',
            data: {
                vaccineID: vaccineId,
                startDate: startDate,
                endDate: endDate,
                place: place,
                note: note
            },
            success: function (res) {
                console.log(res);
            },
            error: function (err) {
                console.log(err);
            }
        })
    })
}
function search() {

}
