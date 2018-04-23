---
Title: Electron環境かどうかの確認方法
Category:
- JS
Date: 2018-03-19T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/js/electron/check-electron-env-or-not
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971625812102
---

Electron を使い始めたころ、Electron 用の資源（HTML, JS）を 純粋なWebアプリでも使いたいと思ったことがありました。当初は環境に依存しないように書いてたんですが、徐々に難しくなって、JavaScript で環境を判別して分岐させるようにしました。

今回はそのことについて書いていきます。


## 判別方法
方法はいくつかあると思うんですが、`require` が `undefined` になるかどうかで判別できました。

```javascript
if (typeof require == 'undefined') {
  //-> not electron
} else {
  //-> electron
}
```

Electron だと、`require('electron') ...` といった感じで書くことがあるので、`require` が `undefined` にはなりません。


## 注意事項
Web アプリでも `require` が成功する実装だと、上の方法は使えないと思います。


## 補足
Electron を使っていくうちに、上のような分岐は入れなくなっていきました。理由は Electron の資源を使いまわさないことにしたからです。Webアプリは Webアプリの資源、Electron は Electronの資源と割り切るようになりました。

そのことについては、また違う記事で書くかもしれません。
