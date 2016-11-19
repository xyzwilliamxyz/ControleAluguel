'use strict';

angular.module('controle-aluguel')

.controller('pessoaSaveController', ['$routeParams', '$scope', 'saveAction', 'loadAction', 'notificationService', '$location', 
function($routeParams, $scope, saveAction, loadAction, notificationService, $location) {
    
    var pessoaId = $routeParams.pessoaId;
    $scope.pessoa = {};
    
    if (pessoaId) {
        
        loadAction('pessoa/' + pessoaId)
        .then(function(res) {
            $scope.pessoa = res;
        });
    }
    
    $scope.savePessoa = function() {
        
        saveAction('pessoa', $scope.pessoa)
        .then(function(res) {
            $scope.pessoas = res;
            notificationService.simpleNotification('Pessoa salva com sucesso!', 'success');
            $location.path('pessoa');
        });
    };
    
    $scope.cancel = function() {
        $location.path('pessoa');
    }
    
}]);