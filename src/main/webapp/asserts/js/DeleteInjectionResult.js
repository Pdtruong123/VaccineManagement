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
        var ids= [];
        var count = 0;
    $("#table-IR > tbody input:checked").each(function (){
       var id = $(this).val();
       count++;
       ids.push(id);
    })
        if(count==0){
            alert("Please select at least one!");
            return false;
        }
       var thisResult = $("#table-IR input:checked");
       var c = confirm('Are you sure to delete with id?' + ids);
       if(c) {
           $.ajax({
               type: "POST",
               url: "/injection-result/delete?ids=" + ids,
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
        alert("Can not choose multi selects for update!");
        return false;
    }
    if(count==1){
        window.location.href="/injection-result/update/"+id;
        return false;
    }
})



