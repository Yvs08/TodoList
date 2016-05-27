

/* global mainApp */

mainApp.controller('dataController', function ($scope, $http) {
    $scope.plop = {};

    $scope.plop = { 
        state: 'todo'

    };

    $scope.submitForm = function () {
        console.log("posting data....");
        formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/addtodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {
  
                });
    };


    $scope.submitForms = function () {
        console.log("posting data....");
        formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/deletetodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {

                });
    };

    $scope.submitFormse = function () {
        console.log("posting data....");
        formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/validatetodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {

                });
    };


    $scope.submitFormular1 = function () {
        console.log("posting data....");
        formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/searchtodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {

                   

                });
    };

   


    $scope.submitFormular3 = function () {
        var url = 'http://localhost:8080/todo';

        $http.get(url).success(function (response) {
            $scope.plopes = response;
        });
    }

    $scope.submitFormular4 = function () {
        console.log("posting data....");
        formData = $scope.plop;
        console.log(formData);
        var addUrl = 'http://localhost:8080/sorttodobyforms';
        $http.post(addUrl, formData)
                .success(function ( ) {

                    

                });
    };


    


});








