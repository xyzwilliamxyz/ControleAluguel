'use strict';

angular.module('controle-aluguel')

    .service('notificationService', ['LxNotificationService', function(LxNotificationService) {

        var self = this;

        self.simpleNotification = function(message, type) {

            if (type === 'info') {
                    LxNotificationService.info(message);
            } else if (type === 'success') {
                LxNotificationService.success(message);
            } else if (type === 'warning') {
                LxNotificationService.warning(message);
            } else if (type === 'error') {
                    
                if (typeof message === 'string') {
                    LxNotificationService.error(message);
                } else {
                    var parsedMessage = '';
                    var errors = message.data.errors;
                    for (var i = 0; i < errors.length; i++) {
                        parsedMessage += errors[i] + '<br />';
                    }

                    LxNotificationService.error(parsedMessage);
                }
            }
        }
    }])

