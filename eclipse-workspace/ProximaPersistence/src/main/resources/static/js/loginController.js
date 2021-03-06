app.controller('loginController', function($rootScope, $scope,
                $http, $location, $route){
//	$rootScope.authenticated = false ;
//	    console.log("LOGIN CONTROLLER $rootScope.authenticated: " + $rootScope.authenticated);
        $scope.credentials = {};
        $scope.resetForm = function() {
                $scope.credentials = null;
        }
        var authenticate = function(credentials, callback) {
                var headers = $scope.credentials ? {
                        authorization : "Basic "
                                        + btoa($scope.credentials.username + ":"
                                                        + $scope.credentials.password)
                        } : {};
                $http.get('user', {
                        headers : headers
                }).then(function(response) {
                        if (response.data.name) {
                                $rootScope.authenticated = true;
                        } else {
                                $rootScope.authenticated = false;
                        }
                        callback && callback();
                }, function() {
                        $rootScope.authenticated = false;
                        callback && callback();
                });
        }
        authenticate();
        $scope.loginUser = function() {
              authenticate($scope.credentials, function() {
                  if ($rootScope.authenticated) {
                    $location.path("/");
                    $scope.loginerror = false;
                  } else {
                    $location.path("/login");
                    $scope.loginerror = true;
                  }
             });
        };
});