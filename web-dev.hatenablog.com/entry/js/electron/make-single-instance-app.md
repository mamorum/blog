---
Title: Electron：アプリの二重起動防止
Category:
- JS/CSS/HTML
Date: 2018-03-14T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/js/electron/make-single-instance-app
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971625180868
---

Electron の API `app.makeSingleInstance(callback)` を使うと、アプリの二重起動を防げるみたいです。これからその方法について書いていきます。


## コード例
メインプロセスで次のように書いていきます。

```javascript
const {app, BrowserWindow} = require('electron');
let win = null;

・・・省略・・・

//-> 二重起動防止
let is2ndWin = app.makeSingleInstance(
  (cmd, pwd) => {
    if (win === null) return;
    if (win.isMinimized()) {
      win.restore();
    }
    win.focus();
  }
);
if (is2ndWin) app.quit();

・・・省略・・・

function createWindow() {
  win = new BrowserWindow(Object.assign(
    bounds, {
    "show": false,
    "backgroundColor": "#222", 

・・・省略・・・
```

## 説明
既にアプリが起動していると、`app.makeSingleInstance(...)` で `true` が返ってくるみたいです。その場合に `app.quit();` で終了してあげれば、最初に起動したアプリ（の画面）だけを残しておけます。

あと、アプリが起動していると、変数 `win`（`BrowserWindow`）が `null` じゃないみたいです。今回は `win.restore()` か `win.focus()` を実行して、最初に起動していたアプリ画面が前面に来るようにしています。この辺は任意になるのかと思います。


## 参考文献
下の GitHub のドキュメントを参考にさせて頂きました。

[app.makeSingleInstance(callback) - electron/app](https://github.com/electron/electron/blob/master/docs/api/app.md)
