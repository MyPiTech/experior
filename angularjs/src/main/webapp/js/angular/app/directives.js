/**
 * Created by swhee_000 on 9/24/2014.
 */
(
    function(){
        var app = angular.module('directives', []);

        app.directive('mainHeader', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/main-header.html'
            };
        });

        app.directive('mainContent', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/main-content.html'
            };
        });

        app.directive('topNav', function(){
            return{
                restrict: 'E',
                templateUrl: 'directives/top-nav.html'
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
    }
)();