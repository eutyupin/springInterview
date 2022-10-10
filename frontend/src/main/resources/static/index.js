angular.module('Students', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8189/student-back/student')
            .then(function (response) {
                $scope.students = response.data;
            });
    };

    $scope.deleteStudent = function (id) {
        $http.delete('http://localhost:8189/student-back/student/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createStudent = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/student-back/student', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    }

    $scope.fillTable();
});