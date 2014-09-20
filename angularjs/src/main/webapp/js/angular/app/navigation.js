/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */
(
    function(){
        var app = angular.module('navigation', []);
        app.controller('PageController', function(){
            this.page = 'home';
            this.setPage = function(page){this.page=page;};
            this.isPage = function(page){return this.page===page;};
        });

        app.directive('topNav', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/top-nav.html'
            };
        });
    }
)();
