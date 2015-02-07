var app = angular.module('sitoSandbox');

app.controller('DisplayListController', function(httpService) {
	var self = this;
	self.users = new Array();

	self.resultPromise = httpService.basic('services/displayList', {});	
	self.resultPromise.then(function(data) {
		angular.forEach(data, function(user) {
			self.users.push(user);
		});
	}, function(data) {
		console.log("An error occurred");
	});
});