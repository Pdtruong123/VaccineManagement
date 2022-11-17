$(window).on('load', function(event) {
    	$('body').removeClass('preloading');
    	$('.loader').delay(1).fadeOut('fast');
    	
    var x = location.href;
	
//	if(x.includes('http://localhost:8080/vaccineType') ){
//		
//		var y = document.getElementById("design1");
//  		y.style.color = "#4154f1";
//	}
//	if(x.includes('http://localhost:8080/vaccineType') ){
//		
//		var y = document.getElementById("design2");
//  		y.style.color = "#4154f1";
//	}
//	if(x.includes('http://localhost:8080/vaccineType') ){
		
//		var y = document.getElementById("design3");
 // 		y.style.color = "#4154f1";
//	}
	if(x.includes('http://localhost:8080/vaccineType/') ){
		
		var y = document.getElementById("design4");
  		y.style.color = "#4154f1";
	}
	if(x.includes('http://localhost:8080/vaccine/') ){
		
		var y = document.getElementById("design5");
  		y.style.color = "#4154f1";
	}
	//if(x.includes('http://localhost:8080/vaccineType') ){
		
	//	var y = document.getElementById("design6");
  //		y.style.color = "#4154f1";
//	}
//	if(x.includes('http://localhost:8080/vaccineType') ){
//		
//		var y = document.getElementById("design7");
 // 		y.style.color = "#4154f1";
//	}
//	if(x.includes('http://localhost:8080/vaccineType') ){
		
//		var y = document.getElementById("design8");
 // 		y.style.color = "#4154f1";
	//}
	if(x.includes('http://localhost:8080/report') ){
		
		var y = document.getElementById("design9");
  		y.style.color = "#4154f1";
	}
    	
    });


