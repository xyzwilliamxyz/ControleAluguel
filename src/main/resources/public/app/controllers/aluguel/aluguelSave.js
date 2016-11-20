'use strict';

angular.module('controle-aluguel')

.controller('aluguelSaveController', ['LxDialogService', '$filter', '$routeParams', '$scope', 'saveAction', 'loadAction', 'notificationService', '$location', 
function(LxDialogService, $filter, $routeParams, $scope, saveAction, loadAction, notificationService, $location) {
    
    var aluguelId = $routeParams.aluguelId;
    $scope.aluguel = {
        'casa': {},
        'pessoas': [],
        'pessoaSelecionada': {}
    };
    
    $scope.tiposPessoa = [
        {'id': 1, 'descricao': 'Locador'},
        {'id': 2, 'descricao': 'Locatário'},
        {'id': 3, 'descricao': 'Fiador'},
        {'id': 4, 'descricao': 'Filho'}
    ];
    
    if (aluguelId) {
        
        loadAction('aluguel/' + aluguelId)
        .then(function(res) {
            $scope.aluguel = res;
            
            $scope.dataInicioFormatted = $filter('date')(res.dataInicio, "dd/MM/yyyy");
            $scope.dataTerminoFormatted = $filter('date')(res.dataTermino, "dd/MM/yyyy");
        });
    }
    
    $scope.saveAluguel = function() {
        
        saveAction('aluguel', $scope.aluguel)
        .then(function(res) {
            $scope.aluguels = res;
            notificationService.simpleNotification('Aluguel salvo com sucesso!', 'success');
            $location.path('aluguel');
        });
    };
    
    loadAction('casa')
    .then(function(res) {
        $scope.casas = res;
    });
    
    loadAction('pessoa')
    .then(function(res) {
        $scope.pessoas = res;
    });
    
    $scope.cancel = function() {
        $location.path('aluguel');
    }
    
    $scope.openDialog = function() {
        
        $scope.aluguel.pessoaSelecionada = null;
        
        LxDialogService.open('add-pessoa');
    }
    
    $scope.addPessoa = function(pessoaSelecionada) {
        
        if (!pessoaSelecionada) {
            notificationService.simpleNotification('Pessoa não selecionada.', 'error');
            return ;
        }
        
        if (!pessoaSelecionada.tipo) {
            notificationService.simpleNotification('Tipo de pessoa não selecionado.', 'error');
            return ;
        }
        
        var alreadySelected = false;
        for (var i = 0; i < $scope.aluguel.pessoas.length; i++) {
            
            if (pessoaSelecionada.pessoaId == $scope.aluguel.pessoas[i].pessoaId) {
                alreadySelected = true;
                break;
            }
        }
        if (alreadySelected) {
            notificationService.simpleNotification('Pessoa já adicionada.', 'error');
            return ;
        }
        
        pessoaSelecionada.tipo = $scope.aluguel.pessoaSelecionada.tipo.id;
        $scope.aluguel.pessoas.push(pessoaSelecionada);
        
        LxDialogService.close('add-pessoa');
    }
    
    $scope.getTipoPessoa = function(tipoPessoa) {
        
        return $scope.tiposPessoa[tipoPessoa - 1].descricao;
    }
    
    $scope.removePessoa = function(pessoaId) {
        
        for (var i = 0; i < $scope.aluguel.pessoas.length; i++) {
            
            if (pessoaId === $scope.aluguel.pessoas[i].pessoaId) {
                $scope.aluguel.pessoas.splice(i, 1);
                break;
            }
        }
    }
    
}]);