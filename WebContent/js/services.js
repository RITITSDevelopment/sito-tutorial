var app = angular.module('sitoSandbox');

app.service('httpService', function($http, $q){
		function basic(url, params){
			var deferredAbort = $q.defer();
		
			var request = $http({
				method: 'GET', 
				url: url,
				params: params,
				timeout: deferredAbort.promise
			});
	
			var promise = request.then(
					function(response){
						console.log(response.data)
						return( response.data );
					},
					function( response ){
						return($q.reject());
					});
		
			promise.abort = function(){
				deferredAbort.resolve();
			}
		
			promise['finally'](
					function(){
						console.info("Cleaning up all references");
						promise.abort = angular.noop;
						deferredAbort = request = promise = null; 
					});
				
			return(promise);
	}
	
		return({
			basic: basic
	});
});