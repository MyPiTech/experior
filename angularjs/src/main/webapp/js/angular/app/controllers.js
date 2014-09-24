/**
 * Created by swhee_000 on 9/24/2014.
 */
(
    function(){
        var app = angular.module('controllers', []);
        app.controller('PageController', function(){
            this.page = 'home';
            this.setPage = function(page){this.page=page;};
            this.isPage = function(page){return this.page===page;};
        });

        app.controller('SubPageController', function(){
            this.page = '1';
            this.setPage = function(page){this.page=page;};
            this.isPage = function(page){return this.page===page;};
        });

        app.controller("HelloFormController", function(){
            this.message = "";
            this.clearMessage = function(){
                this.message = "";
            };
        });

        app.controller(
            "UserController",
            function($scope, userService){

                $scope.users = [];

                $scope.form = {
                    user: {identity: "", name: "", description: ""}
                };

                loadRemoteData();

                $scope.isNewUser = function(){
                    return $scope.form.user.identity === "";
                };

                $scope.clearForm = function(){
                    $scope.form.user = {identity: "", name: "", description: ""};
                };

                $scope.initUpdateForm = function(user){
                    $scope.form.user = user;
                };

                $scope.createUser = function(){
                    userService.createUser($scope.form.user)
                        .then(
                        loadRemoteData,
                        function(errorMessage){
                            console.warn(errorMessage);
                        }
                    );
                    $scope.form.user = {identity: "", name: "", description: ""};

                };

                $scope.updateUser = function(){
                    userService.updateUser($scope.form.user)
                        .then(
                        loadRemoteData,
                        function(errorMessage){
                            console.warn(errorMessage);
                        }
                    );
                    $scope.form.user = {identity: "", name: "", description: ""};
                };

                $scope.deleteUser = function(user){
                    userService.deleteUser(user.identity)
                        .then(loadRemoteData);
                };

                function applyRemoteData( newUsers ) {
                    $scope.users = newUsers;
                }

                function loadRemoteData() {
                    userService.getUsers()
                        .then(
                        function(users){
                            applyRemoteData(users);
                        }
                    )
                }
            }
        )
    }
)();

