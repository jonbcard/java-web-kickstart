var app = angular.module('app', [])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl',
                reloadOnSearch: false
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);