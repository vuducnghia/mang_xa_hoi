(function() {
    'use strict';

    angular
        .module('lab1App')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state'];

    function HomeController ($scope, Principal, LoginService, $state) {
        var vm = this;
        vm.ten = 'Vu Duc Nghia';
        vm.diachi = 'Ha Noi';
        vm.sdt = '0966192144';
        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        vm.user = {
            ten : 'Vu Duc Nghia',
            diachi : 'so 1 dai co viet, hai ba trung, ha noi',
            sdt : '0966192144',
            tieusu : 'Elayne Roskin has been active in the real estate industry for more than twenty-five years and has been a top broker with Brown Harris Stevens since 1998. She serves both buyers and sellers who rely on her depth of experience to properly advise on pricing and her exceptional ability to close transactions. Elayne is known to use her clients time efficiently and is highly regarded for her courtesy and discretion. Her comprehensive knowledge of the Manhattan real estate market is so well known that she has often been called upon as an expert third party to provide market evaluations to parties in dispute or hoping to avoid dispute. Her business is primarily based on referrals from former customers and clients. Growing up, real estate was the center of Elaynes family life. Her grandfather was a real estate investor - one of his colleagues was William Zeckendorf Sr. and all of his sons are real estate landlords, developers and investors.',
            icon : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
            anhdaidien : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
            anhbia : 'https://phunudep.com/wp-content/uploads/2015/11/chum-anh-nhung-thanh-pho-ve-dem-hinh-2.jpg',
            anhcanhan : 'https://photos.zillowstatic.com/h_g/ISivf8rs1sy1d41000000000.jpg',
            experience : [
                {title : 'Human Resources Manager', detail : 'Bách Khoa Computer', time : 'Nov 2014 – Mar 2016', icon : 'https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAKiAAAAJGUzMWIxOTM4LTI4NjQtNDk4OC1iMTM4LTI2N2U2ZDBiZTRjNw.png'},
                {title : 'Human Resources Manager', detail : 'Bách Khoa Computer', time : 'Nov 2014 – Mar 2016', icon : 'https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAWeAAAAJDY5MWU1MzRiLWNlZWUtNGUwZC05OGMyLWM1ZmExYmE3NzRiNQ.png'}
            ],
            skill : [
                {title : 'Human Resources Manager', detail : 'Bách Khoa Computer', time : 'Nov 2014 – Mar 2016', icon : 'https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAKiAAAAJGUzMWIxOTM4LTI4NjQtNDk4OC1iMTM4LTI2N2U2ZDBiZTRjNw.png'},
                {title : 'Human Resources Manager', detail : 'Bách Khoa Computer', time : 'Nov 2014 – Mar 2016', icon : 'https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAWeAAAAJDY5MWU1MzRiLWNlZWUtNGUwZC05OGMyLWM1ZmExYmE3NzRiNQ.png'}
            ],
            education : [
                {title : 'Human Resources Manager', detail : 'Bách Khoa Computer', time : 'Nov 2014 – Mar 2016', icon : 'https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAKiAAAAJGUzMWIxOTM4LTI4NjQtNDk4OC1iMTM4LTI2N2U2ZDBiZTRjNw.png'},
                {title : 'Human Resources Manager', detail : 'Bách Khoa Computer', time : 'Nov 2014 – Mar 2016', icon : 'https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAWeAAAAJDY5MWU1MzRiLWNlZWUtNGUwZC05OGMyLWM1ZmExYmE3NzRiNQ.png'}
            ]
        };
        vm.active = [
            {
                icon : 'https://scontent.fhan2-1.fna.fbcdn.net/v/t1.0-9/11147851_640945929379585_7471981798980814430_n.jpg?oh=b077455a036bcfd8cdf9a72db0547cd6&oe=597BD131',
                time : '3 days ago',
                title : 'List group item heading'
            },
            {
                icon : 'https://scontent.fhan2-1.fna.fbcdn.net/v/t1.0-9/11147851_640945929379585_7471981798980814430_n.jpg?oh=b077455a036bcfd8cdf9a72db0547cd6&oe=597BD131',
                time : '3 days ago',
                title : 'List group item heading'
            }
        ];
        vm.baiviets = [
            {
                user : 'Vu Duc Nghia',
                diachi : 'so 1 dai co viet, hai ba trung, ha noi',
                noidung : 'A good example is eating out. We have all seen those restaurants with waiters inviting you in. This is a typical tourist trap. Do not go there! They will overcharge you because your waiter speaks perfect English with you. Go look for some place where locals eat! Don’t be afraid to ask for recommendations! Research it, check Google maps, travel forums, blogs. There is a really high competition out there, and because you are just passing by, they wouldn’t care to please you, like they would with a local (who might come back next Friday).',
                image : 'https://external.fhan3-1.fna.fbcdn.net/safe_image.php?d=AQC4STCQsEPyEgoO&w=476&h=249&url=http%3A%2F%2Ftopit.vietnamworks.com%2Fblogs%2Fwp-content%2Fuploads%2F2017%2F04%2Fcoer-1200x600.jpg&cfs=1&upscale=1&sx=27&sy=0&sw=1147&sh=600&_nc_hash=AQA84ZwABxYc0w5t',
                icon : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                like : 3,
                comments : [
                    {
                        noidung : 'Thấy 1 số bạn có ý định lập ngân hàng CV. Đợi mãi chả thấy contact gì. Làm luôn đây. Để lại email, skype muốn tham gia. Thảo luận điều kiện trước, cùng đóng góp. Phương thức là Drop box, sẽ share cho các bạn tham gia. Tạm thời An làm người điều phối. Bạn nào đóng góp (số lượng sẽ trao đổi qua skype),có đóng góp tài nguyên là có thể sử dụng. Ai ngồi mát ăn bát vàng kiếu dùm. Deadline 17g00 16/4/2017 tuỳ theo số lượng người join sẽ lập nhóm chat skype bàn luận. Nhóm kín ko public nên chọn lọc người tham gia. TOGETHER WE WILL WIN',
                        icon_comment : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                        reply : [
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'nghia dep trai'
                            },
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'dajskdjkasd dsnajdnjas dsa sjadjkan dsa dsd snd sajfn fnjnf nklsdm a kmds wrj  jiod nadksadoosja n asj jaifj '
                            },
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'dajskdjkasd dsnajdnjas dsasdj  ksajkda dsjajda dsjkdnjasndna sdajsdn;asd asdnasdansa sjadjkan dsa dsd snd sajfn fnjnf nklsdm a kmds wrj  jiod nadksadoosja n asj jaifj '
                            }
                        ]
                    },
                    {
                        noidung : 'Thấy 1 số bạn có ý định lập ngân hàng CV. Đợi mãi chả thấy contact gì. Làm luôn đây. Để lại email, skype muốn tham gia. Thảo luận điều kiện trước, cùng đóng góp. Phương thức là Drop box, sẽ share cho các bạn tham gia. Tạm thời An làm người điều phối. Bạn nào đóng góp (số lượng sẽ trao đổi qua skype),có đóng góp tài nguyên là có thể sử dụng. Ai ngồi mát ăn bát vàng kiếu dùm. Deadline 17g00 16/4/2017 tuỳ theo số lượng người join sẽ lập nhóm chat skype bàn luận. Nhóm kín ko public nên chọn lọc người tham gia. TOGETHER WE WILL WIN',
                        icon_comment : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                        reply : [
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'nghia dep trai'
                            },
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'nghia dep trai'
                            }
                        ]
                    }
                ]
            },
            {
                user : 'Vu Duc Nghia',
                diachi : 'so 1 dai co viet, hai ba trung, ha noi',
                noidung : 'A good example is eating out. We have all seen those restaurants with waiters inviting you in. This is a typical tourist trap. Do not go there! They will overcharge you because your waiter speaks perfect English with you. Go look for some place where locals eat! Don’t be afraid to ask for recommendations! Research it, check Google maps, travel forums, blogs. There is a really high competition out there, and because you are just passing by, they wouldn’t care to please you, like they would with a local (who might come back next Friday).',
                image : 'https://media.licdn.com/media-proxy/ext?w=760&h=380&f=n&hash=dPAQSeCu%2FafzziPyLkVG5Sy1jg0%3D&ora=1%2CaFBCTXdkRmpGL2lvQUFBPQ%2CxAVta5g-0R6plxVUww4y9KuCpUG550YJS4fITXfhRnb1pJHVPjP2PIeDJuP150IUeC0GjwQ3YIr6FXL_ccbgfeXxCZ4ozc67c47nK1BQOQRl3TkB5sE8',
                icon : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                like : 3,
                comments : [
                    {
                        noidung : 'Bạn nào đóng góp (số lượng sẽ trao đổi qua skype),có đóng góp tài nguyên là có thể sử dụng. Ai ngồi mát ăn bát vàng kiếu dùm. TOGETHER WE WILL WIN',
                        icon_comment : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                        reply : [
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'nghia dep trai'
                            },
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'dajskdjkasd dsnajdnjas dsa sjadjkan dsa dsd snd sajfn fnjnf nklsdm a kmds wrj  jiod nadksadoosja n asj jaifj '
                            },
                            {
                                icon_reply : 'https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/16143251_243445579433382_3707113243765607493_n.jpg?oh=88789e05ca545cd76476a55d60207857&oe=59814345',
                                noidung : 'dajskdjkasd dsnajdnjas dsasdj  ksajkda dsjajda dsjkdnjasndna sdajsdn;asd asdnasdansa sjadjkan dsa dsd snd sajfn fnjnf nklsdm a kmds wrj  jiod nadksadoosja n asj jaifj '
                            }
                        ]
                    }
                ]
            }
        ];
        vm.review = [
            {noidung : 'Mike Wald and his team, Hayden Wald and Ashley Bryan, were a pleasure to work with We had a great experience with them as we went through the process ofselling our home. They were all very responsive, honest, and most helpful. Wewould definitely recommend!'},
            {noidung : 'Mike Wald and his team, Hayden Wald and Ashley Bryan, were a pleasure to work with We had a great experience with them as we went through the process ofselling our home. They were all very responsive, honest, and most helpful. Wewould definitely recommend!'},
            {noidung : 'lal la lala'}
        ];
        vm.dangbai = function(){
            var baiviet = angular.copy(vm.baiviets[0]) ;
            baiviet.noidung = vm.noidung;
            vm.baiviets.push(baiviet);
        };

        vm.submitComment = function (index) {
            var x = angular.copy(vm.baiviets[0].comments[0]);
            x.noidung = vm.textComment[index];
            vm.baiviets[index].comments.push(x);
            vm.textComment[index]='';
        };

        vm.submitReply = function (index, indexParent) {
            alert(index);
            var x = angular.copy(vm.baiviets[0].comments[0].reply[0]);
            x.noidung = vm.textReply[indexParent][index];
            vm.baiviets[indexParent].comments[index].reply.push(x);
            vm.textReply[index]='';
        };
        vm.textOverview = vm.user.tieusu;
        vm.submitOverview = function () {
            vm.user.tieusu = vm.textOverview;
            $('.bg-edit').removeClass('bg-edit1');
            $('.addOverview').removeClass('edit2');
            $('.blur').css({'filter': 'blur(0px)'});
        };
        vm.submitReview = function () {
            var x = angular.copy(vm.review[0]);
            x.noidung = vm.textReview;
            vm.review.push(x);
            vm.textReview = '';
            $('.bg-edit').removeClass('bg-edit1');
            $('.addReview').removeClass('edit2');
            $('.blur').css({'filter': 'blur(0px)'});
        };
        vm.likeBaiviet = function (index) {
            vm.baiviets[index].like ++;   // tạm thời chưa làm bỏ like vì backed k rõ ràng
        }








        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }
        function register () {
            $state.go('register');
        }


    }
})();
