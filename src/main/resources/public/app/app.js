angular.module('controle-aluguel', [
	'lumx',
	'ngRoute',
    'angularUtils.directives.dirPagination'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  
    when('/aluguel/add/', {templateUrl: 'app/views/aluguel/aluguelSave.html', controller: 'aluguelSaveController'}).
    when('/aluguel/edit/:aluguelId', {templateUrl: 'app/views/aluguel/aluguelSave.html', controller: 'aluguelSaveController'}).
    when('/aluguel', {templateUrl: 'app/views/aluguel/aluguelList.html', controller: 'aluguelListController'}).
  
    when('/pessoa/add', {templateUrl: 'app/views/pessoa/pessoaSave.html', controller: 'pessoaSaveController'}).
    when('/pessoa/edit/:pessoaId', {templateUrl: 'app/views/pessoa/pessoaSave.html', controller: 'pessoaSaveController'}).
    when('/pessoa', {templateUrl: 'app/views/pessoa/pessoaList.html', controller: 'pessoaListController'}).
  
    when('/casa/add/', {templateUrl: 'app/views/casa/casaSave.html', controller: 'casaSaveController'}).
    when('/casa/edit/:casaId', {templateUrl: 'app/views/casa/casaSave.html', controller: 'casaSaveController'}).
    when('/casa', {templateUrl: 'app/views/casa/casaList.html', controller: 'casaListController'}).
  
	when('/', {templateUrl: 'app/views/home.html', controller: 'homeController'}).
	otherwise({redirectTo: '/'});
}]).
config(function(paginationTemplateProvider) {
    paginationTemplateProvider.setPath('app/templates/pagination.tpl.html');
});