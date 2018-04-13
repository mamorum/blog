---
Title: Electron：レンダラーからメインのモジュールを使う
Category:
- Electron
Date: 2018-04-10T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/electron/use-main-from-renderer
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971631620408
---

Electron で開発していて、レンダラープロセスからメインのモジュールを使いたい時がありました。これから、そのときに調べた使用方法をまとめていきます。


## 方法
`remote` を使うと、メインプロセスのモジュールを呼び出すことができます。


## レンダラーのコード例
```javascript
const {app, shell} = require('electron').remote;
const path = require('path');
const fs = require("fs");

const file = path.join(
  app.getPath('userData'), 'feed.json'
);
```

上のように `remote` の `app` を取得してから、`app.getPath(...`（メインプロセスのAPI）を使います。下のように `remote` を使わないと、メインのモジュールを使うときにエラーになったりします。

```javascript
const {app, shell} = require('electron');
```


## 参考文献
[remote.md - electron](https://github.com/electron/electron/blob/master/docs/api/remote.md)
