var app = angular.module('sitoSandbox');

app.controller('MetarController', function($routeParams, httpService) {
	var self = this;
	
	self.location = $routeParams.location;
	self.metar = {};
		
	self.resultPromise = httpService.basic('services/metar', {
		location: self.location});

	self.resultPromise.then(function(data) {
		self.metar.temp = data.temp;
		self.metar.windSpeed = data.windSpeed;
		self.metar.windDir = data.windDir;
		self.metar.elevation = data.elevation;
	}, function(data) {
		console.log("An error occurred");
	});
});