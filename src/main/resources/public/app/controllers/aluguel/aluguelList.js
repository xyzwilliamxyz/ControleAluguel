'use strict';

angular.module('controle-aluguel')

.controller('aluguelListController', ['$location', '$scope', 'loadAction', function($location, $scope, loadAction) {
    $scope.pessoas = [];
    
    loadAction('aluguel')
    .then(function(res) {
        $scope.aluguels = res;
    });
    
    $scope.goToDetails = function(aluguelId) {
        $location.url('/aluguel/edit/' + aluguelId);
    }
}]);