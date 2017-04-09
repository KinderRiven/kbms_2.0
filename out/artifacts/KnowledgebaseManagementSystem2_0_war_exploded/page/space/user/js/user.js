

function loadUserInfo(){

    var uid = getCookieParam('id');
    var img = '<img src="/resource/image/user/' + uid + '.jpg">';
    document.getElementById('user-img').innerHTML = img;
}

$(document).ready(function(){
    loadUserInfo();
});