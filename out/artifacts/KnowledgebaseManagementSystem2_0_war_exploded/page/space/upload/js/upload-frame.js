/*
 * Created by KinderRiven on 2017/2/28.
 */

//if using debug
var upload_frame_debugger = true;

//allowed upload file type
var allowedFileList = [
    'PDF', 'TXT', 'DOC',    //word file
    'MP3', 'MP4', 'AVI',    //media file
    'JPG', 'PNG', 'GIF'     //image file
];

//upload frame init function
function upload_frame_init(id){

    var frame = $('#' + id);    //select upload frame

    frame.fileinput({
        language : 'zh',
        uploadUrl : '/file_upload.action',
        dropZoneTitle : '<strong>文件上传区</strong>',
        showUpload : true,                          // 是否显示上传按钮
        showCaption : true,                         // 是否显示标题
        allowedFileExtensions : allowedFileList,    //允许上传的文件类型
        uploadExtraData : {
            'uid' : 'kinderriven'
        }                        //额外附加信息
    }).on("filebatchuploadcomplete", function(result){
        //debugger
        if(upload_frame_debugger){
            console.log("Upload complete.");
            console.log(result);
        }
    }); //upload complete run
}

$(document).ready(function () {

    //debugger
    if(upload_frame_debugger) {
        console.log("Loading upload-frame setting.");
    }

    //inint upload-frame
    upload_frame_init('form-zh');
});
