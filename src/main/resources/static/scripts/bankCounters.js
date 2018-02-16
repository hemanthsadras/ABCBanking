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
     
     
     $("#newServiceAddBtn").on('click', function(data) {
    	 var serviceName = $("#serviceName").val();
    	 var serviceDescription = $("#serviceDescription").val();
    	 var service = new Object();
    	 service.bankServiceName = serviceName;
    	 service.bankServiceDescription = serviceDescription;
    	 
    	 var resturi = baseUrl + "admin/bankService";
    	 
    	 $.ajax({
				type : "POST",
				url : resturi,
				data : JSON.stringify(service),
				contentType : "application/json",
				success : function(result) {
					var bankServiceTable = $("#bankServiceTable").DataTable();
					bankServiceTable.row.add(result).draw();
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