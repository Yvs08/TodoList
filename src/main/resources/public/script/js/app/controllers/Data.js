

mainApp.controller('dataController', function ($scope, $http) {
    $scope.plop = {};

    $scope.plop = {
        state: 'done'

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

});








