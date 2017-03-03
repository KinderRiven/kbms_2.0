/**
 * Created by KinderRiven on 2017/3/3.
 */


$(document).ready(function(){

    $('#btn-submit').click(function(){

        var username = document.getElementById('user_name').value;
        var password = document.getElementById('user_password').value;

        $.ajax({
            url: '/user_login.action',
            type: 'post',
            timeout : 1000,
            dataType : 'json',
            data : {
                'user_name' : username,
                'user_password' : password
            },
            success: function (data) {
                console.log('登录成功');
                console.log(document.cookie);
                //登陆成功重定向
                window.location.href="/page/space/upload/html/upload.html";
            },
            error: function(data) {
                console.log('登录失败');
            }
        });
    });
});