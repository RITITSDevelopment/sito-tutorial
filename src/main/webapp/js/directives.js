var app = angular.module('sitoSandbox');

app.directive('autocomplete', function() {
	function link($scope, element, attrs) {
		element.autocomplete({
			source: airports
		});
	}
	
	return {
		restrict: 'AEC',
		link: link
	}
});