'use strict';
var App = angular.module('resultApp', []);

App.factory('catService', ['$http', '$q', 'urls', function ($http, $q, urls) {

    var factory = {
        saveCat: saveCat
    };
    return factory;

    function saveCat(cat) {
        var deferred = $q.defer();
        var formData = new FormData();
        formData.append('pict', cat.pict);
        formData.append('name', cat.name);

        $http.post(urls.CAT_URL + 'save', formData, {
            transformRequest: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        })
            .then(
                function (response) {
                    deferred.resolve(response);
                },
                function (errResponse) {
                    alert(errResponse.data.errorMessage);
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}
]);