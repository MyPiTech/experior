/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */
(
    function(){
        var app = angular.module('application', ['navigation']);

        app.directive('mainHeader', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/main-header.html'
            };
        });
        app.directive('mainSidebar', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/main-sidebar.html'
            };
        });
        app.directive('mainFooter', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/main-footer.html'
            };
        });
        app.directive('mainContent', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/main-content.html'
            };
        });

        /*app.controller('UserController', ['$http', function($http){
            var controller = this;
            controller.users = [];
            alert('here');
            $http.get('http://localhost:8080/client-api/client/getAll').error(function(data, status, headers, config){
                alert('error');
                alert('data: ' + data);
                alert('status: ' + status);

            });
           $http.get('http://localhost:8080/client-api/client/getAll').success(function(data){
                alert('success');
                controller.users = data;
            });
        }]);*/
    }
)();


/*
['$http', function($http){
    var getAllClientsUrl = 'http://localhost:8080/client-api/client/getAll';
    var controller = this;
    controller.users = [];
    $http.get(getAllClientsUrl).success(function(data){
        //alert('here');
        controller.users = data;
    });
}]*/
