app.controller('surveyController',
  function($scope, $http, $location, $route) {
	var questions;
	$scope.questions = null;
    $http({
      method: 'GET',
      url: '/api/survey/1'
    }).then(function(response) {
      $scope.survey = response.data;
      console.log("response.data: " + response.data + " - response.data.surveyquestions: " + response.data.surveyquestions);
      $scope.questions = response.data.surveyquestions;
      //questions = JSON.parse(response.data.surveyquestions);
      questions = response.data.surveyquestions;
      
      console.log("questions.length: " + questions.length);

      $scope.starttime = new Date();
      
      
      $scope.show = [];
      
      $scope.previousVisible = false;
      $scope.nextVisible = true;
      $scope.subtVis = false;
      
      console.log("$scope.questions: " + $scope.questions + " - questions: " + questions);
      if (questions!=undefined) {
      	console.log("$scope.questions: " + $scope.questions + " - questions: " + questions);
      	for(var i=0; i < questions.length; i++) {
          	$scope.show[i] = false;
       }
       console.log("$scope.show: " + $scope.show);
       $scope.show[0] = true;
          
          
          
          $scope.checkShowNext = function() {          	
          	for(var i=0; i < $scope.show.length-1; i++) {
          		console.log(i+" "+$scope.show[i]);

          		if($scope.show[i] === true) {
      				console.log("scope.show: " + $scope.show[i]);
      				console.log("i" + i);	
      				$scope.show[i] = false;
          			$scope.show[i+1] = true;
          			
          			console.log("controllo next: " + (i!= $scope.show.length-2));
          			if (i!= $scope.show.length-2 ) {
          		      $scope.nextVisible = true;
          			} else {
          		      $scope.nextVisible = false;
          		      $scope.subtVis = true;
          			}
          			
          			console.log("Controlle PREVIOUS: " + i);
          			$scope.previousVisible = true;
          			break;
          		}
          		
          		
          			
          	}
          }
          
          $scope.checkShowPrevious = function() {
            	
            	for(var i=1; i<$scope.show.length; i++) {
            		console.log("scope.show: " + $scope.show[i]);
            		console.log("i: " + i);
            		if($scope.show[i] === true) {
            			console.log("scope.show[i]: " + $scope.show[i]);
        				console.log("i: "+ i);
        				$scope.show[i] = false;
            			$scope.show[i-1] = true;
          			
            			console.log("controllo previous: " + (i!=0));
              			if (i == 1) {
              		      $scope.previousVisible = false;
              			} else {
              		      $scope.previousVisible = true;
              			}
            			
              			if(i == $scope.show.length-1) {
              				$scope.subtVis = false;
              				$scope.nextVisible = true;
              			}
            			break;
            		}
            }          
        }         
      }
    });
    
    $scope.surveySubmit = function() {
    	$http({
			method : 'POST',
			url : '/api/survey/',
			data : createResponseJSON($scope),
		}).then(function(response) {
			// console.log("$scope.user: " + $scope.user);
			
			$location.path("/response-survey");
			$route.reload();
			
		}, function(errResponse) {
			$scope.errorMessage = errResponse.data.errorMessage;
		});
    }
    
   
    
});

function createResponseJSON($scope) {
	var json = '{';
	json = json + '"surveyId" : ' + $scope.survey.id + ',';
	json = json + '"starttime" : "' + String($scope.starttime) + '",'
				+ '"endtime" : "' + String(new Date()) + '",' 
				+ '"userId" : 5, ';
	json = json + '"replies" : [';
	for(var i=0; i < $scope.questions.length; i++) {
		json = json + '{ "questionId": ' + $scope.questions[i].question.id + ', '
					+ '"answers" : ' + getCheckedBoxes($scope.questions[i].question.id);
		json = json + '},';
	}
	console.log(json.length);
	if(json.length > 1) {
		json = json.substring(0, json.length - 1);
	}
	json = json + '] }';
	console.log(json);
	return json;
}

function getCheckedBoxes(id) {
	  var checkboxes = document.getElementsByName(id);
	  var checkboxesChecked = '[';
	  for (var i=0; i<checkboxes.length; i++) {
	     if (checkboxes[i].checked) {
	        checkboxesChecked = checkboxesChecked + '"' + checkboxes[i].value + '"';
		    checkboxesChecked = checkboxesChecked + ',';
	     }
	  }
	  if(checkboxesChecked.length > 1){
		  checkboxesChecked = checkboxesChecked.substring(0, checkboxesChecked.length - 1);
	  }
	  checkboxesChecked = checkboxesChecked + ']';
	  return checkboxesChecked;
}
