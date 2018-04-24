---
Title: Electron：ウィンドウサイズの保存と設定
Category:
- JS/CSS/HTML
Date: 2018-03-10T08:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/js/electron/window/save-and-set-bounds
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971623223655
---

Electron アプリについて、画面サイズの保存方法と設定方法を書いていきます。


## 前提
Electron アプリは、デフォルトだとユーザがウィンドウサイズを変更できます。ただ、変更したサイズは保存されないので、メインプロセス内で保存と設定をする必要があります。


## コード例
メインプロセスのコード例（一部抜粋）は以下の通りです。

```javascript
const {app, BrowserWindow} = require('electron');
const path = require('path');
const fs = require("fs");

let win = null;

//-> ウィンドウサイズを保存するファイル
let boundsFile = path.join(
  app.getPath('userData'), 'bounds.json'
);
//-> 保存しておいたウィンドウサイズの取得
let bounds = null;
try {
  bounds = JSON.parse(
    fs.readFileSync(boundsFile, 'utf8')
  );
} catch (e) {
  bounds = {"width":1024,"height":768};
}
function createWindow() {
  //-> ウィンドウサイズの設定
  win = new BrowserWindow(Object.assign(
    bounds, {
    "show": false,
    "backgroundColor": "#222", 
    "icon": path.join(__dirname, 'icon/icon64.png')
  }));
  ・・・コード省略・・・
  //-> アプリ終了時にウィンドウサイズを保存
  win.on('close', () => { 
    fs.writeFileSync(
      boundsFile, JSON.stringify(win.getBounds())
    );
  });
}

app.on('ready', () => {
  createWindow();
});
```

他にもうまい書き方はあると思いますが、今回はこれをベースにまとめていきます。


## ウィンドウサイズの保存
保存するファイルを決めておいて、ウィンドウが `close` されるときに `BrowserWindow` の `getBounds()` をファイルに保存します。

上の例だと、

```javascript
//-> ウィンドウサイズを保存するファイル
let boundsFile = path.join(
  app.getPath('userData'), 'bounds.json'
);
・・・省略・・・
  //-> アプリ終了時にウィンドウサイズを保存
  win.on('close', () => { 
    fs.writeFileSync(
      boundsFile, JSON.stringify(win.getBounds())
    );
  });
・・・省略・・・
```

といった感じです。


Windows だと、`C:\Users\{ユーザ名}\AppData\Roaming\{アプリ名}\bounds.json` にサイズがJSONで保存されます。ちなみに、ウィンドウの位置（`x` と `y`）も保存されます。


## ウィンドウサイズの設定
ファイルからウィンドウサイズ（と位置）を取得して、`BrowserWindow` を `new` するときに渡してあげます。

上の例だと、

```javascript
//-> 保存しておいたウィンドウサイズの取得
let bounds = null;
try {
  bounds = JSON.parse(
    fs.readFileSync(boundsFile, 'utf8')
  );
} catch (e) {
  bounds = {"width":1024,"height":768};
}
function createWindow() {
  //-> ウィンドウサイズの設定
  win = new BrowserWindow(Object.assign(
    bounds, {
    "show": false,
    "backgroundColor": "#222", 
    "icon": path.join(__dirname, 'icon/icon64.png')
  }));
```

といった感じです。

今回はウィンドウサイズを他のプロパティと一緒に渡すので、`Object.assign` を使って JSON をマージしています。


## ウィンドウサイズの初期設定
アプリの初回起動時は `bounds.json` がないので、今回のコード例だと例外が発生します。

```javascript
} catch (e) {
  bounds = {"width":1024,"height":768};
}
```

そのため、上のように例外を catch して、ウィンドウサイズを初期設定しています。

ちなみに、`BrowserWindow` には、デフォルトのウィンドウサイズ（横800px, 縦600px）があるみたいです。それに従う場合は、コードを次のようにしておけば大丈夫そうです。

```javascript
} catch (e) {
  bounds = {};
}
```

これで、 `BrowserWindow` を `new` するときにサイズが渡らなくなります。


## 参考文献
[electron/browser-window](https://github.com/electron/electron/blob/master/docs/api/browser-window.md)

