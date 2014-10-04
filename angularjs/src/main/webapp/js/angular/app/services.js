/**
 * Created by swhee_000 on 9/24/2014.
 */
(
    function(){
        var app = angular.module('services', []);
        var baseUrl = "http://localhost:8080/rest-api/user";
        //var baseUrl = "http://www.mypitech.com:8080/rest-api/user";
        app.service(
            "userService",
            function($http, $q){
                return({
                    createUser: createUser,
                    getUsers: getUsers,
                    deleteUser: deleteUser,
                    updateUser: updateUser
                } );

                function deleteUser(id){
                    var request = $http({
                        method: "delete",
                        url: baseUrl + "/delete",
                        params: {
                            identity: id
                        }
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function getUsers(){
                    var request = $http({
                        method: "get",
                        url: baseUrl + "/all"
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function createUser(user){
                    var request = $http({
                        method: "post",
                        url: baseUrl + "/create",
                        data: user
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function updateUser(user){
                    var request = $http({
                        method: "put",
                        url: baseUrl + "/update",
                        params: {
                            identity: user.identity
                        },
                        data: user
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function handleError( response ) {
                    if (
                        ! angular.isObject( response.data ) ||
                        ! response.data.message
                        ) {
                        return( $q.reject( "An unknown error occurred." ) );
                    }
                    return( $q.reject( response.data.message ) );
                }
                function handleSuccess( response ) {
                    return( response.data );
                }
            }
        );
    }
)();
