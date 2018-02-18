 $(document).ready(function() {
	
     var baseUrl = "http://localhost:8080/";
	 
     $("#createAccount").on('click', function() {
    	var name = $("#name").val();
    	var emailId = $("#email").val();
    	var customerType = $("#customerType option:selected").text();
    	
    	if((name != "" && name != null) && (emailId != null && emailId != null)) {
    		var customer = new Object();
        	customer.name = name;
        	customer.emailId = emailId;
        	customer.customerType = customerType;
        	
        	
        	
        	var resturi = baseUrl + "customer";
        	$.ajax({
    			type : "POST",
    			url : resturi,
    			data : JSON.stringify(customer),
    			contentType : "application/json",
    			success : function(result) {
    				window.alert = "Account created successfully";
    				window.location = "kiosk.html";
    			},
    			error : function(result) {
    				alert("error");
    			}
    		});
    		
    	}
    	else {
    		alert("please fill all the properties in the form");
    	}
     });
 });