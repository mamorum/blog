---
Title: HTML：Canvasの文字がにじむ
Category:
- JS/CSS/HTML
Date: 2018-05-28T10:06:28+09:00
URL: https://web-dev.hatenablog.com/entry/web/html/canvas/moji-nijimu
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971648615941
---

HTML の Canvas に文字を表示したら、少しにじんでいることに気が付きました。これから、Canvas文字と通常文字の比較画像や、比較用のコードを掲載していきます。

※ Canvas文字をにじまないようにする方法は見つかっていません。


## 比較
メイリオを使って比較してみました。

### 16px
下が16px文字の比較画像です。上の文字がCanvasで、下が通常文字（Span要素）です。

[f:id:mamorums:20180528100454p:plain]

Canvas 文字がにじんでいて、文字色も少しグレーっぽくなっている気がします。


### 32px
下が32px文字の比較画像です。上の文字がCanvasで、下が通常文字です。

[f:id:mamorums:20180528100505p:plain]

Canvas 文字の輪郭が少しにじんでいるかなぁ、といった感じです。通常文字は輪郭がシャープな気がします。


## コード
比較するために使ったコード（HTML）は以下の通りです。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Canvas文字のにじみ</title>
<style>
canvas { display: block; }
span { font-family: 'Meiryo, sans-serif'; }
</style>
</head>
<body>
<div style="margin-left: 20px;">
  <!-- 16px -->
  <canvas id="c16" width="200" height="60"></canvas>
  <span style="font-size: 16px;">あいうえお</span>
  <!-- 32px -->
  <canvas id="c32" width="200" height="60"></canvas>
  <span style="font-size: 32px;">あいうえお</span>
</div>
<script>
//-> 16px
var c16 = document.getElementById("c16");
var ctx = c16.getContext("2d");
ctx.font = "16px Meiryo, sans-serif";
ctx.fillText("あいうえお", 0, 50);
//-> 32px
var c32 = document.getElementById("c32");
var ctx = c32.getContext("2d");
ctx.font = "32px Meiryo, sans-serif";
ctx.fillText("あいうえお", 0, 50);
</script>
</body>
</html>
```

