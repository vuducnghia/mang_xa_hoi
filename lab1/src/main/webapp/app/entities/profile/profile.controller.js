(function() {
    'use strict';

    angular
        .module('lab1App')
        .controller('ProfileController', ProfileController);

    ProfileController.$inject = ['DataUtils', 'Profile'];

    function ProfileController(DataUtils, Profile) {

        var vm = this;

        vm.profiles = [];
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;

        loadAll();

        function loadAll() {
            Profile.query(function(result) {
                vm.profiles = result;
                vm.searchQuery = null;
            });
        }
    }
})();
