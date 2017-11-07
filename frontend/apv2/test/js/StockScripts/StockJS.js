var app = angular.module('myApp', [], function($interpolateProvider) {
    $interpolateProvider.startSymbol('<%');
    $interpolateProvider.endSymbol('%>');
});
app.controller('myCtrl', function($scope, $http) {
    $scope.product_Array = [];
    $scope.outlet_stock = [];
    $scope.product_stock = [];

    $scope.updateProductStock = function() {
        $http.get('outletById', { params: { product_id: product_select.value } }).
        then(function(response){
            $scope.outlet_stock = response.data;
        }, function(error) {
            console.log(error);
        });
    };

    $scope.updateOutletStock = function() {
        $http.get('productById', { params: { outlet_id: outlet_select.value } }).
        then(function(response){
            $scope.product_stock = response.data;
        }, function(error) {
            console.log(error);
        });
    };
});
