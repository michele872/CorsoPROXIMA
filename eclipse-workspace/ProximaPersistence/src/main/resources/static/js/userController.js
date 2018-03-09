app.controller('userController', function($scope, $http, $location, $route) {
	var id = 5;
    $http({
            method : 'GET',
            url : 'http://localhost:8080/api/user/' + id
    }).then(function(response) {
            $scope.users = response.data;
    });
    $scope.editUser = function(id) {
            $location.path("/update-user/"+id);
    } 
//    .then(
//            function(response) {
//            	$location.path("/list-user");
//                $route.reload();
//            });
    });