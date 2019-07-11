$( document ).ready(function() {
  //-> websocket
  var ws = new WebSocket("ws://localhost:8080/ws-echo/echo");
  ws.onopen = function(event) {
    console.log("@onopen");
  };
  ws.onmessage = function(event) {
    console.log("@onmessage");
    console.log(event.data);
    $('#out').prepend(
      '<div class="echo"><p>' +
      event.data + '</div>'
    );
  };
  ws.onclose = function(event) {
    console.log("@onclose");
    alert(
      'サーバーとの接続が切れました。\n' +
      'ページのリロードで再接続します。'
    );
  };
  //-> event
  var $textarea = $('#txt');
  $('#send').on('click', function(e) {
    var txt = $textarea.val();
    ws.send(txt);
    $textarea.val('');
  });
});
