$(document).ready(function(){
	$.validator.addMethod("greaterThanToday", function (value, element) {
        return new Date().setHours(0,0,0,0) <= Date.parse(value);
    }, "Please input Date of vaccination with value greater or equal the current date");
    $("#formUpdate").validate({
        rules: {
			id: {
				required: true,
				maxlength: 10,
				number: true,
				max: 9999999999,
			},
			vaccineName: {
				required: true,
				maxlength: 50,
			},
			usage: {

				maxlength: 200,
			},
			timeBeginNextInjection: {
				greaterThanToday: true,
			},
			timeEndNextInjection: {
				greaterThanToday: true,
			},
			indication: {

				maxlength: 200,
			},
			contraindication: {

				maxlength: 200,
			},
			numberOfInjection: {
				required: true,
				number: true,
				max: 15,
			},
			origin: {
				maxlength: 50,
			},
		},
		message: {
			id: {
				required: "Pls input id of vaccine",
				maxlength: "Pls input id of vaccine must at least 10c",
				number: "Pls input number of injection must is number",
				max: "Pls input number of injection must small than 9999999999",
			},
			vaccineName: {
				required: "Pls input name of vaccine",
				maxlength: "Pls input name of vaccine must at least 50c",
			},
			usage: {

				maxlength: "Pls input usage of vaccine must at least 200c",
			},
			indication: {

				maxlength: "Pls input usage of vaccine must at least 200c",
			},
			contraindication: {

				maxlength: "Pls input usage of vaccine must at least 200c",
			},
			numberOfInjection: {
				required: "Pls input number of injection",
				number: "Pls input number of injection must is number",
				max: "Pls input number of injection must small than 15",
			},
			origin: {

				maxlength: "Pls input origin of vaccine must at least 50c",
			},
		}
	})
})

function submitValidate(){
	var dateStart =	new Date($("#vaccine-time-next-injection").val());
	var dateEnd = new Date($("#vaccine-time-end-injection").val());
	
	if(dateStart < dateEnd){
		if ($("#formUpdate").valid()) {
		return true;
        }else{
            return false;
        }
	}else{
		
		$("#timeError").html("<span class='error'>Time begin is before time end</span>");
		
		return false;
		
		}
	
    
    }
function onchangeId(){
	alert("Vaacine Id can't change to update!")
}