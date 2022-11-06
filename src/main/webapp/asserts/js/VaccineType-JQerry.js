$(document).ready(function () {

    //image file name
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
        $(".text-img").hide();
    });
    $(".delete-img").on("click", function() {
        $("#img-preview").hide();
        $(".custom-file-input_hidden").val("1");

    });

    //image preview
    const input = document.getElementById('file-input');
    const image = document.getElementById('img-preview');

    $(input).on("change", (e) => {
        if (e.target.files.length) {
            const src = URL.createObjectURL(e.target.files[0]);
            image.src = src;
        }
    });

    //back lai trang truoc do
    $("#back").on("click", function() {
        history.go(-1);
        return false;
    });

    //check all at table list
    $('#checkAll').change(function () {
        $('#table-IR input').prop('checked',this.checked);
    });

    $('#table-IR input').change(function () {
        if ($('#table-IR input:checked').length == $('#table-IR input').length){
            $('#checkAll').prop('checked',true);
        }
        else {
            $('#checkAll').prop('checked',false);
        }
    });

    //in-active status
    $("#in-active").click(function (){
        var count=0;
        var countInActive=0;
        var valueStatus;
        $("#table-IR input").each(function (){
            if(this.checked) {
                count ++;
                valueStatus = $(this).closest('tr').find("td:eq(4)").text();
                if("In-Active" == valueStatus){
                    countInActive++;
                }
            }
        })
        if(count == 0){
            alert("Please select at least one!");
            return false;
        }else if(countInActive != 0){
            alert("Invalid data - Have a 'In-Active' case. \n Please recheck your selects!");
            return false;
        }
        let ids = [];
        $("#table-IR input:checked").each(function (){
            var id = $(this).val();
            ids.push(id);
        });
            var thisResult = $("#table-IR input:checked");
            var c = confirm('Are you sure to make in-active? \n With Vaccine Type Id: ' +ids);
            if(c) {
                $.ajax({
                    type: "POST",
                    url: "/vaccineType/update/status?ids=" + ids,
                    success: function (){
                        thisResult.closest('tr').find("td:eq(4)").text("In-Active");
                        thisResult.prop("checked", false);
                        alert("Update In-Active Successfully!")
                    },
                    error: function (){
                        alert("Something wrong, can not make In-Active!")
                    }
                })
             }
            return false;
        })



});
