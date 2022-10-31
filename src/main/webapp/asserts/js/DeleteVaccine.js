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
               url: "/vaccine/delete?id=" + id,
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

/*$("select[name='showNumberList']").change(function(){
	var sizePage = $(this).val();
	
	$.ajax({
               type: "POST",
               url: "/vaccine/list",
               data: {
					size : sizePage
				},
               success: function (){
                   thisResult.closest("tr").remove();
                   alert("Delete Successfully!")
               },
               error: function (){
                   alert("Something wrong, can not delete!")
               }
           })
})*/

