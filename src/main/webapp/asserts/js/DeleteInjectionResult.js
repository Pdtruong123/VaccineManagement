$("#checkAll").change(function (){
    if(this.checked){
        $("#table-IR input").each(function (){
            $(this).attr("checked", true)
        })
    } else{
        $("#table-IR input").each(function (){
            $(this).attr("checked", false)
        })
    }
})

$("#delete-button").click(function (){
    $("#table-IR > tbody input:checked").each(function (){
       var id = $(this).val();
       var thisResult = $(this);
       var c = confirm('Are you sure to delete?');
       if(c) {
           $.ajax({
               type: "POST",
               url: "/delete/injection-result?id=" + id,
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


$(document).ready(function(){
    $("#searchInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#table-IR > tbody tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
})


$("#update-button").click(function (){
    var count=0;
    var id;
    $("#table-IR input").each(function (){
        if(this.checked) {
            count ++;
            id = $(this).val();
        }
    })
    if(count==0){
        alert("No injection result be chosen!");
        return false;
    }

    if(count>1){
        alert("Invalid data - Please recheck your selects!");
        return false;
    }
    if(count==1){
        window.location.href="/update/injection-result/"+id;
        return false;
    }
})



