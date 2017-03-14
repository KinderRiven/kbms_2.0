/**
 * Created by KinderRiven on 2017/3/6.
 */

var s_result;
function postQuery2(){

    var search_value = document.getElementById('search-input').value;
    $.ajax({
        url: '/doc_search.action',
        type: 'post',
        timeout : 10000,
        dataType : 'json',
        cache : false,
        data : {
            'search_value':search_value
        },
        success: function (data) {
            console.log('查询成功');
            console.log(data);
            updateLeftContainer(data);
        },
        error: function(data) {
            console.log('查询失败');
        }
    });
}

function updateLeftContainer(data){

    var leftContainer = document.getElementById('left-container');
    leftContainer.innerHTML = '';

    var html = '', item;
    for(var i = 0; i < data.length; i++){

        item  = '';
        item  = '<div class="container-item">';
        item += '<div class="container-item-title">';
        //label
        item += '<span class="label label-default">最新</span>';

        //name
        if(data[i].hlName.length != 0)
            item += ('<span class="item-title-text">' + data[i].hlName + '</span>');
        else
            item += ('<span class="item-title-text">' + data[i].name + '</span>');
        item += '</div>';
        item += '<div class="container-item-content clearfix">';
        item += ('<div class="container-item-img">' + '<img src="/resource/icon/txt.jpg">' + '</div>');
        item += '<div class="container-item-text">';
        if(data[i].hlContent.length > 0)
            item += ('<p>' + data[i].hlContent + '</p>');
        else
            item += ('<p>' + data[i].content + '</p>');
        item += '</div></div>';
        //span
        item += '<div class="container-item-foot clearfix">';
        item += '<div class="item-mark">';
        var tags = data[i].tags;
        for(var j = 0; j < tags.length; j++){
            item += ('<span class="label label-primary">' + tags[j] +'</span>');
        }
        item += '</div>';

        item += '<div class="item-opt">';
        item += '<span class="label label-danger">下载:18</span>';
        item += '<span class="label label-danger">收藏:22</span>';
        item += '</div>';
        item += '</div>';

        item += '</div>';
        html += item;
    }

    leftContainer.innerHTML = html;

    //特技
    $('.container-item').hide();
    $('.container-item').fadeIn(1000);

}

function getSearchList(start, end){

    $.ajax({
        url : '/query_list.action',
        type: 'post',
        timeout: 10000,
        dataType : 'json',
        data :{
            'start': start,
            'end' : end
        },
        cache : false,
        success: function(data){
            //console.log("拉取文件列表成功");
            console.log(data);
            updateLeftContainer(data);
        },
        error: function(data){
            console.log("拉取文件列表失败");
            //console.log(data);
        }
    });
}

$(document).ready(function(){
    getSearchList(0, 8);
});