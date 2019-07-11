---
Title: CSS：横並びメニューの実装
Category:
- JS/CSS/HTML
Date: 2018-12-05T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/menu/horizontal-and-colored
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132677404469
---

CSS を使って、Webページに横並びメニュー（水平メニュー）を表示する方法を書いていきます。今回の実装方法は、clearfix という手法を使っています。


## 1. 画面イメージ
サンプルで実装するイメージは以下の通りです。

[f:id:mamorums:20181129104734p:plain]

メニューに色も付けてて、マウスをホバーさせた時には少し暗い色にするようにしています。上は「診療の流れ」でホバーしているので、そこだけ少し暗くなっています。


## 2. コード例
コード例は以下の通りです。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>横並びメニュー</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.menu {
  margin-top:20px;
}
nav {
  background:#3F51B5;
}
ul {
  margin:0;
  padding:0;
  list-style:none;
}
ul:after {
  content:"";
  display:block;
  clear:both;
}
li {
  float:left;
  width:auto;
}
a {
  display:block;
  padding:15px 20px;
  color:#ffffff;
  text-decoration:none;
}
a:hover {
  background:#303f9f;
}
</style>
</head>
<body>
<div class="menu">
  <nav><ul>
    <li><a href="#">トップ</a></li>
    <li><a href="#">プロフィール</a></li>
    <li><a href="#">診療の流れ</a></li>
    <li><a href="#">診療時間</a></li>
    <li><a href="#">アクセス</a></li>    
  </ul></nav>
</div>
</body>
</html>
```

リストアイテム（`li`）を `float` にして、リストの最後（`ul:after`）で解除しているのがポイントになります。
