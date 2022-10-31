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

$("#update-button").click(function (){
    $("#table-IR > tbody input:checked").each(function (){
        var id = $(this).val();
        alert(id);
            $.ajax({
                type: "POST",
                url: "/update/injection-result",
                data:{id:id},
                success: function (value){
                    console.log(value)
                    var pre = value.id;
                    $("#section-right").innerHTML = "<div>${success}</div>\n" +
                        "<h1 class=\"text-center\">CREATE INJECTION RESULT</h1>\n" +
                        "<form action=\"${pageContext.request.contextPath}/update/injection-result\" method=\"post\">\n" +
                        "\n" +
                        "    <div class=\"row m-4\">\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"customer\">Customer:</label>\n" +
                        "            <input type=\"hidden\" class=\"form-control\" placeholder=\"--Select Customer\" id=\"customer\" name=\"id\"/>\n" +
                        "        </div>\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"prevention\">Prevention:</label>\n" +
                        "            <select name=\"prevention\" id=\"prevention\" class=\"form-control\">\n" +
                        "                <option label=\"--Select Prevention\" selected value=\"\"/>\n" +
                        "                <c:forEach items=\"${preventionList}\" var=\"pre\">\n" +
                        "                    <option value=\"${pre}\" label=\"${pre}\" />\n" +
                        "                </c:forEach>\n" +
                        "            </select>\n" +
                        "\n" +
                        "        </div>\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"vaccineType\">Vaccine type:</label>\n" +
                        "            <select class=\"form-control\" id=\"vaccineType\" name=\"vaccine\">\n" +
                        "                <option label=\"--Select Vaccine Type\" selected/>\n" +
                        "                <c:forEach items=\"${vaccineList}\" var=\"vaccines\">\n" +
                        "                    <option value=\"${vaccines.id}\" label=\"${vaccines.vaccineName}\" />\n" +
                        "                </c:forEach>\n" +
                        "            </select>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "    <div class=\"row m-4\">\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"injection\">Injection:</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" placeholder=\"\" id=\"injection\" name=\"numberOfInjection\" value='${pre}'/>\n" +
                        "\n" +
                        "        </div>\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"dateOfInjection\">Date of injection:</label>\n" +
                        "            <input type=\"date\" class=\"form-control\" placeholder=\"\" id=\"dateOfInjection\" name=\"injectionDate\"/>\n" +
                        "        </div>\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"nextOfInjection\">Next injection appoinment:</label>\n" +
                        "            <input type=\"date\" class=\"form-control\" placeholder=\"\" id=\"nextOfInjection\" name=\"nextInjectionDate\"/>\n" +
                        "\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "    <div class=\"row m-4\">\n" +
                        "        <div class=\"col form-group\">\n" +
                        "            <label for=\"placeOfinjection\">Place of injection:</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" placeholder=\"--Select place of injection--\" id=\"placeOfinjection\" name=\"injectionPlace\"/>\n" +
                        "\n" +
                        "        </div>\n" +
                        "        <div class=\"col\"></div>\n" +
                        "        <div class=\"col\"></div>\n" +
                        "    </div>\n" +
                        "    <div class=\"form-button\">\n" +
                        "        <button class=\"btn btn-success\" type=\"submit\">Save</button>\n" +
                        "        <button class=\"btn btn-primary\" type=\"reset\">Reset</button>\n" +
                        "        <button class=\"btn btn-warning\" type=\"submit\">Cancel</button>\n" +
                        "    </div>\n" +
                        "</form>"

                    $("#prevention").val(value.prevention);
                    $("#vaccineType").val(value.vaccine.vaccineName);
                    $("#injection").val(value.numberOfInjection);
                    $("#dateOfInjection").val(value.injectionDate);
                    $("#nextOfInjection").val(value.nextInjectionDate);
                    $("#placeOfinjection").val(value.injectionPlace)

                }
            })
    })
})

