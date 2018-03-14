app.controller('insertQuestionController', function($scope, $http, $location,
  $route) {
  $http({
    method: 'GET',
    url: '/api/questionCategory/'
  }).then(function(response) {
    $scope.questionCategories = angular.fromJson(response.data);
    console.log($scope.questionCategories);
  });
  $scope.submitQuestionForm = function() {
    console.log($scope.question);
    $http({
      method: 'POST',
      url: '/api/question/',
      data: $scope.question,
    }).then(function(response) {
      // Inserimento POST di QuestionTag se non dovesse funzionare JOIN
      $location.path("/list-all-questions");
      $route.reload();
    }, function(errResponse) {
      $scope.errorMessage = errResponse.data.errorMessage;
    });
  }
  $scope.resetForm = function() {
    $scope.question = null;
  };
});
