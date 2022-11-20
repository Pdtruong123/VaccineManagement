
$('#checkAll').change(function () {
    $('#employee-tb input').prop('checked',this.checked);
});
$('#employee-tb input').change(function () {
    if ($('#employee-tb input:checked').length == $('#employee-tb input').length){
        $('#checkAll').prop('checked',true);
    }
    else {
        $('#checkAll').prop('checked',false);
    }
});

    //delete
    $("#delete-button").click(function (){
        var count=0;
        $("#employee-tb input").each(function (){
            if(this.checked) {
                count ++;
            }
        })
        if(count == 0){
            alert("Please select at least one!");
            return false;
        }
        let ids = [];
        $("#employee-tb input:checked").each(function (){
            var id = $(this).val();
            ids.push(id);
        });
        var thisResult = $("#employee-tb input:checked");
        var c = confirm('Are you sure to delete? \n Total: ' +ids.length + ' record');
        if(c) {
            $.ajax({
                type: "POST",
                url: "/employee/delete?ids=" + ids,
                success: function (){
                    thisResult.closest("tbody").remove();
                    thisResult.prop("checked", false);
                    alert("Delete Successfully!")
                },
                error: function (){
                    alert("Something wrong, can not delete!")
                }
            })
        }
        return false;
    // });
});