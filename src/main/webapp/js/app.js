var app = angular.module('sitoSandbox', ['ngRoute', 'ngAnimate']);
		
app.config(function ($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl: 'js/index/index.html',
		controller: 'IndexController as indexCtrl'
	}).when('/hello', {
		templateUrl: 'js/hello/hello.html',
		controller: 'HelloController as helloCtrl'
	}).when('/displayUserInfo', {
		templateUrl: 'js/displayUserInfo/userInfo.html',
		controller: 'DisplayUserInfoController as userInfoCtrl'
	}).when('/loadUserForm', {
		templateUrl: 'js/loadUserForm/userForm.html',
		controller: 'LoadUserFormController as userFormCtrl'
	}).when('/displayList', {
		templateUrl: 'js/displayList/showUsers.html',
		controller: 'DisplayListController as displayListCtrl'
	}).when('/metar', {
		templateUrl: 'js/metar/metar.html',
		controller: 'MetarController as metarCtrl'
	}).otherwise({ redirectTo: '/index' });
});