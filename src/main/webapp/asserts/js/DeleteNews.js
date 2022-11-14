$("#news-tb tbody tr td .link-col").click(function (){
    var thisParent = $(this).closest("tr");
    alert("Title: " + $(this).text()+
            "\nPreview: " + thisParent.find("td:eq(3)").text()+
            "\nContent: " + thisParent.find("td:eq(2)").text()+
            "\nPost Date: " + thisParent.find("td:eq(4)").text()
    );
})

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

$("#update-button").click(function (){
    var count=0;
    var id;
    $("#news-tb input").each(function (){
        if(this.checked) {
            count ++;
            id = $(this).val();
        }
    })
    if(count==0){
        alert("No news be chosen!");
        return false;
    }

    if(count>1){
        alert("Can not choose multi selects for update!");
        return false;
    }
    if(count==1){
        window.location.href="/update/news/"+id;
        return false;
    }
})