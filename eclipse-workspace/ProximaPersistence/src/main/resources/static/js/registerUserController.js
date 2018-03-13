app.controller('registerUserController', function($scope, $http, $location,
		$route) {

	$scope.submitUserForm = function() {
		$scope.user.regdate = new Date();
		$scope.user.role = 10;
		$http({
			method : 'POST',
			url : '/api/user/',
			data : $scope.user,
		}).then(function(response) {
			// console.log("$scope.user: " + $scope.user);
			$location.path("/list-all-users");
			$route.reload();
		}, function(errResponse) {
			$scope.errorMessage = errResponse.data.errorMessage;
		});
	}
	// console.log("$scope.user: " + $scope.user);
	$scope.resetForm = function() {
		$scope.user = null;
	};

	$scope.checkEmail = function(email) {
		if (email != "") {
			$http({
				method : 'GET',
				url : '/api/user/getUserByEmail/' + email,
			}).then(function(response) {
				console.log("dada");
				$scope.users = response.data;
				if ($scope.users.id != null) {
					console.log("fqwfwqf");
					$scope.emailPresent = true;
					console.log($scope.emailPresent);
				}else{
					$scope.emailPresent = false;
				}
			});
		}

		// console.log("$scope.user.email: " + $scope.user.email);
	}
});