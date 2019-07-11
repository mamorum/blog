---
Title: CSS：縦並びメニューの実装
Category:
- JS/CSS/HTML
Date: 2018-12-11T06:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/menu/vertical
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132677539448
---

CSS を使って、Webページに縦並びメニューを表示する方法を書いていきます。今回は `ul`, `li` タグを使って実装してます。


## 1. 画面イメージ
次のような表示になって、

[f:id:mamorums:20181129164408p:plain]

マウスをホバーしたメニューはグレーで色が付きます。


## 2. コード例
サンプルコードは以下の通りです。

```html
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>縦並びメニュー</title>
<style>
.menu {
  width:200px;
}
.menu ul {
  margin:0;
  padding:0;
  list-style: none;
}
.menu li a {
  display: block;
  padding: 5px;
  color: #000000;
  font-size: 14px;
  text-decoration: none;
}
.menu li a:hover {
  background: #eeeeee;
}
</style>
</head>
<body>
<div class="menu">
  <ul>
    <li><a href="#">ねこ</a></li>
    <li><a href="#">こねこ</a></li>
    <li><a href="#">しろねこ</a></li>
    <li><a href="#">みけねこ</a></li>
    <li><a href="#">まんちかん</a></li>
    <li><a href="#">しろちゃとら</a></li>
  </ul>
</div>
</body>
</html>
```

`list-style: none;` で、リスト要素の前につく黒丸を消しています。
