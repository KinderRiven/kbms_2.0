/**
 * Created by KinderRiven on 2017/4/8.
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

    var c_set_list = document.getElementById('modal-set');
    c_set_list.innerHTML = '';
    var item;

    for(var i = 0; i < data.length; i++){

        item = '<div class="modal-set-item clearfix" id="' + data[i].id + '">';
        item += '<div class="modal-set-img">';
        item += '<img src="/resource/image/set/' + data[i].id +  '.jpg">';
        item += '</div>';
        item += '<div class="modal-set-info">';
        item += '<div class="modal-set-name">'  + data[i].name + '</div>';
        item += '<div class="modal-set-description">' + data[i].description + '</div>';
        item += '</div>';
        item += '</div>';

        c_set_list.innerHTML += item;
    }

    $(".modal-set-item").click(function(){

        var set_id = $(this).attr('id');
        addDocToSet(set_id);
    });
}

function addDocToSet(set_id) {

    $.ajax({
        url: '/add_doc_set.action',
        type: 'post',
        timeout : 10000,
        dataType : 'json',
        data : {
            'set_id' : set_id,
            'node_id' : select_file
        },
        success: function (data) {
            if(data['result'] == 'yes') {
                alert('添加成功');
                $("#add_book").modal('hide');
            }
            else
                alert('添加失败');
        },
        error: function(data) {
            alert('添加失败');
        }
    });

}

$(document).ready(function(){

    getBookSet();

    $("#add_book").on('show.bs.modal', function () {})

});