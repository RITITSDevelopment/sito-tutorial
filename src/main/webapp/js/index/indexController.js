var app = angular.module('sitoSandbox');
		
app.controller('IndexController', function($location, httpService) {
	var self = this;

	self.message = "";
	self.sendMessage = function() {
		$location.search('message', self.message);
		$location.path('/hello');
	};
	
	self.ajaxUsers = new Array();
	self.retrieveUser = function() {
		self.resultPromise = httpService.basic('services/ajax', {});	
		self.resultPromise.then(function(data) {
			var user = {};
			user.firstName = data.firstName;
			user.lastName = data.lastName;
			user.occupation = data.occupation;

			self.ajaxUsers.push(user);
		}, function(data) {
			console.log("An error occurred");
		});
	};
	
	self.location = "";
	self.sendMetar = function() {
		$location.search('location', self.location);
		$location.path('/metar');
	};
});