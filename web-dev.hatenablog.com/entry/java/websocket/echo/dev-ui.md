---
Title: WebSocket：エコーアプリのUI開発
Category:
- Java
Date: 2018-02-08T16:24:56+09:00
URL: https://web-dev.hatenablog.com/entry/java/websocket/echo/dev-ui
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971614522346
---

[前回](/entry/java/websocket/echo/dev-java) に引き続き、WebSocket のエコーアプリ（サーバサイドは Java）を作っていきます。今回は UI の開発なので、HTML, JavaScript, CSS で実装していきます。


※ HTML や JavaScript のファイルは、前回作成したプロジェクト（ディレクトリ階層）に保存します。必要に応じて [前回の記事](/entry/java/websocket/echo/dev-java) を参照して頂けると嬉しいです。


## 画面イメージ
今回作成する画面のイメージは、[動作確認の記事](/entry/java/websocket/echo/check) に掲載しています。


## 1. HTML
HTML で、文字列を送信する領域と表示する領域を書いていきます。

`ws-echo/src/main/webapp/index.html`

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>WebSocket Echo</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
</head>
<body>
<div id="main">
  <div id="in">
    <div id="form">
      <div><textarea id="txt"></textarea></div>
      <div><input type="button" id="send" value="送信"></div>
    </div>
  </div>
  <div id="out"></div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="main.js"></script>
</body>
</html>
```

JavaScript は jQuery と `main.js` を読み込むようにしてて、CSS は `main.css` で定義するようにしてます。


## 2. JavaScript
jQuery と WebSocket の API を使って、サーバーに文字列を送信したり、サーバーエコーを表示する処理を実装しています。

`ws-echo/src/main/webapp/main.js`

```javascript
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
```

ページ（`index.html`）が開かれたら、サーバーと WebSocket の接続をするようにしています。接続後に何もしないと接続が切れるみたいだったので、その際にアラートを表示するようにしてます。


## 3. CSS
サンプルなので必要ないかもしれませんが、少し見やすくなる？スタイルシートを作成してみました。

`ws-echo/src/main/webapp/main.css`

```css
body {
  font-size: 16px;
  font-family: sans-serif;
  background-color: #f5f5f5;
}
#main {
  width: 90%;
  margin: 0 auto;
  max-width: 500px;
}
#form {
  text-align: center;
  padding: 20px;
  background-color: #ffffff;
  border: 1px solid #bbb;
  border-radius: 5px;
}
#form #txt {
  width: 100%;
  margin-top: 10px;
  margin-bottom: 10px;
}
#out {
  margin-top: 50px;
}
#out .echo {  
  padding: 10px 20px;
  margin-top: 10px;
  background-color: #ffffff;
  border: 1px solid #bbb;
  border-radius: 5px;
}
#out .echo p {
  white-space: pre-wrap;
  word-wrap: break-word;
}
```


## 次回
次回以降は、作成したアプリをサーブレットコンテナに配備して動かします。組込みJetty で動かす記事と、Tomcat に war を配備して動かす記事を用意しています。

- [組込みJettyで起動](/entry/java/websocket/echo/embed-jetty)
- [Tomcatで起動](/entry/java/websocket/echo/deploy-tomcat)
