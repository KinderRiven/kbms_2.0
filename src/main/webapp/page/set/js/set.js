/* Created by KinderRiven on 2017/4/9. */

var sid;
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

function getSetContent(){

    sid = GetQueryString('sid');
    console.log(sid);

    $.ajax({
        url: '/get_set_content.action',
        type: 'post',
        timeout : 10000,
        dataType : 'json',
        data : {
            'set_id' : sid
        },
        success: function (data) {
            console.log(data);
            updateSetContent(data);
        },
        error: function(data) {
        }
    });
}

function updateSetContent(data){

    var set_content = document.getElementById('set_content');
    set_content.innerHTML = '';

    var set_item;
    for(var i = 0; i < data.length; i++){

        set_item =  '<tr>';
        set_item += '<td>' + (i + 1) + '</td>';
        set_item += '<td>' + data[i].name + '</td>';

        set_item += '<td>' + '1MB' + '</td>';

        var time = new Date(data[i].buildTime).Format("yyyy-MM-dd");
        set_item += '<td>' + time + '</td>';

        set_item += '</tr>';
        set_content.innerHTML += set_item;
    }
}

function getSetInfo() {

    var sid = GetQueryString('sid');
    console.log(sid);

    $.ajax({
        url: '/get_set_info.action',
        type: 'post',
        timeout : 10000,
        dataType : 'json',
        data : {
            'set_id' : sid
        },
        success: function (data) {
            console.log(data);
            updatSetInfo(data);
        },
        error: function(data) {
        }
    });
}

function updatSetInfo(data){

    document.getElementById('set_name').innerHTML = data.name;
    document.getElementById('set_description').innerHTML = '书单描述：' + data.description;
    var img = '<img src="/resource/image/set/' + sid + '.jpg" id="user-img" sid="' + sid + '">';
    document.getElementById('s_img').innerHTML = img;
}

$(document).ready(function(){
    getSetContent();
    getSetInfo();

    $('.m_container').hide();
    $('.m_container').fadeIn(300);
});