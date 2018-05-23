---
Title: CSSだけのアイコンフォント
Category:
- JS/CSS/HTML
Date: 2018-02-26T12:15:56+09:00
URL: https://web-dev.hatenablog.com/entry/web/css/icon-using-only-css
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971619816436
---

Web画面のアイコンフォントといえば [Font Awesome](https://fontawesome.com/) などが有名だと思います。ただ、１個か２個のアイコンだけ使うときに、もっとサイズが軽いものはないかと調べたことがありました。

今回はそのときに見つけた、CSS だけのアイコンフォントを２つメモっておこうと思います。


## 1. CSS ICON
[公式ページ](http://cssicon.space/#/)

[f:id:mamorums:20180226120932p:plain]

公式ページでアイコンをクリックすると、右側に HTML と CSS が表示されます。それをそのままコピペすれば、自分が作っているページに取り込めるようです。アイコンの検索もできるので便利です。


## 2. ICONO
[公式ページ](https://saeedalipoor.github.io/icono/)

[f:id:mamorums:20180226120944p:plain]

こちらはスタイルシートを読み込む感じです。公式ページを見る限りだと、CSS ICON よりフォントの種類が少ない気がします。


## 感想
良い点は、やはりサイズが軽いことですかね。特に CSS ICON は、１文字（１フォント）単位で組み込めるのですごい軽さです。

難点はサイズ変更でしょうか。フォントじゃないので、CSS の font-size が使えないような気がします。

他には、

- 色の設定も複雑かも（color も使えないような）
- アイコンの種類が少ない

といったところが難点になるのかもしれません。

