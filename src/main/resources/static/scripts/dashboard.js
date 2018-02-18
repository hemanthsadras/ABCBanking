$(document).ready(function(){
	
	  var baseUrl = "http://localhost:8080/";
	  
	  function BankCounterViewModel(counters) {
		  var self = this;
		  self.bankCounters = counters;
	  }
	  
	 var resturi = baseUrl + "admin/bankCounter";
 	 $.ajax({
				type : "GET",
				url : resturi,
				success : function(counters) {
					var bankCounterViewModel = new BankCounterViewModel(counters);
					ko.applyBindings(bankCounterViewModel);
				},
				error : function(result) {
					alert("error");
				}
			});
});