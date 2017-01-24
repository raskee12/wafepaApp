var wafepaApp = angular.module('wafepaApp', ['ngRoute']);


// BIBLIOTEKA CONTROLLER
wafepaApp.controller('bibliotekaCtrl', function($scope, $http, $location){

$scope.brojacStranice = 0;

var getBooks = function(){

    var config = {'params':{'page':$scope.brojacStranice}};

    if($scope.form && $scope.form.select && $scope.form.input){
        if($scope.form.select == "name") {
            config.params.name = $scope.form.input;
        } else {
            config.params.isbn = $scope.form.input;
        }
    }

    $http.get('/api/books', config).then(function(resp){
        $scope.books = resp.data;
        $scope.totalPages = Number(resp.headers().totalpages);
        console.log($scope.totalPages);
    });
};

    getBooks();

$scope.editBook = function(book) {
    $location.path('/book/'+book.bookID);
}

$scope.deleteBook = function(bookID) {
    $http.delete('/api/books/'+bookID).then(getBooks);
};

$scope.changePage = function(i) {
    if($scope.brojacStranice >= 0) {
        $scope.brojacStranice += i;
    }
    getBooks();
};

$scope.search = getBooks;

});

// BOOK CONTROLLER
wafepaApp.controller('bookCtrl', function($scope, $http, $location, $routeParams){

    var getBook = function(){
        $http.get('/api/books/'+$routeParams.id).then(function(resp){
            $scope.book = resp.data;
        });
    };

    var getIterableAuthors = function(){
        $http.get('/api/authors').then(function(resp){
            $scope.iterAuthors = resp.data;
        });
    };

        getBook();
        getIterableAuthors();

});



wafepaApp.config(function($routeProvider) {
    $routeProvider
        //http://localhost:8080/static/app/html/index.html/#!/
        .when("/", {
          templateUrl : '/static/app/html/partials/home.html'
        })
        .when("/biblioteka", {
          templateUrl : '/static/app/html/partials/biblioteka.html'
        })
        .when("/book/:id", {
          templateUrl : '/static/app/html/partials/book.html'
        })
        //http://localhost:8080/static/app/html/index.html/#!/activities
        .when('/activities', {
         templateUrl : '/static/app/html/partials/activities.html'
       })
        //http://localhost:8080/static/app/html/index.html/#!/activity
        .when('/activity/:id', {
         templateUrl : '/static/app/html/partials/activity.html'
       })
        //sve ostalo radi redirekciju na
        //http://localhost:8080/static/app/html/index.html/#!/
        .otherwise({
         redirectTo: '/'
       });
});
