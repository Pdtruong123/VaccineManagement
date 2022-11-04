$("#checkAll").change(function (){
    if(this.checked){
        $("#news-tb input").each(function (){
            $(this).attr("checked", true)
        })
    } else{
        $("#news-tb input").each(function (){
            $(this).attr("checked", false)
        })
    }
})

$("#delete-button").click(function (){
    $("#news-tb > tbody input:checked").each(function (){
        var id = $(this).val();
        var thisResult = $(this);
        var c = confirm('Are you sure to delete?');
        if(c) {
            $.ajax({
                type: "POST",
                url: "/delete/news?id=" + id,
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