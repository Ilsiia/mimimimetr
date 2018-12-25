<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="voteApp" lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Mimimimetr</title>
    <link rel="stylesheet" href="/css/styles/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles/app.css">
</head>
<body ng-controller="voteController" class="ng-cloak">
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Кто мимимишнее?</span></div>
        <div class="tablecontainer">
            <div ng-repeat="cat in twoCat">
                <br><br>
                <img width="300" data-ng-src="data:image/png;base64,{{cat.pict}}" ng-click="incRating(cat.id)"/>
                <br><br>
                <button class="button-link" ng-click="incRating(cat.id)">
                    {{cat.name}}
                </button>
                <br><br>
            </div>
        </div>
    </div>
</div>
<script src="/lib/jquery-2.2.1.min.js"></script>
<script src="/lib/bootstrap.min.js"></script>
<script src="/lib/angular.min.js"></script>
<script src="/js/voteapp/vService.js"></script>
<script src="/js/voteapp/app.js"></script>
</body>
</html>
