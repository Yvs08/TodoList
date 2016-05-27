
'use strict';


/**
 * Déclaration de l'application routeApp
 */
var routeApp = angular.module('routeApp', [
    // Dépendances du "module"
    'ngRoute',
    'routeAppControllers'
]);

var routeAppControllers = angular.module('routeAppControllers', []);


// Contrôleur de la page de delete
routeAppControllers.controller('homeCtrl', ['$scope','$http',
    function ($scope, $http) { 
         $scope.plop = {};

        $scope.plop = {
            state: 'todo' 

        };
    
    
     $scope.submitForms = function () {
        console.log("posting data....");
        var formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/deletetodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {

                });
    };
}
]);

// Contrôleur de la page de validation
routeAppControllers.controller('contactCtrl', ['$scope','$http',
    
   function ($scope, $http) { 
         $scope.plop = {};

        $scope.plop = {
            state: 'todo' 

        };
    
       $scope.submitFormse = function () {
        console.log("posting data....");
       var  formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/validatetodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {

                });
    };
}
]);


routeAppControllers.controller('contactadd', ['$scope','$http',
    function ($scope, $http) {

        $scope.plop = {};

        $scope.plop = {
            state: 'todo' 

        };

        $scope.submitForm = function () {
            console.log("posting data....");
            var formData = $scope.plop;
            console.log(formData);
            var addUrl = 'http://localhost:8080/addtodobyforms';
            $http.post(addUrl, formData)
                    .success(function ( ) {

                    });
        };



    }
]);

routeAppControllers.controller('contactad', ['$scope','$http',
    function ($scope,$http) {
        $scope.submitFormular1 = function () {
        console.log("posting data....");
        var formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/searchtodobyforms';
        $http.post(addUrl, formData)
                .success(function (response ) {

                    $scope.plo = response;

                });
    };

    }
]);

routeAppControllers.controller('contactad1', ['$scope','$http',
    function ($scope,$http ) {
        $scope.submitFormular4 = function () {
        console.log("posting data....");
        var formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/sorttodobyforms';
        $http.post(addUrl, formData)
                .success(function ( response) {

                     $scope.sort = response;

                });
    };

    }
]);
routeAppControllers.controller('contactad2', ['$scope','$http',
    function ($scope,$http) {
        var url = "http://localhost:8080/todo"
        
         $http.get(url).success( function(response) {
               $scope.plopes = response;
            });
        
//      $scope.plopes = [ { number: 1, title: "yves", dateDeadline:"12" , description:" 11", startDate:"d",state:"1"}]; 
        
        
    }
]);



routeApp.config(['$routeProvider',
    function ($routeProvider) {

        // Système de routage
        $routeProvider
                .when('/delete', {
                    templateUrl: 'views/delete.html',
                    controller: 'homeCtrl'
                })
                .when('/validate', {
                    templateUrl: 'views/validate.html',
                    controller: 'contactCtrl'
                })

                .when('/add', {
                    templateUrl: 'views/index2.html',
                    controller: 'contactadd'
                })
                .when('/search', {
                    templateUrl: 'views/searchTodo.html',
                    controller: 'contactad'
                })
                .when('/sort', {
                    templateUrl: 'views/sortTodo.html',
                    controller: 'contactad1'
                })
                .when('/list', {
                    templateUrl: 'views/listTodo.html',
                    controller: 'contactad2'
                })
                .otherwise({
                    redirectTo: '/add'
                });

    }
]);