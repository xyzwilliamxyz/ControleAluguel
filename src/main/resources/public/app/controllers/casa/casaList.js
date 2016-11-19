'use strict';

angular.module('controle-aluguel')

.controller('casaListController', ['$location', '$scope', 'loadAction', function($location, $scope, loadAction) {
    $scope.casas = [];
    
    loadAction('casa')
    .then(function(res) {
        $scope.casas = res;
    });
    
    $scope.goToDetails = function(casaId) {
        $location.url('/casa/edit/' + casaId);
    }
    
}]);