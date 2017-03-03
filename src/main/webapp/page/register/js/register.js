/*Created by KinderRiven on 2017/3/3.*/

$(document).ready(function(){

    $('#btn-submit').click(function(){

        var username = document.getElementById('user_name').value;
        var password = document.getElementById('user_password').value;
        var re_password = document.getElementById('re_password').value;
        var nickname = document.getElementById('nick_name').value;

        $.ajax({
            url: '/user_register.action',
            type: 'post',
            timeout : 1000,
            dataType : 'json',
            data : {
                'user_name' : username,
                'user_password' : password,
                'nick_name' : nickname
            },
            success: function (data) {
                console.log('注册成功');
                //登陆成功重定向
                window.location.href='/page/login/html/login.html';
            },
            error: function(data) {
                console.log('注册失败');
            }
        });
    });
});
