/**
 * Created by KinderRiven on 2017/3/5.
 */

function postQuery(){

    var search_value = document.getElementById('search-input').value;
    $.ajax({
        url: '/doc_search.action',
        type: 'post',
        timeout : 1000,
        dataType : 'json',
        data : {
            'search_value':search_value
        },
        success: function (data) {
            console.log('查询成功');
            console.log(data);
            window.location.href = "/page/list/html/list.html";
        },
        error: function(data) {
            console.log('查询失败');
        }
    });
}

$(document).ready(function(){

    $('body').hide();
    $('body').fadeIn(1000);

    console.log(document.cookie);

    $('#btn-logout').click(function(){
        $.ajax({
            url: '/user_logout.action',
            type: 'post',
            timeout : 1000,
            dataType : 'json',
            cache : false,
            data : {},
            success: function (data) {
                console.log('注销成功');
                window.location.href = "/page/search/html/search.html";
            },
            error: function(data) {
                console.log('注销失败');
            }
        });
    });
});