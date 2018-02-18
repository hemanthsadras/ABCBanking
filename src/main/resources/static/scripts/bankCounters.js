 $(document).ready(function() {
	
     var baseUrl = "http://localhost:8080/";
	 drawBankServicesTable();
	 
     $("#bankCounterTable").on('click',  'span.deleteBtn',function(data) {
			
			var bankServiceTable = $("#bankCounterTable").DataTable();
			var counterId = bankServiceTable.row($(this).parents('tr')).data().counterId;
			var resturi = baseUrl + "/admin/bankCounter/" + counterId;
			$.ajax({
				type : "DELETE",
				url : resturi,
				row : this,
				success : function(result) {
					bankServiceTable.row($(this.row).parents('tr'))
				     					.remove()
				     					.draw();
				},
				error : function(result) {
					alert("error");
				}
			});
			
		});
     
     
     $("#newBankCounterBtn").on('click', function(data) {
    	 var counterName = $("#counterName").val();
    	 var counterServiceid = $("#counterService option:selected").val();
    	 var counterServiceName = $("#counterService option:selected").text();
    	 var counter = new Object();
    	 counter.bankCounterName = counterName;
    	 counter.bankService = new Object();
    	 counter.bankService.bankServiceName = counterServiceName;
    	 counter.bankService.bankServiceId = counterServiceid;
    	 
    	 var resturi = baseUrl + "admin/bankCounter";
    	 
    	 $.ajax({
				type : "POST",
				url : resturi,
				data : JSON.stringify(counter),
				contentType : "application/json",
				success : function(result) {
					var bankServiceTable = $("#bankCounterTable").DataTable();
					bankServiceTable.row.add(result).draw();
				},
				error : function(result) {
					alert("error");
				}
			});
    	 
     });
     
     $("#addBankCounterBtn").on('click', function(event) {
    	 function ServiceViewModel(bankServices) {
    		 var self = this;
    		 self.services = bankServices
    	 };
    	 var resturi = baseUrl + "admin/bankService";
    	 $.ajax({
				type : "GET",
				url : resturi,
				success : function(result) {
					var viewModel = new ServiceViewModel(result);
					ko.applyBindings(viewModel);
					$("#newBankCounter").modal('show');
				},
				error : function(result) {
					alert("error");
				}
			});
    	 
    	 
    	 
     });
     
     
     
     function drawBankServicesTable() {
    	 var resturi = baseUrl + "/admin/bankCounter";
			$.ajax({
				url : resturi,
				success : function(result) {
					$('#bankCounterTable').DataTable({
						"destroy" : true,
						"language": {
	  					      "emptyTable": "No Counters are added"
	  					    },
						"aaData" : result,
					    "bAutoWidth" : false,
					     "columns" : [
					    	 {
					    		 data : "bankCounterName"
					    	 },
					    	 {
					    		 data : "bankService.bankServiceName"
					    	 },
					    	 {
					    		 data : "customerQueue.length" 
					    	 },
					    	 {
					    		 data : null,
					    		 render : function() {
					    			 return '<span class="glyphicon glyphicon-trash inlineBtn deleteBtn"></span>';
					    		 }
					    	 }
					    
					    	 
					     ]
					});
				}
			});
	
     }
     
     
 });