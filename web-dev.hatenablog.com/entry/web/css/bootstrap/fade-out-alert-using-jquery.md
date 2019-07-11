---
Title: フェイドアウトするアラートをBootstrapとjQueryで実装
Category:
- JS/CSS/HTML
Date: 2018-11-29T09:48:37+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/bootstrap/fade-out-alert-using-jquery
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132677386401
---

Bootstrap と jQuery を使って、自動的にフェイドアウトするアラート（インフォメーション）を表示する方法を書いていきます。


## 1. イメージ
ボタン `info alert` を押すと、画面上部に水色のアラートが表示されて、

[f:id:mamorums:20181129094758p:plain]

時間がたつと徐々に薄くなって、

[f:id:mamorums:20181129094819p:plain]

約５秒ほどで完全に消えます。アラートが表示されているときに、右側の×ボタンをクリックしても消えます。

`warn alert` を押すと黄色のアラートが表示されて、同じように自動的に消えます。


## 2. コード例
サンプルコードは以下の通りです。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Fade Out Alert</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<style>
.alert-top {
    top:50px;
    width:100%;
    display:none;
    text-align: center;
    margin-bottom: 0;
    padding:10px;
}
.buttons {
  margin:30px;
}
</style>
</head>
<body>
<div id="alert-info" class="alert alert-info alert-top" role="alert">
  <button type="button" class="close alert-close" aria-label="Close"><span aria-hidden="true">×</span></button>
  <span class="alert-msg"></span>
</div>
<div id="alert-warn" class="alert alert-warning alert-top" role="alert">
  <button type="button" class="close alert-close" aria-label="Close"><span aria-hidden="true">×</span></button>
  <span class="alert-msg"></span>
</div>

<div class="buttons">
  <button class="btn btn-info" id="info">info alert</button>
  <button class="btn btn-warning" id="warn">warn alert</button>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script>
$(function() {
  Alert = {
    show: function($div, msg) {
      $div.find('.alert-msg').text(msg);
      if ($div.css('display') === 'none') {
        // fadein, fadeout.
        $div.fadeIn(1000).delay(2000).fadeOut(2000);
      }
    },
    info: function(msg) {
      this.show($('#alert-info'), msg);
    },
    warn: function(msg) {
      this.show($('#alert-warn'), msg);
    }
  }
  $('body').on('click', '.alert-close', function() {
  	$(this).parents('.alert').hide();
  });
  $('#info').click(function() {
    Alert.info('This is infomation alert.')
  });
  $('#warn').click(function() {
    Alert.warn('This is warning alert.')
  });
});
</script>
</body>
</html>
```

関数 `fadeIn`, `delay`, `fadeOut` を使って、

```js
// fadein, fadeout.
$div.fadeIn(1000).delay(2000).fadeOut(2000);
```

アラートを表示させてから、フェードアウトさせるようにしています。
