var HUZapp = angular.module('HUZapp', ['ngResource']);

HUZapp.factory('GetMeData', function($resource){
    return $resource('https://api.github.com/repos/angular/angular.js/issues', {})
  })
  
HUZapp.controller('MyCtrl1', ['$scope', 'GetMeData', function($scope, GetMeData) {
    // Instantiate an object to store your scope data in (Best Practices)
    $scope.data = {};
   
    GetMeData.query(function(response) {
      // Assign the response INSIDE the callback
      $scope.data.issues = response;
    });
  }])
  
