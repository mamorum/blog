---
Title: Bootstrap4 への移行を断念
Category:
- 日記
Date: 2018-04-28T07:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/diary/2018/0428-stop-migration-to-bootstrap4
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971638021294
---

以前の記事「[Bootstrap 4.0.0 がリリースされてました](/entry/diary/2018/0207-bootstrap4-was-released)」で、

- [Bootstrap4 がリリース](https://twitter.com/getbootstrap/status/954061442940002304) されていたこと
- ブログのコードも新しいバージョンに移行したい

と書いたんですが、断念することにしました。


## 理由
### 画面がかなりくずれた
自分の書き方や使い方が悪かったのか、Bootstrap 3.x から移行したら画面がかなりくずれました。多くの部分を解析して、書き直さないとダメな感じがしました。

### サイズがデカい
Bootstrap4 は、3.x と同じくらいのサイズでした。よくよく考えると、ブログでつくった画面にはデカい気がしてきました。


## 今後
多くの部分を書き直すなら、軽い CSSフレームワークを使って書き直したいと思いました。[Pure CSS](https://purecss.io/) とかも、軽くて良いのかと。

あと、ようやく [CSS Flexbox](https://developer.mozilla.org/ja/docs/Web/CSS/CSS_Flexible_Box_Layout/Using_CSS_flexible_boxes) を使ってみたんですが、かなり便利だと思いました。CSSフレームワークを使わずに、書き直しても良さそうな気がしました。

やっぱり Bootstrap は、それなりの規模のちゃんとしたアプリに向いている気がしました。自分のブログのコードなんかは、１画面や２画面しかないので・・・。
