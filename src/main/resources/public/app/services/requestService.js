var PREFIX_URL = 'http://localhost:8080/api/';

angular.module('controle-aluguel')

.service('get', ['$http', '$q', function($http, $q) {
    
    return function(url) {
        
        var q = $q.defer();
        
        $http.get(PREFIX_URL + url)
        .then(function(res) {
            q.resolve(res.data);
        }, function(err) {
            q.reject(err);
        });
        
        return q.promise;
    }
}])
.service('put', ['$http', '$q', function($http, $q) {
    
    return function(url, json) {
        
        var q = $q.defer();
        
        $http.put(PREFIX_URL + url, json)
        .then(function(res) {
            q.resolve(res.data);
        }, function(err) {
            q.reject(err);
        });
        
        return q.promise;
    }
}])
.service('loadAction', ['get', '$q', 'notificationService', function(get, $q, notificationService) {
    
    return function(url, errorHandlingCb) {
        
        var q = $q.defer();
        
        if (!errorHandlingCb) {
            errorHandlingCb = function(err) {
                notificationService.simpleNotification(err, 'error');
            }
        }
        
        get(url)
        .then(function(res) {
            q.resolve(res);
        })
        .catch(errorHandlingCb);
        
        return q.promise;
    }
}])
.service('saveAction', ['put', '$q', 'notificationService', function(put, $q, notificationService) {
    
    return function(url, json, errorHandlingCb) {
        
        var q = $q.defer();
        
        if (!errorHandlingCb) {
            errorHandlingCb = function(err) {
                notificationService.simpleNotification(err, 'error');
            }
        }
        
        put(url, json)
        .then(function(res) {
            q.resolve(res);
        })
        .catch(errorHandlingCb);
        
        return q.promise;
    }
}])
;