/**
 * Created by KinderRiven on 2017/3/1.
 */

var root_id;

function getRootNode(){
    $.ajax({
        url: '/get_root.action',
        type: 'post',
        timeout : 1000,
        dataType : 'json',
        success: function (data) {
            console.log("获取文件根目录成功");
            root_id = data['root_id'];
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
            console.log("拉取文件列表成功");
            console.log(data);
        },
        error: function(data){
            console.log("拉取文件列表失败");
            console.log(data);
        }
    });
}

$(document).ready(function () {
    getRootNode();
});