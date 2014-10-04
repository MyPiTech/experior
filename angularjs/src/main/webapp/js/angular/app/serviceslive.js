/**
 * Created by swhee_000 on 9/24/2014.
 */
(
    function(){
        var app = angular.module('services', []);
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
                        url: "http://www.mypitech.com:8080/rest-api/user/delete",
                        params: {
                            identity: id
                        }
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function getUsers(){
                    var request = $http({
                        method: "get",
                        url: "http://www.mypitech.com:8080/rest-api/user/all"
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function createUser(user){
                    var request = $http({
                        method: "post",
                        url: "http://www.mypitech.com:8080/rest-api/user/create",
                        data: user
                    });
                    return( request.then( handleSuccess, handleError ) );
                }

                function updateUser(user){
                    var request = $http({
                        method: "put",
                        url: "http://www.mypitech.com:8080/rest-api/user/update",
                        params: {
                            identity: user.id
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
