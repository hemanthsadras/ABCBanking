 $(document).ready(function() {
	
     var baseUrl = "http://localhost:8080/";
	 
     $("#nonuser").on('click', function(){
    	
    	 window.location = "account.html";
     });
     
     $("#proceed").on('click', function() {
    	 var emailId = $("#email").val();
    	 
    	 if(emailId != null && emailId != "") {
    		 var resturi = baseUrl + "customer/email/" + emailId + "/";
    		 
    		 $.ajax({
 				type : "GET",
 				url : resturi,
 				success : function(customer) {
 					if(customer != "") {
 						 
 				    	 var url = baseUrl + "admin/bankService";
 				    	 $.ajax({
 								type : "GET",
 								url : url,
 								success : function(services) {
 									function ServiceViewModel(bankServices) {
 							    		 var self = this;
 							    		 self.services = bankServices
 							    	 };
 									var viewModel = new ServiceViewModel(services);
 									ko.applyBindings(viewModel);
 									$("#serviceDialog").modal('show');
 									
 									$("#generateToken").on('click', function() {
 										var loggedInCustomer = customer;
 										var bankService = new Object();
 										bankService.bankServiceName = $("#services option:selected").text();
 										bankService.bankServiceId = $("#services option:selected").val();
 										
 										var token = new Object();
 										token.customerId = loggedInCustomer.id;
 										token.customerType = loggedInCustomer.customerType;
 										token.tokenStatus = "InProgress";
 										token.bankService = bankService;
 										
 										generateToken(token);
 										
 									});
 								},
 								error : function(result) {
 									alert("error");
 								}
 							});
 					}
 					else {
 						alert("Invalid email id");
 					}
 				},
 				error : function(result) {
 					alert("Error");
 				}
 			});
    	 }
    	 else {
    		 alert("please enter the email id");
    	 }
    	 
     });
     
     
     function generateToken(token) {
    	 alert(token.tokenStatus);
     }
 });