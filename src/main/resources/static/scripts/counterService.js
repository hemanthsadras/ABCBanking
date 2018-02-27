$(document).ready(function() {
	
	function TokenViewModel(token) {
		var self = this;
		self.customer = ko.observable(token.customer),
		self.bankService = ko.observable(token.bankService),
		self.tokenStatus = ko.observable(token.tokenStatus);
	}
	
	var tokenViewModel = new TokenViewModel({
		customer : {
			name : "",
			emailId : "",
			customerType : ""
		},
		bankService : {},
	
		tokenStatus : ""
	});
	
	ko.applyBindings(tokenViewModel);
	var urlParams = new URLSearchParams(window.location.search);
	var serviceCounterId;
	var baseUrl = "http://localhost:8080/admin/bankCounter/";
	if(urlParams.has("serviceCounterId")) {
		serviceCounterId = urlParams.get("serviceCounterId");
		getCustomerFromQueue(serviceCounterId);
	}
	else {
		alert("please provide service counter id as query parameter");
	}
	
	function getCustomerFromQueue(serviceCounterId) {
		var resturi = baseUrl + serviceCounterId + "/token";
		 $.ajax({
					type : "GET",
					url : resturi,
					success : function(response) {
						tokenViewModel.customer(response.customer);
						tokenViewModel.bankService(response.bankService);
						tokenViewModel.tokenStatus(response.tokenStatus);
						
					},
					error : function(result) {
						alert("error");
					}
			});
	}
	
	$("#processToken").on('click', function() {
		
		var resturi = baseUrl + serviceCounterId + "/token";
		tokenViewModel.tokenStatus($("#tokenStatus option:selected").text());
		
		 $.ajax({
				type : "PUT",
				url : resturi,
				data : ko.toJSON(tokenViewModel),
    			contentType : "application/json",
				success : function(response) {
					getCustomerFromQueue(serviceCounterId);
				},
				error : function(result) {
					alert("error");
				}
		});
	});
	
});