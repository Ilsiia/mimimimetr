'use strict';
var App = angular.module('voteApp', []);

App.factory('vService', ['$http', '$q', 'urls', function ($http, $q, urls) {

    return {
        incRating: incRating
    };

    function incRating(catId) {
        var deferred = $q.defer();
        var formData = new FormData();
        formData.append('catId', catId);
        $http.post(urls.VOTE_URL + 'rating', formData, {
            transformRequest: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        })
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}
]);