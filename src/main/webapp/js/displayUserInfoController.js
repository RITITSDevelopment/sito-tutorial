var app = angular.module('sitoSandbox');
	
app.controller('DisplayUserInfoController', function($routeParams, httpService) {
	var self = this;

	self.firstName = $routeParams.firstName;
	self.lastName = $routeParams.lastName;
	self.occupation = $routeParams.occupation;
	self.displayType = $routeParams.displayType;
	self.user = {};

	self.resultPromise = httpService.basic('services/displayUser', {
		firstName: self.firstName,
		lastName: self.lastName,
		occupation: self.occupation
	});
		
	self.resultPromise.then(function(data) {
		self.user.firstName = data.firstName;
		self.user.lastName = data.lastName;
		self.user.occupation = data.occupation;
	}, function(data) {
		console.log("An error occurred");
	});
});