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

function updateFileFrame(data){

    var frame = document.getElementById("file-table-body");
    var nodes = parseXML(data);
    var html = '';

    for(var i = 0; i < nodes.length; i++){
        var item = '';
        item += '<div class="file-table-body-item">';

        //name
        item += '<div class="item-fname" ' + 'fid="' + nodes[i].id  +'" ftype="'
            + nodes[i].type + '"' + '>';
        //var checkbox = '<span><input type="checkbox"/></span>';
        var img ='<span><img src="/resource/sao/icon/help_normal.png"></span>';
        if(nodes[i].type == 'folder')
            img = '<span><img src="/resource/sao/icon/folder_normal.png"></span>';
        else if(nodes[i].type == 'file')
            img = '<span><img src="/resource/sao/icon/file_normal.png"></span>';
        else if(nodes[i].type == 'jpg' || nodes[i].type == 'png' || nodes[i].type == 'gif')
            img = '<span><img src="/resource/sao/icon/Media/landskape_normal.png"></span>';

        var name = '<span class="file-name">' + nodes[i].name + '</span>';

        //item += checkbox;
        item += img;
        item += name;
        item += '</div>';

        //size
        var size = '<div class="item-fsize"> <span>-</span> </div>';
        item += size;

        //time
        var modify = '<div class="item-fdate"> <span>2017-02-28 18:23</span> </div>';
        item += modify;
        item += '</div>';

        html += item;
    }
    frame.innerHTML = html;

    $('.item-fname').click(function(){
        var fid = $(this).attr('fid');
        var type = $(this).attr('ftype');
        if(type == 'folder' && fid != '-1') {
            current_id = fid;
            getNodeList(fid);
        }
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