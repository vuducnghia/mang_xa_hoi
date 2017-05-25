(function() {
    'use strict';

    angular
        .module('lab1App')
        .controller('ProfileDialogController', ProfileDialogController);

    ProfileDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'DataUtils', 'entity', 'Profile', 'User'];

    function ProfileDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, DataUtils, entity, Profile, User) {
        var vm = this;

        vm.profile = entity;
        vm.clear = clear;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        vm.save = save;
        vm.users = User.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.profile.id !== null) {
                Profile.update(vm.profile, onSaveSuccess, onSaveError);
            } else {
                Profile.save(vm.profile, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('lab1App:profileUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


        vm.setAnhbia = function ($file, profile) {
            if ($file && $file.$error === 'pattern') {
                return;
            }
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        profile.anhbia = base64Data;
                        profile.anhbiaContentType = $file.type;
                    });
                });
            }
        };

        vm.setAnhdaidien = function ($file, profile) {
            if ($file && $file.$error === 'pattern') {
                return;
            }
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        profile.anhdaidien = base64Data;
                        profile.anhdaidienContentType = $file.type;
                    });
                });
            }
        };

        vm.setAnhcanhan = function ($file, profile) {
            if ($file && $file.$error === 'pattern') {
                return;
            }
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        profile.anhcanhan = base64Data;
                        profile.anhcanhanContentType = $file.type;
                    });
                });
            }
        };

    }
})();
