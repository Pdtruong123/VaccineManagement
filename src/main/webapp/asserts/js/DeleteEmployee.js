

$("#checkAll").change(function (){
    if(this.checked){
        $("#employee-tb input").each(function (){
            $(this).attr("checked", true)
        })
    } else{
        $("#employee-tb input").each(function (){
            $(this).attr("checked", false)
        })
    }
})

$("#delete-button").click(function (){
    $("#employee-tb > tbody input:checked").each(function (){
        var id = $(this).val();
        var thisResult = $(this);
        var c = confirm('Are you sure to delete?');
        if(c) {
            $.ajax({
                type: "POST",
                url: "/delete/employee?id=" + id,
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

$("#update-button").click(function (){
    var count=0;
    var id;
    $("#employee-tb input").each(function (){
        if(this.checked) {
            count ++;
            id = $(this).val();
        }
    })
    if(count==0){
        alert("No employee be chosen!");
        return false;
    }

    if(count>1){
        alert("Invalid data - Please recheck your selects!");
        return false;
    }
    if(count==1){
        window.location.href="/update/employee/"+id;
        return false;
    }
})