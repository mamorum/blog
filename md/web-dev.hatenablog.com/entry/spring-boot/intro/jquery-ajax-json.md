---
Title: SpringBoot入門：jQueryでJSONを受信
Category:
- spring-boot
Date: 2016-06-10T16:15:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/jquery-ajax-json
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179106284
---

Spring Boot の Webアプリで、jQuery を使って JSON を受け取る方法を書きます。レスポンスの JSON は、記事「[JSONの返却](/entry/spring-boot/intro/response-json)」のコントローラから取得します。


## 前提
この記事は、入門記事「[JSONの返却](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. 画面の作成
jQuery を使う画面を作成します。コントローラ（`/hello`）から JSON を取得して、DOM要素（` .message`） に表示します。

`gssb/src/main/resources/public/jquery-ajax.html`

```html
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hello jQuery</title>
</head>
<body>
<div>
  <span class="label">Message : </span>
  <span class="message"></span>
</div>
</body>
<script src="https://code.jquery.com/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
$(function() {
  $.ajax({
    url: '/hello',
    method: 'get',
    cache: false
  }).then(function(data) {
    $('.message').text(data.message);
  });
});
</script>
</html>
```

Spring Boot の Web アプリは、`src/main/resources/public` or `src/main/resources/static` 配下に静的な資源（html, js, css, png, etc）を置くことが多いみたいです。


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > gradle bootRun
```


## 手順3. 確認
ブラウザで `http://localhost:8080/jquery-ajax.html` にアクセスして、次のように表示されれば成功です。

```txt
Message : Hello, World!
```


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
