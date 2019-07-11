---
Title: JS：JSONのプロパティ存在チェック
Category:
- JS/CSS/HTML
Date: 2018-05-22T12:47:13+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/lang/check-if-json-property-exists
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971646866111
---

JavaScript で、JSON のプロパティが存在するかチェックする方法を書いていきます。

## 例
サンプルのコードは以下の通りです。

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8" /></head>
<body>
<script>
check({});
check({"name": "Tom"});
function check(json) {  
  if ('name' in json) console.log('name有り。');
  else console.log('name無し。');
}
</script>
</body>
</html>
```

関数 `check` で、引数の JSONプロパティをチェックしてます。実行結果（ログ出力）は次のようになります。

```
name無し。
name有り。
```


## 解説
次のように書けば大丈夫そうです。

```javascript
'プロパティ名' in 検査対象のJSON
```

存在する場合は `true`、しない場合は `false` が返ってきます。上の例だと if の括弧内がこれに該当してて、`'name' in json` と書いていました。


## 補足. デフォルトのプロパティを追加
プロパティが存在しない場合に、デフォルトを設定したいことがあるかもしれません。JavaScript だと次のように追加することができそうです。

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8" /></head>
<body>
<script>
let empty = {};
let tom = {"name": "Tom"};
setDefault(empty);
setDefault(tom);
console.log('Hello, ' + empty.name);
console.log('Hi, ' + tom.name);
function setDefault(json) {  
  if ('name' in json) return;
  else json.name = 'World';
}
</script>
</body>
</html>
```

実行結果は次のようになります。

```
Hello, World
Hi, Tom
```

プロパティが存在しない `empty` に、デフォルト値 `World` が設定されました。
