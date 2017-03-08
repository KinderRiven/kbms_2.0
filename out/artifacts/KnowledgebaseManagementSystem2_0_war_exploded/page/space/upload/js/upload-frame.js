/*
 * Created by KinderRiven on 2017/2/28.
 */

//if using debug
var upload_frame_debugger = false;

//allowed upload node type
var allowedFileList = [
    'PDF', 'TXT', 'DOC','DOCX',
    'MP3', 'MP4', 'AVI',
    'JPG', 'PNG', 'GIF'
];

//upload frame init function
function upload_frame_init(id){

    document.getElementById('upload-frame').innerHTML =
        '<form><div class="form-group"><input id="form-zh" type="file" name="file" multiple></div></form>'

    var frame = $('#' + id);    //select upload frame
    console.log(current_id);

    frame.fileinput({
        language : 'en',
        uploadUrl : '/file_upload.action',
        dropZoneTitle : '<strong>File Upload</strong>',
        showUpload : true,                          // 是否显示上传按钮
        showCaption : true,                         // 是否显示标题
        allowedFileExtensions : allowedFileList,    //允许上传的文件类型
        resizeImage: true,
        maxFileCount: 4,
        uploadExtraData : {
            'cur_id' : current_id
        }                        //额外附加信息
    }).on("filebatchuploadcomplete", function(){
        //debugger
        if(upload_frame_debugger){
            console.log("Upload complete.");
        }
        getNodeList(current_id);
    }); //upload complete run
}

$(document).ready(function () {

    //debugger
    if(upload_frame_debugger) {
        console.log("Loading upload-frame setting.");
    }

});

