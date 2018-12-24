App.controller('catController',
    ['$scope', '$rootScope', 'catService', '$http', function ($scope, $rootScope, catService, $http) {

        $scope.cat = {name: '', pict: ''};

        $scope.upload = function () {
            var cat = $scope.cat;
            catService.saveCat(cat)
                .then(
                    function () {
                        alert("file uploaded successfully.");
                        $http.get(urls.CAT_URL + 'upload').then(
                            function (response) {
                                $rootScope.catList = response;
                            });
                    },
                    function (errResponse) {

                    }
                );
        }
    }
    ]);


App.constant('urls', {
    CAT_URL: 'http://localhost:8080/cat/'
});

App.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

App.run(function ($rootScope, $http, urls) {
    $http.get(urls.CAT_URL + 'upload').then(
        function (response) {
            $rootScope.catList = response.data;
        });
});
