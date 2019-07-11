---
Title: Googleフォントを使う
Category:
- JS/CSS/HTML
Date: 2018-07-26T10:00:22+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/use-google-fonts
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132604671219
---

[Googleフォント](https://fonts.google.com/) を使うと、Webページに珍しい文字（オシャレな文字）を表示してアクセントを加えることができます。

使いどころとしては、

- ロゴの代替
- ブランド名（サイト名）
- メニュー、見出し
- 等々

になるのかなぁと思っています。

CSS でフォントを読み込むので、クライアントに存在するか（フォントがインストールされているか）を気にしなくて良い点がメリットだと思います。

これから、Googleフォントの使用方法を書いていきます。


## 使用手順
流れとしては、こんな感じになるのかと思います。

1. [Googleフォントのページ](https://fonts.google.com/) で使いたいものを見つける
2. フォント の CSS を HTMLで読み込む
3. HTML の要素にフォントを指定する


## 使用例
[Anton](https://fonts.google.com/specimen/Anton) というフォントを使いたいとしたら（手順1）、

フォントの CSS を、

```
<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
```

といった感じで読み込みます（手順2）。

それから、

```
#brand {
  font-family: 'Anton', sans-serif;
  ・・・省略・・・
}
```

といった感じで、HTMLの要素にフォントを指定します（手順3）。

上のタグとスタイルは、フォントのページに記載されています。


## コード例
上のコードを含む、完全な HTML を書いてみました。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Googleフォントのサンプル</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
<style>
#brand {
  font-family: 'Anton', sans-serif;
  font-size: 40px;
  color: #248;
}
</style>
</head>
<body>
<div id="brand">Hello World</div>  
</body>
</html>
```

ブラウザで開くと、下のような文字が表示されます。

[f:id:mamorums:20180726100016p:plain]
