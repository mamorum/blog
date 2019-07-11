---
Title: CSS：SNSへのシェアボタンを実装
Category:
- JS/CSS/HTML
Date: 2018-08-15T08:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/ssn-share-button
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132614894144
---

Web ページに、SNSへのシェアボタンを実装する方法を書いていきます。今回は Twitter, Facebook, Google+ を対象にしています。

※ ボタンの実装方法だけを書いています。シェアするための処理（やリンク？）は書いていません。


## 1. イメージ
下のような感じのシェアボタンになります。

[f:id:mamorums:20180827102540p:plain]

画面が小さいとロゴだけになります。

[f:id:mamorums:20180827102550p:plain]

CSS にメディアクエリーを入れてレスポンシブにしてます。


## 2. コード例
コードは以下の通りです。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />
<style>
.share {
  margin-top:50px;
}
.share ul {
  margin:0;
  padding:0;
  list-style:none;
}
.share ul:after {
  content:"";
  clear:both;
  display:block;
}
.share ul li {
  float:left;
  width: 33.333%;
}
.share ul li a {
  display:block;
  padding: 10px 5px;
  font-size:14px;
  text-decoration:none;
  text-align:center;
  color:#ffffff;
}
.tw {
  background-color:#55acee;
}
.fb {
  background-color:#3b5998;
}
.gp {
  background-color:#dd4b39;
}

@media (max-width: 599px) {
  .share span {
    display: none;
    text-indent:-9999px;
  }
}
</style>
</head>
<body>
<div class="share">
  <ul>
    <li class="tw"><a href="#"><i class="fa fa-twitter"></i> <span>Twitterでシェア</span></a></li>
    <li class="fb"><a href="#"><i class="fa fa-facebook-square"></i> <span>Facebookでシェア</span></a></li>
    <li class="gp"><a href="#"><i class="fa fa-google-plus"></i> <span>Google+でシェア</span></a></li>
    </ul>
</div>
</body>
</html>
```

各SNSのロゴは、Font Awesome を使って表示させてます。
