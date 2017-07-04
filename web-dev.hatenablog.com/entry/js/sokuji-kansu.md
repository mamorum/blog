---
Title: JavaScript：即時関数
Category:
- JS
Date: 2016-08-03T10:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/sokuji-kansu
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178876506
---

即時関数とは、定義した関数をすぐ使う書き方です。関数を `()` で囲んで、その後に `();` を書くと、囲んだ関数が実行されます。

構文としては、次のような感じになります。

```javascript
(function() {...} )();
```

## 例1. 引数なしの即時関数

```javascript
(function() {
	var x = 10, y = 20;
	console.log(x + y);	
})();
// 実行結果：30
```

## 例2. 引数ありの即時関数

```javascript
(function(y) {
	var x = 10;
	console.log(x + y);	
})(5);
// 実行結果：15
```

次のように、関数名を付けても大丈夫みたいです。

```javascript
(function hello(name) {
	console.log("Hello " + name);
})("Tom");
// 実行結果：Hello Tom
```

## 即時関数のメリット
即時関数内の変数名が、他の変数名と被らないということがあげられます。

