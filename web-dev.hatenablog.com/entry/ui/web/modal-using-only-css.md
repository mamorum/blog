---
Title: CSSだけでモーダル表示
Category:
- UI
Date: 2018-03-16T07:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/ui/web/modal-using-only-css
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971625789295
Draft: true
---

JavaScript や CSSフレームワークを使わずに、モーダルを表示したいときがありました。色々と調査していたら、CSS（と HTML）だけでモーダルを表示できる [Pure Css Modal](https://github.com/jorgechavz/pure-css-modal) というものを見つけました。

今回はそのことについて書いていきます。


## 画面デモ
[公式のGitHubページ](http://jorgechavz.github.io/pure-css-modal/) で、モーダルの表示を画面で確認できます。

モーダルの出現方法（中央から、左から中央、右から中央、等々）や、モーダルの大きさもカスタマイズできそうでした。


## 仕組み
Pure Css Modal のデモとソースを見てみたら、HTML のラベルとチェックボックスを使って表示していました。

ラベルをクリックすると隠れているチェックボックスがチェックされて、疑似要素（`input:checked`）のスタイルが有効になるのかと思いました。
