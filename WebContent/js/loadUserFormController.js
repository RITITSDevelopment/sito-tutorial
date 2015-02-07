var app = angular.module('sitoSandbox');
		
app.controller('LoadUserFormController', function($location) {
	var self = this;

	self.firstName = "";
	self.lastName = "";
	self.occupation = "";
	self.displayType = "All Values";
	self.displayUser = function() {
		$location.search('firstName', self.firstName);
		$location.search('lastName', self.lastName);
		$location.search('occupation', self.occupation);
		$location.search('displayType', self.displayType);
		$location.path('/displayUserInfo');
	}
});