/**
 * Created by KinderRiven on 2017/3/5.
 */

var bool_login = false;
function getCookieParam(key){

    var cookie = (document.cookie + ';').split(' ');
    console.log(cookie);

    for(var i = 0; i < cookie.length; i++){
        var map = cookie[i].split('=');
        if(map[0] == key){
            return map[1].substr(0, map[1].length - 1);
        }
    }
}
function boolLogin(){

    var cookie = document.cookie;
    var c_list = cookie.split(';');

    for(var i = 0; i < c_list.length; i++){
        var cc_list = c_list[i].split('=');
        if(cc_list[0] == 'username')
            return true;
        console.log(cc_list);
    }
    return false;
}

$(document).ready(function(){

});