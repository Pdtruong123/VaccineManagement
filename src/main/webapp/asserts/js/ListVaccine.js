$("#checkAll").change(function (){
    if(this.checked){
        $("#table-VC input").each(function (){
            $(this).attr("checked", true)
        })
    } else{
        $("#table-VC input").each(function (){
            $(this).attr("checked", false)
        })
    }
})
$("#make-in-active-button").click(function (){
	var count=0;
	var countInActive=0;
	var valueStatus;
	$("#table-VC input").each(function (){
        if(this.checked) {
		count ++;
		valueStatus = $(this).closest('tr').find("td:eq(6)").text();
		if(valueStatus=="In-Active"){
			countInActive++;
		}
		}
        })
	if(count==0){
			alert("No data to make inactive!");
			return false;
		}
		
	if(countInActive>0){
			alert("Invalid data - Have a 'In-Active' case. \n Please recheck your selects!");
			return false;
		}
		
    
		
      let ids = [];
        $("#table-VC input:checked").each(function (){
            var id = $(this).val();
            ids.push(id);
        });
       var thisResult = $("#table-VC input:checked");
       var c = confirm('Are you sure to make in-active id:'+ids);
       if(c) {
           $.ajax({
               type: "POST",
               url: "/vaccine/update/makeInActive?ids=" + ids,
               success: function (){
                   thisResult.closest('tr').find("td:eq(6)").text("In-Active");
				   thisResult.prop("checked", false);
                   alert("Update In-Active Successfully!")
               },
               error: function (){
                   alert("Something wrong, can not make In-Active!")
               }
           })
        }
    
})

function updateButton(){
	var count=0;
	var id;
	$("#table-VC input").each(function (){
        if(this.checked) {
		count ++;
		id = $(this).val();
		}
        })
	if(count==0){
			alert("No data to Update!");
			return false;
		}
		
	if(count>1){
			alert("Invalid data - Please recheck your selects!");
			return false;
		}
	if(count==1){
			window.location.href="/vaccine/update/?idUpdate="+id;
			return false;
		}
		
		
}

