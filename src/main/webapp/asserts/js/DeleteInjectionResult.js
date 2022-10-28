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
        return false;
    })
})

