//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/list");
webSocket.onmessage = function (msg) { updateChat(msg) };
webSocket.onclose = function () { alert("WebSocket connection closed") };

function updateChat(msg) {
//    var data = JSON.parse(msg);
    alert(msg.data);
//    id("userlist").innerHTML = "";
//    data.userlist.forEach(function (user) {
//        insert("userlist", "<li>" + user + "</li>");
//    });

    var resultJSON = msg.data;
    var result = $.parseJSON(resultJSON);
    id("userlist").innerHTML = "";
    $.each(result, function(k, v) {
        //display the key and value pair
        insert("userlist", "<tr><td>" + k + "</td><td>" + v + "</td></tr>");
        alert(k + ' is ' + v);
    });

    //Helper function for inserting HTML as the first child of an element
    function insert(targetId, message) {
        id(targetId).insertAdjacentHTML("afterbegin", message);
    }

    //Helper function for selecting element by id
    function id(id) {
        return document.getElementById(id);
    }
}