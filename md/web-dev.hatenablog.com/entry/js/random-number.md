---
Title: JavaScript：ランダム整数値の取得
Category:
- javascript
Date: 2016-08-03T10:25:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/random-number
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178876869
---

JavaScript でランダム整数値を取得する方法を書いていきます。

次のように書くと、0 ～ n のランダム整数値が取得できます。

```javascript
var num = Math.floor(Math.random() * (n + 1));
```

## 応用編
配列からランダムな値を取りたい場合、次のように書くことができます。

```javascript
// 配列（添え字は 0 ～ 4）
var types = ["A", "B", "C", "D", "E"];

// ランダム整数値（types.length は 5）
var index = Math.floor(Math.random() * types.length);

// 配列から値を取得
var type = types[index];	
```
