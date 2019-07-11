---
Title: CSS：テキストの横幅設定
Category:
- JS/CSS/HTML
Date: 2018-09-25T09:37:34+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/text-and-maxwidth
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132639003268
---

CSS の `max-width` を使って、テキストの横幅を設定する方法を書いていきます。


## 画面イメージ
横幅の設定有無で、以下のように画面表示が変わってきます。

[f:id:mamorums:20180925093617p:plain]

上のテキストは横幅を設定してなくて、左から右まで目で追いかけて読む感じになります。下のテキストは横幅を最大600pxで指定してます。上のテキストよりは、目を左右に動かさなくて大丈夫そうです。


## コード例
上の画面イメージのコードは以下の通りです。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>テキストの表示サンプル</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: 'メイリオ', 'Hiragino Kaku Gothic Pro', sans-serif;
}
.article-full {
  margin-bottom:60px;
}
.article {
  max-width:600px;
  margin:0 auto;
}
</style>
</head>
<body>
<div class="article-full">
  <h1>横幅の指定なし</h1>
  <p>こちらのテキストは、CSSで横幅の指定をしてません。横幅を指定していないと、テキストがブラウザの幅に対応して広がります。ブラウザを横に広げすぎると、ディスプレイの端から端まで目で追う必要があるので、読むときに少し疲れてしまいそうです。</p>
</div>
<div class="article">
  <h1>横幅の指定あり</h1>
  <p>こちらのテキストは、CSSで横幅を最大 <code>600px</code> に指定しています。
  <p>横幅は <code>max-width: 600px;</code> で指定しています。横幅が <code>600px</code> よりも小さい場合、ブラウザがその幅に応じて文字を折り返してくれます。</p>
  <p>あとは <code>margin:0 auto;</code> を使って、左右のマージンを自動にしてます。これで、記事が真ん中に表示されるようになります。</p>
</div>
</body>
</html>
```


## まとめ
Webページでテキストを表示する場合、あまり横長にしないほうが読みやすいことがあると思います。

ワープロソフト（MS Word 等）も、デフォルトはA4縦向き横書きのものが多いと思います。リアルな本なども、あまり横長にしてないものが多い気がします。日本語の縦書きはちょっと例外ですが。
