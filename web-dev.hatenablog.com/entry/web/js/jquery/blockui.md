---
Title: jQuery BlockUI Plugin：Web画面の操作をブロック
Category:
- JS/CSS/HTML
Date: 2018-07-25T13:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/jquery/blockui
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178878992
---

jQuery Plugin の [BlockUI](http://jquery.malsup.com/block/) を使って、Webページを操作できないようにする方法を書いていきます。

使いどころとしては、

1. サーバー処理中とかに、ユーザーの操作を止めたい
2. ユーザーに処理中だと伝えたい（1と併用）
3. モーダルダイアログの代替

等々、になるのかなぁと思っています。

ブロック中にメッセージやフォームを表示できるので、ブロックだけではなく 2 や 3 といった使い方もできそうです。


## 画面イメージ
ブロック中の画面（デフォルト）は、次のような感じでした。

[f:id:mamorums:20180725114129p:plain]

上は [公式のサンプル画面](http://jquery.malsup.com/block/#page) で試したときのイメージです。[公式のデモ画面](http://jquery.malsup.com/block/#demos) にも色々なサンプルがありました。


## 使用例１：ボタン押下時にブロック
ボタン押下時に、日本語の「お待ちください。」を表示するサンプルを書いてみました。

[f:id:mamorums:20180725114149p:plain]

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>BlockUI サンプル</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<button id="btn">click</button>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://malsup.github.io/jquery.blockUI.js"></script>
<script>
$(function() {
  $('#btn').click(function() {
    $.blockUI({ 
      "message": "お待ちください。", 
      "css": {
        "padding": "10px 30px",
        "font-size": "20px",
        "font-weight": "bold"
      } 
    });
    setTimeout($.unblockUI, 3000); 
  });
});
</script>
</body>
</html>
```

jQuery と BlockUI の JSファイルを参照するようにして、ボタンが押されたときの処理をバインドしています。

今回はサンプルとして、タイムアウトしたとき（約３秒後）に `$.unblockUI` を実行して、ブロックを解除しています。実運用するアプリでは、何らかの処理が終わった時に実行する感じになると思います。



## 使用例２：Ajax通信中にブロック
Ajax通信中にブロックしたい場合は、オンロードのときに以下のスクリプトを実行するだけで良いみたいです。


```javascript
$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
```

※1. ＵＩ（メッセージとか）はデフォルトになります。  
※2. jQuery と BlockUI のファイルを参照する必要があります。
