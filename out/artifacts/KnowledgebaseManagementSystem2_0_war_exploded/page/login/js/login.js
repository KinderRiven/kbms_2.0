/*Created by KinderRiven on 2017/3/3.*/
function postLoginForm(){

    var username = document.getElementById('user_name').value;
    var password = document.getElementById('user_password').value;
    console.log(username + ' ' + password);

    $.ajax({
        url: '/user_login.action',
        type: 'post',
        timeout : 10000,
        dataType : 'json',
        data : {
            'user_name' : username,
            'user_password' : password
        },
        success: function (data) {
            //登陆成功重定向
            console.log(data['result']);
            if(data['result'] == 'yes') {
                window.location.href = "/page/space/upload/html/upload.html";
                console.log('登录成功');
                console.log(document.cookie);
            } else{
                alert('账号密码错误!');
            }
        },
        error: function(data) {
            console.log('登录失败');
        }
    });
}

$(document).ready(function(){

    $('form').hide();
    $('form').fadeIn(1000);

});