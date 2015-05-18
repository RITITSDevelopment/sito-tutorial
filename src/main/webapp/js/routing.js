var app = angular.module('sitoSandbox');
		
app.config(function ($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl: 'partials/index.html',
		controller: 'IndexController as indexCtrl'
	}).when('/hello', {
		templateUrl: 'partials/hello.html',
		controller: 'HelloController as helloCtrl'
	}).when('/displayUserInfo', {
		templateUrl: 'partials/userInfo.html',
		controller: 'DisplayUserInfoController as userInfoCtrl'
	}).when('/loadUserForm', {
		templateUrl: 'partials/userForm.html',
		controller: 'LoadUserFormController as userFormCtrl'
	}).when('/displayList', {
		templateUrl: 'partials/showUsers.html',
		controller: 'DisplayListController as displayListCtrl'
	}).when('/metar', {
		templateUrl: 'partials/metar.html',
		controller: 'MetarController as metarCtrl'
	}).otherwise({ redirectTo: '/index' });
});