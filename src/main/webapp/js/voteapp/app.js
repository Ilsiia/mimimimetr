App.run(function ($rootScope, $http, urls) {
    $http.get(urls.VOTE_URL).then(
        function (response) {
            $rootScope.index = 0;
            $rootScope.catRandomeList = response.data;
            $rootScope.twoCat = ($rootScope.catRandomeList)[0];
        });
});
App.controller('voteController',
    ['$scope', '$rootScope', 'vService', function ($scope, $rootScope, vService) {

        $scope.incRating = function (catId) {
            vService.incRating(catId);
            var i = $rootScope.index + 1;
            if (i < ($rootScope.catRandomeList).length) {
                $rootScope.twoCat = ($rootScope.catRandomeList)[i];
                $rootScope.index = i;
            } else {
                window.location.replace('/result');
            }
        }
    }
    ]);

App.constant('urls', {
    VOTE_URL: '/vote/'
});
