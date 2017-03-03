/*
 * Created by KinderRiven on 2017/3/1.
 */

//node
function Node(id, name, type, modify, info){

    this.id = id;
    this.name = name;
    this.type = type;
    this.modify = modify;
    this.info = info;

}

function sortNodeByType(nodes){
    nodes.sort(function(a, b){

    });
}

function parseXML(xml){

    var root = xml.getElementsByTagName('root')[0];
    var nodes = root.childNodes;
    var ret = [];

    for(var i = 0; i < nodes.length; i++){
        var attrs = nodes[i].childNodes;
        var node = new Node();
        for(var j = 0; j < attrs.length; j++){
            var name = attrs[j].tagName;
            switch (name){
                case 'id' :
                    node.id = attrs[j].childNodes[0].nodeValue;
                    break;
                case 'name':
                    node.name = attrs[j].childNodes[0].nodeValue;
                    break;
                case 'type':
                    node.type = attrs[j].childNodes[0].nodeValue;
                    break;
                case 'modify':
                    node.modify = attrs[j].childNodes[0].nodeValue;
                    break;
                case 'info':
                    node.info = attrs[j].childNodes[0].nodeValue;
                    break;
            }
        }
        ret.push(node);
    }
    //console.log(ret);
    return ret;
}

function getImageByType(type){

    if(type == 'folder')
        return '/resource/sao/icon/file_normal.png';
    else if(type == 'jpg' || type == 'png' || type == 'gif')
        return '/resource/sao/icon/file_normal.png';
    else if(type == 'txt' || type == 'pdf' || type == 'doc')
        return '/resource/sao/icon/Media/landskape_normal.png';
    else if(type == 'back')
        return '/resource/sao/icon/System/back_normal.png';
    else
        return '/resource/sao/icon/help_normal.png';
}

function updateFileFrame(data){

    var frame = document.getElementById("file-table-body");
    var nodes = parseXML(data);
    var html = '';

    //nodes.sort(nodes);

    var build_item = '';
    build_item += '<div class="file-table-body-item" id="add-folder-item">';
    build_item += '<div class="item-fname">';
    build_item += '<img src="/resource/sao/icon/folder_normal.png">';
    build_item += '<input id="add-folder-name" type="text"/>';
    build_item += '<img id="add-folder-ok" src="/resource/sao/icon/add_normal.png">';
    build_item += '<img id="add-folder-cancel" src="/resource/sao/icon/remove_normal.png"></div>';
    build_item += '<div class="item-fsize"><span></span></div>';
    build_item += '<div class="item-fdate"> <span></span> </div> </div>';

    html += build_item;

    for(var i = 0; i < nodes.length; i++){
        var item = '';
        item += '<div class="file-table-body-item">';
        //name
        item += '<div class="item-fname" fid="' + nodes[i].id  +'" ftype="'
            + nodes[i].type + '">';
        //icon
        var img = '<img src="' + getImageByType(nodes[i].type) + '">';
        item += img;
        //name
        var name = '<span class="file-name">' + nodes[i].name + '</span>';
        item += name;
        //option box
        var op = '<div class="fname-op-box">'
            + '<img src="/resource/sao/icon/modify_normal.png">'
            + '<img src="/resource/sao/icon/appearance_normal.png">'
            + '<img src="/resource/sao/icon/remove_normal.png"></div>';

        if(i != 0) {item += op;}
        item += '</div>';

        //size
        var size = '<div class="item-fsize"><span>-</span> </div>';
        item += size;

        //time
        var modify = '<div class="item-fdate"><span>2017-02-28 18:23</span> </div>';
        item += modify;
        item += '</div>';

        html += item;
    }
    frame.innerHTML = html;
    addFunction();
}

function addFunction(){

    $('.item-fname').click(function(){
        var fid = $(this).attr('fid');
        var type = $(this).attr('ftype');
        if((type == 'folder' || type == 'back') && fid != '-1') {
            current_id = fid;
            getNodeList(fid);
        }
    });

    //隐藏工具栏
    $('.fname-op-box').hide();

    //隐藏文件夹添加
    $('#add-folder-item').hide();

    //工具栏响应
    $('.item-fname').mouseover(function(){
        var op = this.getElementsByClassName('fname-op-box');
        $(op).show();
    });

    $('.item-fname').mouseleave(function(){
        var op = this.getElementsByClassName('fname-op-box');
        $(op).hide();
    });

    //添加文件夹事件
    $('#add-folder').click(function(){
        $('#add-folder-item').show();
    });

    $('#add-folder-ok').click(function(){
        var name = $('#add-folder-name').val();
        addNewFolder(name);
    });

    $('#add-folder-cancel').click(function(){
        $('#add-folder-item').hide();
    });

}

function getRootNode(){
    $.ajax({
        url: '/get_root.action',
        type: 'post',
        timeout : 1000,
        dataType : 'json',
        success: function (data) {
            //console.log("获取文件根目录成功");
            root_id = data['root_id'];
            current_id = root_id;
            //成功后拉取一下根目录列表
            getNodeList(root_id);
        },
        error: function(data) {
            console.log("获取文件根目录失败");
        }
    });
}

function addNewFolder(name) {

    $.ajax({
        url: '/add_folder.action',
        type: 'post',
        timeout : 1000,
        dataType : 'json',
        data : {
            'folder_name' : name,
            'current_id' : current_id
        },
        success: function (data) {
            getNodeList(current_id);
        },
        error: function(data) {

        }
    })
}

function getNodeList(node_id) {

    $.ajax({
        url : '/get_node.action',
        type: 'post',
        timeout: 1000,
        dataType : 'xml',
        data :{
          'node_id' : node_id
        },
        success: function(data){
            //console.log("拉取文件列表成功");
            //console.log(data);
            upload_frame_init('form-zh');
            updateFileFrame(data);
        },
        error: function(data){
            console.log("拉取文件列表失败");
            //console.log(data);
        }
    });
}

$(document).ready(function () {
    getRootNode();
});