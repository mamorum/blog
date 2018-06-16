---
Title: JS：括弧付き変数への代入
Category:
- JS/CSS/HTML
Date: 2018-04-19T07:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/lang/kakko-tsuki-hensu-dainyu
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971634777582
---

Electron を使ってたら、次のように括弧付き変数に代入するコードを見かけました。

```javascript
const {app, BrowserWindow} = require('electron');
```

今回は、この表現について調べたことをまとめていきます。


## 動作内容
上のコードは下のコードと同じような動きになるみたいです。

```javascript
const app = require('electron').app;
const BrowserWindow = require('electron').BrowserWindow;
```

`electron` オブジェクトの `app` と `BrowserWindow` がそれぞれ代入される感じです。


## 名称
Mozilla のページを見ると、[分割代入](https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment) と呼ばれているみたいです。

もっと具体的に言うと、上のコードは「オブジェクトの分割代入」に該当します。（配列とかも分割代入できるみたいです。）


## 感想
初めて見たときは戸惑ったんですが、慣れると便利だなと思いました。
