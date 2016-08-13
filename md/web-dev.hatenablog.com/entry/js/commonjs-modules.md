---
Title: JS：CommonJS と Modules の概要
Category:
- javascript
Date: 2016-08-08T14:25:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/commonjs-modules
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178877880
---

JavaScript の CommonJS と Modules といった仕様が気になって、少し調べてみました。今回は、その調査内容をまとめていこうと思います。


## CommonJS の概要
CommonJS とは、ブラウザ外の JavaScript（サーバサイドやデスクトップ向け）の仕様を定めるためのプロジェクトのことです。元々の名称は ServerJS で、CommonJS に変更されたようです。


## CommonJS の仕様
CommonJS は様々な仕様から構成されていて、全ての仕様が確定しているわけではないみたいです。その中でも、Modules, Packages, Promises, System といった仕様は確定しているみたいです。


## Modules の概要
Modules は、include 機構とも呼ばれています。ある JS （モジュール）を、別の JS から使えるようにする仕組みのようです。


## Modules の例
calc.js で関数 `add` を公開して、main.js から利用する例を書いてみました。

`calc.js`

```javascript
// public
exports.add = function(x, y) {
	return x + y;
}
// private, local function
var minus = function(x, y) {
	return x - y;
}
```

exports にセットした関数が、モジュール外部に公開されるようです。次の main.js で、公開した関数を呼び出してみます。

`main.js`

```javascript
var calc = require('calc');
calc.add(1, 2);  // 3
// calc.minus(1, 2); -> Error
```

`require(...)` で読み込んで使用します。


## 補足
CommonJS 自体は、Node.js によってすたれてきている、と発言する人もいるようです。


## 参考文献
- [CommonJS - Wikipedia, the free encyclopedia](https://en.wikipedia.org/wiki/CommonJS)
- [CommonJSの話](http://www.slideshare.net/terurou/common-js)
