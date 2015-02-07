var app = angular.module('sitoSandbox');
		
app.controller('HelloController', function($routeParams) {
	var self = this;
	self.message = $routeParams.message;
});