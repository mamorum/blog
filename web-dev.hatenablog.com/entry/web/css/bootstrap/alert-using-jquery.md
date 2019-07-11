---
Title: BootstrapとjQueryでアラートを表示
Category:
- JS/CSS/HTML
Date: 2018-08-09T08:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/bootstrap/alert-using-jquery
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132615512220
---

Bootstrap と jQuery を使って、Webページにアラート（インフォメーション）を表示する方法を書いていきます。


## 1. イメージ
ボタン `info alert` を押すと、画面上部に水色のアラートが表示されて、

[f:id:mamorums:20180829093545p:plain]

`warn alert` を押すと黄色のアラートが表示されます。

×ボタンを押すとアラートが消えます。


## 2. コード例
アラートを表示させるコードは以下の通りです。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
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
        $div.show();
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

Bootstrap は 3.3.4、jQuery は 2.1.3 を使っています。jQuery のバージョンは 1.12.ｘ でも大丈夫そうな気がします。（Bootstrap 3.x だと jQuery 1.12.x が推奨されてたような気がします。）
