(function() {
    'use strict';

    angular
        .module('lab1App')
        .controller('ProfileDetailController', ProfileDetailController);

    ProfileDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Profile', 'User'];

    function ProfileDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Profile, User) {
        var vm = this;

        vm.profile = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('lab1App:profileUpdate', function(event, result) {
            vm.profile = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
