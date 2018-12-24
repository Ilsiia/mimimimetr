<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="resultApp" lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Mimimimetr</title>
    <link rel="stylesheet" href="../../static/css/styles/bootstrap.min.css">
    <link rel="stylesheet" href="../../static/css/styles/app.css">
</head>
<body ng-controller="catController" class="ng-cloak">
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Добавить конкурсанта</span></div>
        <div class="formcontainer">
            <form ng-submit="upload()" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Имя</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="cat.name" name="name"
                                   class="form-control input-sm" placeholder="Введите кличку кота"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Фото</label>
                        <div class="col-md-7">
                            <input type="file" file-model="cat.pict" name="pict"
                                   class="form-control input-sm"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Добавить" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </form>
        </div>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Топ 10</span></div>
            <div class="tablecontainer">
                <table class="table table-hover auto-index">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Фото</th>
                        <th>Имя</th>
                        <th>Рейтинг</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="cat in catList">
                        <td></td>
                        <td><img width="300" data-ng-src="data:image/png;base64,{{cat.pict}}"/></td>
                        <td><span ng-bind="cat.name"></span></td>
                        <td><span ng-bind="cat.rating"></span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="../../static/lib/jquery-2.2.1.min.js"></script>
<script src="../../static/lib/bootstrap.min.js"></script>
<script src="../../static/lib/angular.min.js"></script>
<script src="../../static/js/resultapp/catService.js"></script>
<script src="../../static/js/resultapp/app.js"></script>
</body>
</html>
