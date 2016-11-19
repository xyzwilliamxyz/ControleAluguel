'use strict';

angular.module('controle-aluguel')

.controller('casaSaveController', ['$routeParams', '$scope', 'loadAction', 'saveAction', 'notificationService', '$location', 
function($routeParams, $scope, loadAction, saveAction, notificationService, $location) {
    
    var casaId = $routeParams.casaId;
    $scope.casa = {
        'endereco': {}
    };
    
    if (casaId) {
        
        loadAction('casa/' + casaId)
        .then(function(res) {
            $scope.casa = res;
        });
    }
    
    $scope.saveCasa = function() {
        
        saveAction('casa', $scope.casa)
        .then(function(res) {
            $scope.casas = res;
            notificationService.simpleNotification('Casa salva com sucesso!', 'success');
            $location.path('casa');
        });
    };
    
    $scope.cancel = function() {
        $location.path('casa');
    }
    
}]);