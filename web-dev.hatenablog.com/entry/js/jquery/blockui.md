---
Title: jQuery Plugin：BlockUI（画面のブロック）
Category:
- JavaScript
Date: 2016-08-07T13:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/jquery/blockui
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178878992
---

Ajax 通信のときに、画面の操作をブロックしたいことがあったりします。jQuery Plugin の BlockUI を使うと、簡単に画面の操作をブロックすることができます。


## 画面イメージ
ブロック中の画面は、次のような感じです。
![blocking-display](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813082334.png)

以下に利用手順を書いていきます。


## 手順1. HTML の編集
BlockUI を使いたい HTML に、jQuery と BlockUI を追加します。

```html
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://malsup.github.io/jquery.blockUI.js"></script>
```

## 手順2. JavaScript の追加
次の JavaScript を追加して、HTML が読み込まれたら実行されるようにします。

```javascript
$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
```

これで、jQuery で Ajax 通信をするときに、画面がブロックされるようになります。


## デモ画面
下の Click ボタンを押すと、BlockUI で画面をブロックします。

<p class="codepen" data-height="180" data-theme-id="0" data-slug-hash="vOVLab" data-default-tab="result" data-user="mamoru2110">See the Pen <a href="http://codepen.io/mamoru2110/pen/vOVLab/">demo-blockui</a> by mamoru2110 (<a href="http://codepen.io/mamoru2110">@mamoru2110</a>) on <a href="http://codepen.io">CodePen</a>.</p>
<script src="//assets.codepen.io/assets/embed/ei.js" async=""></script>

メッセージ等は、変更できるようです。


## 参考文献
[jQuery BlockUI Plugin](http://malsup.com/jquery/block/)

