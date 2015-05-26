
//Display and edit table
function getIterationData($scope,$http)
{
	$(".container-editIteration").hide();

	/*	var dataService = $resource("http://localhost:8080/ALM-ReleaseManagement/releasemanagement/searchiterations");
	  $scope.jsonobj = dataService.query();*/
	$http.get("http://localhost:8080/ALM-ReleaseManagement/releasemanagement/searchiterations")
	.success(function(response2) {
		$scope.jsonstring = response2;
		$scope.jsonobj = angular.fromJson($scope.jsonstring);
	});
	$scope.edititeration=function(index) {

		$(".container-searchIteration").hide();
		$(".container-editIteration").show(); 	
		var temp=parseInt(index)-1;

		$scope.IterationTitle = $scope.jsonobj[temp].Title;
		$scope.IterationDescription = $scope.jsonobj[temp].Discription;
		$scope.IterationStartDate = $scope.jsonobj[temp].StartDate;
		$scope.IterationEndDate = $scope.jsonobj[temp].EndDate;
		$scope.IterationItems = $scope.jsonobj[temp].Items;			
		$scope.IterationStatus = $scope.jsonobj[temp].Status;
		$scope.IterationType = $scope.jsonobj[temp].Type;	
		$scope.index=$scope.jsonobj[temp].index;
	}

}


function getReleaseData($scope,$http)
{
	$(".container-editrelease").hide(); 

	$http.get("http://localhost:8080/ALM-ReleaseManagement/releasemanagement/searchrelease")
	.success(function(response3) {
		$scope.jsonstring1 = response3;
		$scope.jsonobj1 = angular.fromJson($scope.jsonstring1);
	}); 
	$scope.editrelease=function(index) {

		$(".container-searchrelease").hide();
		$(".container-editrelease").show(); 
		var temp=parseInt(index)-1;
		$scope.index=$scope.jsonobj1[temp].index;
		$scope.ReleaseTitle = $scope.jsonobj1[temp].Title;
		$scope.ReleaseDescription = $scope.jsonobj1[temp].Discription;
		$scope.ReleaseStartDate = $scope.jsonobj1[temp].StartDate;
		$scope.ReleasePlannedDate = $scope.jsonobj1[temp].PlannedDate;
		$scope.ReleaseReleaseDate = $scope.jsonobj1[temp].ReleaseDate;			
		$scope.ReleaseType = $scope.jsonobj1[temp].Type;
		$scope.ReleaseTo = $scope.jsonobj1[temp].To ;	
		$scope.ReleaseItems=$scope.jsonobj1[temp].Items;
		$scope.ReleaseStatus=$scope.jsonobj1[temp].Status;
		$scope.ReleaseManager=$scope.jsonobj1[temp].Manager;
		$scope.ReleaseVersion=$scope.jsonobj1[temp].Version;
		//,,,
	}

}





