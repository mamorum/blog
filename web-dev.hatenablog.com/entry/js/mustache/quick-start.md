---
Title: JS：mustache.js 入門
Category:
- JavaScript
Date: 2016-08-09T11:05:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/mustache/quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178919230
---

mustache.js は、テンプレートエンジン「[mustache](http://mustache.github.io/)」の JavaScript 実装です。mustahce の特徴の１つは、logic-less なところです。

これから、mustache.js の使用例を書いていこうと思います。


## 例１：Quick Example
最後の script タグで、`Mustache.render(template, obj)` を使ってレンダリングしています。

`usage.html`

```html
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title>mustache.js | Usage</title>
</head>
<body>
	<p></p>
<!-- jQuery と mustache.js を読み込む -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.2.0/mustache.min.js"></script>
<script>
$(function() {
	var obj = {
		title: "Joe",
		calc: function() {
			return 2+4;
		}
	};
	var template = "{{title}} spends {{calc}}";
	var output = Mustache.render(template, obj);

	$('p').text(output);  // -> Joe spends 6
});
</script>
</body>
</html>
```

変数 template の `{{title}}` と `{{calc}}` が、obj のプロパティと関数実行結果に置き換えられます。


## 例２：External Templates
外部のテンプレートファイル「hello.mst」を Ajax で GET して、レンダリングを行う例です。

`external-template.html`

```html
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title>mustache.js | External Templates</title>
</head>
<body>
	<div id="target">Loading...</div>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.2.0/mustache.min.js"></script>
<script>
$(function() {
	$.get('hello.mst', function(template) {
		var rendered = Mustache.render(template, {name: "Luke"});
		$('#target').html(rendered);  // -> Hello Luke!
	});
});
</script>
</body>
</html>
```

`hello.mst`

```
Hello {{name}}!
```

hello.mst の `{{name}}` が `Luke`（`{name: "Luke"}`）に置き換えられます。




## 例３：Sections
if, 繰り返しなどの例です。コードは一部省略して記載しています。

### 1. if (true/false の分岐)
値：

```json
{"person": false}
```

テンプレート：

```mustache
Shown.
{{#person}}
Never shown!
{{/person}}
```

結果：

```txt
Shown.
```


### 2. 配列（オブジェクト）
値：

```json
{
  "stooges": [
    { "name": "Moe" },
    { "name": "Larry" },
    { "name": "Curly" }
  ]
}
```

テンプレート：

```mustache
{{#stooges}}
<b>{{name}}</b>
{{/stooges}}
```

結果：

```html
<b>Moe</b>
<b>Larry</b>
<b>Curly</b>
```

### 3. 配列（文字列）
値：

```json
{
  "musketeers": ["Athos", "Aramis", "Porthos", "D'Artagnan"]
}
```

テンプレート：

```mustache
{{#musketeers}}
{{.}}
{{/musketeers}}
```

結果：

```txt
Athos
Aramis
Porthos
D'Artagnan
```

## 補足：タグのエスケープ
括弧２つ `{{property}}` で JSON のデータをレンダリングすると、HTML タグがエスケープ（サニタイジング）されるようです。

エスケープしたくない場合は、括弧３つ `{{{property}}}` か &付き `{{&property}}` を使うと良さそうです。


## まとめ
mustache.js を使うと、クライアントサイド（ブラウザ）でもテンプレートエンジンを使うことができます。サーバサイドから JSON を受け取ってレンダリングできるので、RESTful なシステムとの親和性も高いと思います。


## 今回のコード
GitHub にサンプルコードを置いています。

[ui/demo-mustachejs - GitHub](https://github.com/mamorum/blog/tree/master/code/ui/demo-mustachejs)


## 参考文献
[mustache.js - GitHub](https://github.com/janl/mustache.js/)
