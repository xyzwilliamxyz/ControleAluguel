'use strict';

angular.module('controle-aluguel')

.controller('pessoaListController', ['$location', '$scope', 'loadAction', function($location, $scope, loadAction) {
    $scope.pessoas = [];
    
    loadAction('pessoa')
    .then(function(res) {
        $scope.pessoas = res;
    });
    
    $scope.goToDetails = function(pessoaId) {
        $location.url('/pessoa/edit/' + pessoaId);
    }
}]);