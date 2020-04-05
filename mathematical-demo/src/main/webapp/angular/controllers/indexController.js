app.controller('indexController', function($scope,$http) {
	
	$scope.op01 = false;
	$scope.op02 = false;
	$scope.result = false;
	
	$scope.setOperandInput = function(){
		if($scope.operation == "square"){
			$scope.op01 = true;
			$scope.op02 = false;
		}
		else{
		
				$scope.op01 = true;
				$scope.op02 = true;
			
		}
		
		$scope.operand1 = '';
		$scope.operand2 = '';
		$scope.result = false;
		
		
	};
	
	$scope.calculate = function(){
		
		if($scope.operation == "division" && $scope.operand2==0){
			alert("cannot take 0 as divisor");
			return true;
		}
		
		if($scope.operation == "square"){
			$scope.operand2 = 0;
		}

		$http({
		    method : "POST",
		      url : "calculation/"+$scope.operand1+"/"+$scope.operand2+"/"+$scope.operation
		  }).then(function mySuccess(response) {
		   
		    if((response.data != null)){
		    	$scope.output = response.data;
		    	$scope.result = true;
		    }
		    
		  
		  }, function myError(response) {
			 
		  });
	
	}
	
});