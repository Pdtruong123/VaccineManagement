$(document).ready(function () {
    $.ajax({
        url:'http://localhost:8080/schedule/api/list',
        type:'GET',
        dataType:'JSON',
        success:function (res){
            res.forEach(x => {
                console.log(x);
            })

        },
        error:function (err){
            console.log(err);
        }
    })
})