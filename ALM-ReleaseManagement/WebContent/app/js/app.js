var sampleApp = angular.module('sampleApp', []);
 
sampleApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/newrelease', {
        templateUrl: '../app/partials/newrelease.html',
       controller: '' 
    }).
      when('/searchrelease', {
        templateUrl: '../app/partials/searchrelease.html',
        controller: 'getReleaseData'
      }).
      when('/newiteration', {
          templateUrl: '../app/partials/newiteration.html',
          controller: ''
        }).
       when('/searchiteration', {
            templateUrl: '../app/partials/searchiteration.html',
            controller: 'getIterationData'
          }).
      otherwise({
        redirectTo: '/'
      });
}]);