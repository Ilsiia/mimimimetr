App.controller('catController',
    ['$scope', '$rootScope', 'catService', '$http', 'urls', function ($scope, $rootScope, catService, $http, urls) {

        $scope.cat = {name: '', pict: ''};

        $scope.save = function () {
            var cat = $scope.cat;
            catService.saveCat(cat).then(
                function () {
                    alert("cat saved successfully.");
                    $http.get(urls.CAT_URL).then(
                        function (response) {
                            $rootScope.catList = response.data;
                        });
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
    $http.get(urls.CAT_URL).then(
        function (response) {
            $rootScope.catList = response.data;
        });
});
