/**
 * Created by Bill on 2016/4/12.
 */

function showtime(){
    var time = document.getElementById("time");
    var nowtime = new Date();
    time.innerHTML = nowtime;
}

showtime();
