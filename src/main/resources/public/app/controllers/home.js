angular.module('controle-aluguel')

.controller('homeController', ['$scope', 'get', function($scope, get) {

	get('/pessoa')
    .then(function(res) {
        $scope.pessoas = res;
    })
    .catch(function(err) {
        
    });
}]);