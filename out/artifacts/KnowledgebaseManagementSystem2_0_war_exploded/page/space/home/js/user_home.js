/**
 * Created by KinderRiven on 2017/4/7.
 */

function getBookSet(){

    $.ajax({
        url: '/get_book_set.action',
        type: 'post',
        timeout : 10000,
        dataType : 'json',
        data : {
        },
        success: function (data) {
            console.log(data);
            updateCreateSet(data);
        },
        error: function(data) {
        }
    });

}

function updateCreateSet(data){

    var c_set_list = document.getElementById('u_book_set');
    c_set_list.innerHTML = '';
    var item;

    for(var i = 0; i < data.length; i++){
        item =  '<div class="u_book_item" sid="' + data[i].id + '">';
        item += '<div class="u_book_img">';

        item += '<div class="u_book_info">';
        item += '<div class="u_book_collect">收藏：';item += data[i].collect;item += '</div>';
        item += '</div>';
        item += '<img src="/resource/image/set/'+ data[i].id + '.jpg">';
        item += '</div>';
        item += '<div class="u_book_title">' + data[i].name + '</div>';
        item += '</div>';

        c_set_list.innerHTML += item;
    }

    $(".u_book_item").click(function(){
        var sid = $(this).attr('sid');
        window.location.href = "/page/set/html/set.html?sid=" + sid;
    });
}

function updateUserInfo(){

    var uid = getCookieParam('id');
    var img = '<img src="/resource/image/user/' + uid + '.jpg">';
    document.getElementById('u_img').innerHTML = img;
}

$(document).ready(function(){

    getBookSet();
    updateUserInfo();

    $('.m_container').hide();
    $('.m_container').fadeIn(500);

    $("#c_set_btn").click(function(){

        var set_name = $("#set_name").val();
        var set_description = $("#set_description").val();

        console.log(set_name + ' ' + set_description);

        $.ajax({
            url: '/create_book_set.action',
            type: 'post',
            timeout : 10000,
            dataType : 'json',
            data : {
                'set_name' : set_name,
                'set_description' : set_description
            },
            success: function (data) {
                if(data['result'] == 'yes') {
                    alert('创建成功');
                    getBookSet();
                    $("#create_book").modal('hide');
                }
                else
                    alert('创建失败');
            },
            error: function(data) {
                alert('创建失败');
            }
        });
    });
});