---
Title: JSON と JavaScript オブジェクトの違い
Category:
- javascript
Date: 2016-08-03T10:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/json-jsobject
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178877449
---

JSON と JavaScript オブジェクト について、プロパティ名（キー）の違いを書いています。

## JSON
JSON のプロパティ名は、引用符で囲んで表現します。

```json
{ "name": "太郎", "age": 42, "isAdmin": false }
```

## JavaScript オブジェクト
引用符で囲んでも囲まなくても、どちらでも大丈夫なようです。

```json
{ "name": "太郎", "age": 42, "isAdmin": false }
```

```javascript
{ name: "太郎", age: 42, isAdmin: false }
```

上の２つはどちらも有効です。


## 参考文献
- [JavaScript Object Notation - Wikipedia](https://ja.wikipedia.org/wiki/JavaScript_Object_Notation)
- [Working with Objects - JavaScript | MDN](https://developer.mozilla.org/ja/docs/Web/JavaScript/Guide/Working_with_Objects)
